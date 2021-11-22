package de.db;

import de.db.clients.GameClient;
import de.db.games.Game;
import de.db.games.takegame.TakeGameImpl;

public class Application {

    public static void main(String[] args) {
        Game game = new TakeGameImpl();
        GameClient client = new GameClient(game);
        client.run();
    }
}
