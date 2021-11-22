package de.db.games.takegame;

import de.db.games.Game;

import java.util.Scanner;

public class TakeGameImpl implements Game {

    private final Scanner scanner = new Scanner(System.in);
    private int stones;
    private boolean gameover;

    public TakeGameImpl() {
        stones = 23;
        gameover = false;
    }

    @Override
    public void play() {
        while( ! gameover)  executeTurns();

    }

    private void executeTurns() {
        spielerzug();
        computerzug();
    }

    private void spielerzug() {
        int turn;
        while(true) {
            System.out.println(String.format("Es gibt %s Steine. Bitte nehmen Sie 1,2 oder 3!", stones));
            turn = scanner.nextInt();
            if( turn >= 1 && turn <=3) break;
            System.out.println("Ungueltiger Zug!");
        }
        stones -=  turn;
    }
    private void computerzug() {
        final int turns [] = {3,1,1,2};
        int turn;

        if(stones < 1) {
            System.out.println("Du Loser");
            gameover = true;
            return;
        }

        if(stones == 1) {
            System.out.println("Du hast nur Glück gehabt");
            gameover = true;
            return;
        }

        turn = turns[stones % 4];
        System.out.println(String.format("Computer nimmt %s Steine", turn));
        stones -=  turn;
    }
}
