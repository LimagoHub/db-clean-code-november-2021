package de.db.games.takegame.players;

public class ComputerPlayer extends AbstractTakeGamePlayer{
    private  static final int TURNS[] = {3,1,1,2};

    public ComputerPlayer() {
    }

    public ComputerPlayer(final String name) {
        super(name);
    }

    @Override
    public int doTurn(final int stones) {

        final int turn = TURNS[stones % 4];
        System.out.println(String.format("Computer nimmt %s Steine", turn));
        return turn;
    }
}
