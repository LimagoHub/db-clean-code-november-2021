package de.db.apfelmaennchen.gui.presenter.impl;

import de.db.apfelmaennchen.gui.PixelView;
import de.db.apfelmaennchen.gui.converter.PixelToComplexConverter;
import de.db.apfelmaennchen.gui.converter.impl.PixelToComplexConverterImpl;
import de.db.apfelmaennchen.gui.presenter.FunctionPresenter;
import de.db.apfelmaennchen.math.Komplex;
import de.db.apfelmaennchen.services.ComplexFunction;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FunctionPresenterImpl implements FunctionPresenter {

    private final Deque<PixelToComplexConverter> stack = new ArrayDeque<>();
    private final transient Logger logger = Logger.getLogger(getClass().getName());
    private final transient ComplexFunction complexFunction;
    private PixelView pixelView;
    private transient PixelToComplexConverter converter;

    public FunctionPresenterImpl(ComplexFunction complexFunction, PixelToComplexConverter converter) {
        this.complexFunction = complexFunction;
        this.converter = converter;
    }

    @Override
    public void setPixelView(PixelView pixelView) {
        this.pixelView = pixelView;
    }

    @Override
    public void zoomIn(int x1, int y1, int x2, int y2) {
        Komplex linkeUntereEcke = converter.convertCoordinatesToComplexNumber(x1, y1, pixelView.getImageSize());
        Komplex rechteObereEcke = converter.convertCoordinatesToComplexNumber(x2, y2, pixelView.getImageSize());
        double breite = rechteObereEcke.real - linkeUntereEcke.real;
        double hoehe = rechteObereEcke.imag - linkeUntereEcke.imag;
        stack.push(converter);
        converter = new PixelToComplexConverterImpl(linkeUntereEcke, Math.max(breite,hoehe));
        populateScreen();
    }

    @Override
    public void zoomOut() {
        if(! stack.isEmpty()) {
            converter = stack.pop();
        }
        populateScreen();
    }

    @Override
    public void populateScreen() {
        fillBufferedImage();
    }

    private void fillBufferedImage() {
        Instant start = Instant.now();
        for(int x = 0 ; x < pixelView.getImageSize() ; x ++ ){
            for(int y = 0; y < pixelView.getImageSize(); y ++) {
                int i = complexFunction.apply(converter.convertCoordinatesToComplexNumber(x, y, pixelView.getImageSize()));

                int rot = (i * 3) % 256;
                int gruen = (i * 5) % 256;
                int blau = (i * 11) % 256;
                int farbe = rot << 16 | gruen << 8 | blau;
                // image.setRGB(x,y, farbe);
                pixelView.getImageBuffer()[y * pixelView.getImageSize() + x] = farbe;
            }
        }
        Instant ende = Instant.now();
        logger.log(Level.INFO , "Duration = {0}", Duration.between(start,ende).toMillis());
        pixelView.updateImage();
    }

}
