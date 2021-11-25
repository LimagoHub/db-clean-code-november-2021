package de.db.apfelmaennchen.gui.converter;


import de.db.apfelmaennchen.math.Komplex;

public interface PixelToComplexConverter {
    public Komplex convertCoordinatesToComplexNumber(int x, int y, int size);
}
