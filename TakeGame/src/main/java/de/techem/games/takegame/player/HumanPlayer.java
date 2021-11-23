package de.techem.games.takegame.player;

import java.util.Scanner;

public class HumanPlayer extends AbstractTakeGamePlayer {

	private final Scanner scanner = new Scanner(System.in);
	private static final String USER_PROMPT = "Es gibt %s Steine. Bitte nehmen Sie 1,2 oder 3.\n";
	
	public HumanPlayer() {
		
	}

	public HumanPlayer(final String name) {
		super(name);
		
	}

	@Override
	public Integer doTurn(final Integer board) {
		System.out.printf(USER_PROMPT , board);
		return scanner.nextInt();
		
	}

}
