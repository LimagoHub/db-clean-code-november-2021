package de.techem.games.players;

import de.techem.io.Writer;

public interface GamePlayer<BOARD,TURN> {
	
	String getName();
	TURN doTurn(final BOARD board);
	
	void setWriter(Writer writer) ;

}
