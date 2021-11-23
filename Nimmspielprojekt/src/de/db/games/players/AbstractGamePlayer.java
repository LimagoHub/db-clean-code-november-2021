package de.db.games.players;

import de.db.games.takegame.players.TakeGamePlayer;
import de.db.io.ConsoleWriter;
import de.db.io.Writer;

public abstract class AbstractGamePlayer<Board, Turn> implements GamePlayer<Board,Turn> {

    private String name = this.getClass().getSimpleName();
    private Writer writer = new ConsoleWriter();

    public AbstractGamePlayer() {

    }


    public AbstractGamePlayer(String name) {
        this.name = name;
    }

    public AbstractGamePlayer(Writer writer) {
        this.writer =writer;
    }

    public AbstractGamePlayer(Writer writer, String name) {
        this.name = name;
        this.writer =writer;
    }

    protected Writer getWriter() {
        return writer;
    }

    @Override
    public String getName() {
        return name;
    }

}