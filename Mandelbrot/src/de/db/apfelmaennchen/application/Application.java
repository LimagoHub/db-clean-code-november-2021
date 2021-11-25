package de.db.apfelmaennchen.application;

import de.db.apfelmaennchen.gui.PixelViewImpl;
import de.db.apfelmaennchen.gui.converter.PixelToComplexConverter;
import de.db.apfelmaennchen.gui.converter.impl.PixelToComplexConverterImpl;
import de.db.apfelmaennchen.services.ComplexFunction;
import de.db.apfelmaennchen.services.impl.MandelbrotFunction;

public class Application {
    public static void main(String[] args) {
        ComplexFunction complexFunction = new MandelbrotFunction();
        PixelToComplexConverter converter = new PixelToComplexConverterImpl();
        new PixelViewImpl(complexFunction,converter).setVisible(true);
    }
}
