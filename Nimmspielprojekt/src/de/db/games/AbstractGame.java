package de.db.games;

import de.db.games.players.GamePlayer;
import de.db.games.takegame.players.TakeGamePlayer;
import de.db.io.Writer;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractGame<Board, Turn> implements Game{

    public static final String INVALID_TURN = "Ungueltiger Zug!";
    public static final String GAME_OVER_MESSAGE = "%s hat verloren";
    private final Writer writer;

    private Board board;
    private Turn turn;

    private GamePlayer<Board, Turn> currentPlayer;

    private final List<GamePlayer<Board,Turn>> players = new ArrayList<>();

    public void addPlayer(GamePlayer<Board,Turn> player) {
        players.add(player);
    }
    public void removePlayer(GamePlayer<Board,Turn> player) {
        players.remove(player);
    }


    public AbstractGame(Writer writer) {
        this.writer = writer;
    }

    @Override
    public void play() {
        while( ! isGameover())  executeTurns();
    }

    protected abstract boolean isGameover();
}
