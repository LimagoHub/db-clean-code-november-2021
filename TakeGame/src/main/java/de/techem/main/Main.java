package de.techem.main;

import de.techem.client.GameClient;
import de.techem.games.AbstractGame;
import de.techem.games.takegame.TakeGameImpl;
import de.techem.games.takegame.player.ComputerPlayer;
import de.techem.games.takegame.player.HumanPlayer;
import de.techem.games.takegame.player.OmaPlayer;
import de.techem.io.ConsoleWriter;

public class Main {

	public static void main(String[] args) {
		AbstractGame<Integer, Integer> game = new TakeGameImpl(new ConsoleWriter());
		game.addPlayer(new HumanPlayer("Fritz"));
		//game.addPlayer(new HumanPlayer("Franz"));
		game.addPlayer(new ComputerPlayer());
		//game.addPlayer(new OmaPlayer());
		GameClient client = new GameClient(game);
		client.run();

	}

}
