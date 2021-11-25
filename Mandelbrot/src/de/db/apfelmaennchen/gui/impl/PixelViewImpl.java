package de.db.apfelmaennchen.gui.impl;

import de.db.apfelmaennchen.gui.PixelView;
import de.db.apfelmaennchen.gui.converter.PixelToComplexConverter;
import de.db.apfelmaennchen.gui.converter.impl.PixelToComplexConverterImpl;
import de.db.apfelmaennchen.math.Komplex;
import de.db.apfelmaennchen.services.ComplexFunction;


import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PixelViewImpl extends Frame implements PixelView {

	private final transient Logger logger = Logger.getLogger(getClass().getName());
	private static final int SIZE = 512;
	
	private final transient BufferedImage image = new BufferedImage(SIZE,SIZE, BufferedImage.TYPE_INT_RGB);
	private final transient ComplexFunction complexFunction;
	private transient PixelToComplexConverter converter;
	
	public PixelViewImpl(ComplexFunction complexFunction, PixelToComplexConverter converter ) {
		this.complexFunction = complexFunction;
		this.converter = converter;
		addMouseListener(new MyMouseListener());
		setSize(SIZE,SIZE);
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		fillBufferedImage();
	}
	

	public int [] getImageBuffer() {
		return ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
	}
	private void fillBufferedImage() {
		Instant start = Instant.now();
		for(int x = 0 ; x < SIZE ; x ++ ){
			for(int y = 0; y < SIZE; y ++) {
				int i = complexFunction.apply(converter.convertCoordinatesToComplexNumber(x, y, SIZE));

				int rot = (i * 3) % 256;
				int gruen = (i * 5) % 256;
				int blau = (i * 11) % 256;
				int farbe = rot << 16 | gruen << 8 | blau;
				// image.setRGB(x,y, farbe);
				getImageBuffer()[y * SIZE + x] = farbe;
			}
		}
		Instant ende = Instant.now();
		logger.log(Level.INFO , "Duration = {0}", Duration.between(start,ende).toMillis());
	}
	
	@Override
	public void paint(Graphics g) {

		g.drawImage(image, 0,0, this);


	}
	

	
	class MyMouseListener extends MouseAdapter {
		Komplex linkeUntereEcke ;
		Deque<PixelToComplexConverter> stack = new ArrayDeque<>();
		@Override
		public void mousePressed(MouseEvent e) {
			linkeUntereEcke = converter.convertCoordinatesToComplexNumber(e.getX(), e.getY(), SIZE);
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			if(e.getButton() == MouseEvent.BUTTON1) {
				Komplex rechteObereEcke = converter.convertCoordinatesToComplexNumber(e.getX(), e.getY(), SIZE);
				double breite = rechteObereEcke.real - linkeUntereEcke.real;
				double hoehe = rechteObereEcke.imag - linkeUntereEcke.imag;
				stack.push(converter);
				converter = new PixelToComplexConverterImpl(linkeUntereEcke, Math.max(breite,hoehe));
			} else {
				if(! stack.isEmpty()) {
					converter = stack.pop();
				}
			}
			
			fillBufferedImage();
			repaint();

		}
		
	}
}
