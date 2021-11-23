package de.db.games.takegame.players;

import de.db.io.Writer;

import java.util.Scanner;

public class HumanPlayer extends AbstractTakeGamePlayer{
    private final Scanner scanner = new Scanner(System.in);

    public HumanPlayer() {
    }

    public HumanPlayer(String name) {
        super(name);
    }

    public HumanPlayer(Writer writer) {
        super(writer);
    }

    public HumanPlayer(Writer writer, String name) {
        super(writer, name);
    }

    @Override
    public int doTurn(int stones) {
        getWriter().write(String.format("Es gibt %s Steine. Bitte nehmen Sie 1,2 oder 3", stones));
        return scanner.nextInt();
    }
}
