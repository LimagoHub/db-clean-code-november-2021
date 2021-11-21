package de.commands;

public interface Command {
	
	void parse(String [] tokens);
	void execute();
	boolean isQuery();
	void undo();

}
