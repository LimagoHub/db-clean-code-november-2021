package de.db.games.takegame.players;

import java.util.Random;

public class OmaPlayer extends  AbstractTakeGamePlayer{

    private final Random random = new Random();

    public OmaPlayer() {
    }

    public OmaPlayer(String name) {
        super(name);
    }

    @Override
    public int doTurn(int stones) {
        return random.nextInt(5) + 1;
    }
}
