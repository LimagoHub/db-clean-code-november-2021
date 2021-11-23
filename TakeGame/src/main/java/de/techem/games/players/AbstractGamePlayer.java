package de.techem.games.players;

import de.techem.io.ConsoleWriter;
import de.techem.io.Writer;

public abstract class AbstractGamePlayer<BOARD,TURN> implements GamePlayer<BOARD,TURN> {
	
	
	private String name = this.getClass().getSimpleName();
	private Writer writer = new ConsoleWriter();
	
	protected AbstractGamePlayer() {
		
	}
	
	public Writer getWriter() {
		return writer;
	}

	public void setWriter(Writer writer) {
		this.writer = writer;
	}

	

	public AbstractGamePlayer(String name) {
		this.name = name;
	}
	
	
	@Override
	public String getName() {
		return name;
	}
	
}
