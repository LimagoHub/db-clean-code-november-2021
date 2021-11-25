package de.db.apfelmaennchen.gui;

import de.db.apfelmaennchen.gui.converter.PixelToComplexConverter;
import de.db.apfelmaennchen.gui.converter.impl.PixelToComplexConverterImpl;
import de.db.apfelmaennchen.math.Komplex;
import de.db.apfelmaennchen.services.ComplexFunction;
import de.db.apfelmaennchen.services.impl.MandelbrotFunction;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayDeque;
import java.util.Deque;


public class MandelbrotView extends Frame {

	private static final int SIZE = 512;
	
	private BufferedImage image = new BufferedImage(SIZE,SIZE, BufferedImage.TYPE_INT_RGB);
	private ComplexFunction complexFunction = new MandelbrotFunction();
	private PixelToComplexConverter converter = new PixelToComplexConverterImpl();
	
	public MandelbrotView() {
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
	

	private void fillBufferedImage() {
		long ende, start = System.currentTimeMillis();
		for(int x = 0 ; x < SIZE ; x ++ ){
			for(int y = 0; y < SIZE; y ++) {
				int i = complexFunction.apply(converter.convertCoordinatesToComplexNumber(x, y, SIZE));

				int rot = (i * 3) % 256;
				int gruen = (i * 5) % 256;
				int blau = (i * 11) % 256;
				int farbe = rot << 16 | gruen << 8 | blau;
				image.setRGB(x,y, farbe);

			}
		}
		ende = System.currentTimeMillis();
		System.out.println("Duration = " + (ende -start));
	}
	
	@Override
	public void paint(Graphics g) {

		g.drawImage(image, 0,0, this);


	}
	
	public static void main(String[] args) {
		new MandelbrotView().setVisible(true);
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
				converter = new PixelToComplexConverterImpl(linkeUntereEcke, breite > hoehe? breite :hoehe);
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
