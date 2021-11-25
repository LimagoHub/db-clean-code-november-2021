package de.db.apfelmaennchen.gui.presenter;

import de.db.apfelmaennchen.gui.PixelView;

public interface FunctionPresenter {

    void setPixelView(PixelView pixelView);
    void zoomIn(int x1, int y1,int x2, int y2);
    void zoomOut();
    void populateScreen();
}
