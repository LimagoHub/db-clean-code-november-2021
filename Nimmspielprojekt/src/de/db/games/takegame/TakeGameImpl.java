package de.db.games.takegame;

import de.db.games.Game;

import java.util.Scanner;

public class TakeGameImpl implements Game {

    private final Scanner scanner = new Scanner(System.in);
    private int stones;
    private int turn;

    public TakeGameImpl() {
        stones = 23;

    }

    @Override
    public void play() {
        while( ! isGameover())  executeTurns();

    }

    private void executeTurns() {
        spielerzug();
        computerzug();
    }

    private void spielerzug() {
        if(isGameover()) return;
        executeHumanTurn();
        terminateTurn("Human");
    }

    private void executeHumanTurn() {
        while (spielerzugIsInvalid()){
            System.out.println("Ungueltiger Zug!");
        }
    }

    private boolean spielerzugIsInvalid() {
        spielerZugImpl();
        return ! isValid();
    }



    private void spielerZugImpl() {
        System.out.println(String.format("Es gibt %s Steine. Bitte nehmen Sie 1,2 oder 3", stones));
        turn = scanner.nextInt();
    }

    private void computerzug() {

        if(isGameover()) return;

        final int turns [] = {3,1,1,2};
        turn = turns[stones % 4];
        System.out.println(String.format("Computer nimmt %s Steine", turn));
        terminateTurn("Computer");
    }

    private void terminateTurn(String player) { // Integratiom
        updateGameState();
        checkLosing(player);
    }

    private void checkLosing(String player) { // Operatiom
        if(isGameover()) {
            System.out.println(String.format("%s hat verloren", player));
        }
    }

    private boolean isValid() {
        return turn >= 1 && turn <= 3;
    }
    private void updateGameState() {
        stones -= turn;
    }

    private boolean isGameover() {
        return stones < 1;
    }
}
