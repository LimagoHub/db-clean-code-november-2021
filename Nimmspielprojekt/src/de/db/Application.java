package de.db;

import de.db.clients.GameClient;
import de.db.games.Game;
import de.db.games.takegame.TakeGameImpl;
import de.db.games.takegame.players.ComputerPlayer;
import de.db.games.takegame.players.HumanPlayer;
import de.db.games.takegame.players.OmaPlayer;
import de.db.io.ConsoleWriter;

public class Application {

    public static void main(String[] args) {
        TakeGameImpl game = new TakeGameImpl(new ConsoleWriter());
        game.addPlayer(new HumanPlayer());
        game.addPlayer(new ComputerPlayer());
        //game.addPlayer(new OmaPlayer());
        GameClient client = new GameClient(game);
        client.run();
    }
}
