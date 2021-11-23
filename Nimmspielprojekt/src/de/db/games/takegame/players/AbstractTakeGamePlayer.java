package de.db.games.takegame.players;

import de.db.io.ConsoleWriter;
import de.db.io.Writer;

public abstract class AbstractTakeGamePlayer implements TakeGamePlayer{

    private String name = this.getClass().getSimpleName();
    private Writer writer = new ConsoleWriter();

    public AbstractTakeGamePlayer() {

    }


    public AbstractTakeGamePlayer(String name) {
        this.name = name;
    }

    public AbstractTakeGamePlayer(Writer writer) {
        this.writer =writer;
    }

    public AbstractTakeGamePlayer(Writer writer, String name) {
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
