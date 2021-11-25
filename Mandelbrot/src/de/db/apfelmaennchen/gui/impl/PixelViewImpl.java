package de.db.apfelmaennchen.gui.impl;

import de.db.apfelmaennchen.gui.PixelView;
import de.db.apfelmaennchen.gui.presenter.FunctionPresenter;



public class PixelViewImpl implements PixelView {




	private FunctionPresenter presenter;
	private final PixelViewFrameAdapter adapter = new PixelViewFrameAdapter(this);

	public PixelViewImpl( ) {

	}


	@Override
	public void setFunctionPresenter(FunctionPresenter functionPresenter) {
		this.presenter = functionPresenter;
	}

	@Override
	public FunctionPresenter getFunctionPresenter() {
		return presenter;
	}

	@Override
	public int getImageSize() {
		return adapter.getImageSize();
	}

	@Override
	public int [] getImageBuffer() {
		return adapter.getImageBuffer();
	}

	@Override
	public void updateImage() {
		adapter.updateImage();
	}

	@Override
	public void show() {
		adapter.setVisible(true);
	}

	@Override
	public void close() {
		adapter.close();
	}


	

}
