package de.db.apfelmaennchen.gui.converter.impl;


import de.db.apfelmaennchen.gui.converter.PixelToComplexConverter;
import de.db.apfelmaennchen.math.Komplex;

public class PixelToComplexConverterImpl implements PixelToComplexConverter {

    private Komplex linkeUntereEcke;
    private double breite;

    public PixelToComplexConverterImpl() {
        linkeUntereEcke = new Komplex(-2.0, -1.25);
        breite = 2.5;
    }

    public PixelToComplexConverterImpl(Komplex linkeUntereEcke, double breite) {
        this.linkeUntereEcke = linkeUntereEcke;
        this.breite = breite;
    }

    @Override
    public Komplex convertCoordinatesToComplexNumber(int x, int y, int size) {
        double delta = breite / (double) size;
        return new Komplex(linkeUntereEcke.real + x * delta, linkeUntereEcke.imag + y * delta);
    }

}
