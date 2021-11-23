package de.techem.games.takegame.player;

import java.util.Random;

public class OmaPlayer extends AbstractTakeGamePlayer {

	private final Random random = new Random();
	@Override
	public Integer doTurn(Integer board) {
		
		return random.nextInt(3) + 1;
	}

}
