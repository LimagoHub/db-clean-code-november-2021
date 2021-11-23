package de.techem.games.takegame;

import de.techem.games.AbstractGame;
import de.techem.io.Writer;

public class TakeGameImpl extends AbstractGame<Integer, Integer> {
	
	
	public TakeGameImpl(final Writer writer) {
		super(writer);
		board = 23;
		
	}
	
	protected boolean isTurnValid() {
		return turn >= 1 && turn <= 3;
	}
	
	protected void updateBoard() {
		board -= turn;
	}
	
	protected boolean isGameOver() {
		return board < 1 || getPlayers().isEmpty();
	}
	

}
