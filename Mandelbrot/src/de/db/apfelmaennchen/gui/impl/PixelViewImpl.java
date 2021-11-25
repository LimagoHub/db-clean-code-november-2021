package de.db.apfelmaennchen.gui.impl;

import de.db.apfelmaennchen.gui.PixelView;
import de.db.apfelmaennchen.gui.presenter.FunctionPresenter;



import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;



public class PixelViewImpl extends Frame implements PixelView {


	private static final int SIZE = 512;
	
	private final transient BufferedImage image = new BufferedImage(SIZE,SIZE, BufferedImage.TYPE_INT_RGB);


	private FunctionPresenter presenter;


	public PixelViewImpl( ) {

		addMouseListener(new MyMouseListener());
		setSize(SIZE,SIZE);
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});

	}


	@Override
	public void setFunctionPresenter(FunctionPresenter functionPresenter) {
		this.presenter = functionPresenter;
	}

	@Override
	public int getImageSize() {
		return SIZE;
	}

	@Override
	public int [] getImageBuffer() {
		return ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
	}

	@Override
	public void updateImage() {
		repaint();
	}

	@Override
	public void close() {
		dispose();
	}


	
	@Override
	public void paint(Graphics g) {
		g.drawImage(image, 0,0, this);
	}
	

	
	class MyMouseListener extends MouseAdapter {

		int x,y;
		@Override
		public void mousePressed(MouseEvent e) {
			x = e.getX();
			y = e.getY();

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			if(e.getButton() == MouseEvent.BUTTON1) {
				presenter.zoomIn(x,y,e.getX(),e.getY());
			} else {
				presenter.zoomOut();;
			}
		}
		
	}
}
