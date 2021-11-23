package de.db.games.takegame.players;

import de.db.io.Writer;

public class ComputerPlayer extends AbstractTakeGamePlayer{
    private  static final int TURNS[] = {3,1,1,2};

    public ComputerPlayer() {
    }

    public ComputerPlayer(String name) {
        super(name);
    }

    public ComputerPlayer(Writer writer) {
        super(writer);
    }

    public ComputerPlayer(Writer writer, String name) {
        super(writer, name);
    }

    @Override
    public int doTurn(final int stones) {

        final int turn = TURNS[stones % 4];
        getWriter().write(String.format("Computer nimmt %s Steine", turn));
        return turn;
    }
}
