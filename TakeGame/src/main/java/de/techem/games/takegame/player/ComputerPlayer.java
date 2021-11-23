package de.techem.games.takegame.player;

import de.techem.io.Writer;

public class ComputerPlayer extends AbstractTakeGamePlayer {

	private static final int TURNS [] = {3,1,1,2};
	public ComputerPlayer() {
		// Ok
	}

	public ComputerPlayer(String name) {
		super(name);
		
	}
	
	public ComputerPlayer(Writer writer) {
		setWriter(writer);
	}

	@Override
	public Integer doTurn(Integer board) {
		int turn = TURNS[board % 4];
		getWriter().write(String.format("Computer nimmt %s Steine.", turn));
		return turn;
	}

}
