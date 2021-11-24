package de.db.apfelmaennchen;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;


public class MandelbrotView extends Frame {

	private static final int SIZE = 512;
	
	
	private Mandelbrot mandelbrot = new Mandelbrot();
	
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
		
	}
	
	
	
	
	@Override
	public void paint(Graphics g) {
		
		long ende, start = System.currentTimeMillis();
		for(int x = 0 ; x < SIZE ; x ++ ){
			for(int y = 0; y < SIZE; y ++) {
				int i = mandelbrot.iterate(mandelbrot.createC(x, y, SIZE));
				
				g.setColor(new Color((i * 3) % 256, (i * 5) % 256, (i * 11) % 256));
				
				g.drawLine(x, y, x+1, y+1);
			}
		}
		ende = System.currentTimeMillis();
		System.out.println("Duration = " + (ende -start));
	}
	
	public static void main(String[] args) {
		new MandelbrotView().setVisible(true);
	}
	
	class MyMouseListener extends MouseAdapter {
		Komplex linkeUntereEcke ;
		Deque<Mandelbrot> stack = new ArrayDeque<>();
		@Override
		public void mousePressed(MouseEvent e) {
			linkeUntereEcke = mandelbrot.createC(e.getX(), e.getY(), SIZE);
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			if(e.getButton() == MouseEvent.BUTTON1) {
				Komplex rechteObereEcke = mandelbrot.createC(e.getX(), e.getY(), SIZE);
				double breite = rechteObereEcke.real - linkeUntereEcke.real;
				double hoehe = rechteObereEcke.imag - linkeUntereEcke.imag;
				stack.push(mandelbrot);
				mandelbrot = new Mandelbrot(linkeUntereEcke, breite > hoehe? breite :hoehe);
			} else {
				if(! stack.isEmpty()) {
					mandelbrot = stack.pop();
				}
			}
			
			
			repaint();

		}
		
	}
}
