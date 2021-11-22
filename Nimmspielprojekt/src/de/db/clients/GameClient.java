package de.db.clients;

import de.db.games.Game;

import java.util.Iterator;

public class GameClient {

    private final Game game;

    public GameClient(final Game game) {

          this.game = game;
    }

    public void run() {
        game.play();
    }

}
