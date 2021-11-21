package de.commands;

public abstract class AbstractCommand implements Command {

	@Override
	public void parse(String[] tokens) {
		

	}


	@Override
	public boolean isQuery() {
		return true;
	}

	@Override
	public void undo() {
		throw new UnsupportedOperationException("Häh?");

	}

}
