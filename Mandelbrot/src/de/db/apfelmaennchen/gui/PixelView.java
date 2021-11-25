package de.db.apfelmaennchen.gui;

import de.db.apfelmaennchen.gui.presenter.FunctionPresenter;

public interface PixelView {

    void setFunctionPresenter(FunctionPresenter functionPresenter);

    // Fenstergroesse und Breite
    public int getImageSize();

    // Zeichenfeld
    public int[] getImageBuffer() ;

    // Neuzeichnen
    public void updateImage() ;


    // Anzeigen und Schliessen
    public void show();

    public void close();
}
