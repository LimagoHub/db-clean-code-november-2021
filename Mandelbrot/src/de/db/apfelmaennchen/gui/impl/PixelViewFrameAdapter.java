package de.db.apfelmaennchen.gui.impl;

import de.db.apfelmaennchen.gui.PixelView;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

class PixelViewFrameAdapter extends Frame {

    private static final int SIZE = 1024;
    private final BufferedImage image = new BufferedImage(SIZE,SIZE,BufferedImage.TYPE_INT_RGB);
    private final PixelView pixelView;

    PixelViewFrameAdapter(PixelView pixelView) {
        this.pixelView = pixelView;
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
    public int[] getImageBuffer() {
        return ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
    }

    public void updateImage() {
        repaint();
    }

    public int getImageSize() {
        return SIZE;
    }

    public void close() {
        dispose();
    }

    @Override
    public void paint(Graphics g) {	g.drawImage(image, 0, 0, this); }

    class MyMouseListener extends MouseAdapter {
        int x, y;

        @Override
        public void mousePressed(MouseEvent e) {
            x = e.getX();
            y = e.getY();
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if (e.getButton() == MouseEvent.BUTTON1) {
                pixelView.getFunctionPresenter().zoomIn(x, y, e.getX(), e.getY());
            } else {
                pixelView.getFunctionPresenter().zoomOut();
            }
        }

    }
}