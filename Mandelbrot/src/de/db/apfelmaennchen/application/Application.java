package de.db.apfelmaennchen.application;

import de.db.apfelmaennchen.gui.PixelView;
import de.db.apfelmaennchen.gui.impl.PixelViewImpl;
import de.db.apfelmaennchen.gui.converter.PixelToComplexConverter;
import de.db.apfelmaennchen.gui.converter.impl.PixelToComplexConverterImpl;
import de.db.apfelmaennchen.gui.presenter.FunctionPresenter;
import de.db.apfelmaennchen.gui.presenter.impl.FunctionPresenterImpl;
import de.db.apfelmaennchen.services.ComplexFunction;
import de.db.apfelmaennchen.services.impl.MandelbrotFunction;

public class Application {
    public static void main(String[] args) {
        ComplexFunction complexFunction = new MandelbrotFunction();
        PixelToComplexConverter converter = new PixelToComplexConverterImpl();

        FunctionPresenter presenter = new FunctionPresenterImpl(complexFunction, converter);
        PixelView view = new PixelViewImpl();

        presenter.setPixelView(view);
        view.setFunctionPresenter(presenter);

        presenter.populateScreen();
        view.show();


    }
}
