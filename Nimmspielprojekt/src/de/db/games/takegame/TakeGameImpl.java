package de.db.games.takegame;

import de.db.games.Game;
import de.db.games.takegame.players.TakeGamePlayer;
import de.db.io.Writer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 */
public class TakeGameImpl implements Game {






    public TakeGameImpl(Writer writer) {
        stones = 23;
        this.writer = writer;
    }

    @Override
    public void play() {
        while( ! isGameover())  executeTurns();
    }

    private void executeTurns() {
        for (TakeGamePlayer player: players) {
            executeTurnForPlayer(player);
        }
    }

    /*

     */
    private void executeTurnForPlayer(TakeGamePlayer player) { // sdfsdf
        currentPlayer = player;
        executeSingleTurn();
    }

    private void executeSingleTurn() {
        if(isGameover()) return;
        executeTurn();
        terminateTurn();
    }

    private void executeTurn() {
        do{
            turn =  currentPlayer.doTurn(stones);
        }
        while (invalidTurn());
    }

    private boolean invalidTurn() {
        if(isValid()) return false;
        print(INVALID_TURN);
        return true;
    }

    private void terminateTurn() { // Integratiom
        updateGameState();
        checkLosing();
    }

    private void checkLosing() { // Operatiom
        if(isGameover()) {
            print(String.format(GAME_OVER_MESSAGE, currentPlayer.getName()));
        }
    }

    private boolean isValid() {
        return turn >= 1 && turn <= 3;
    }
    private void updateGameState() {
        stones -= turn;
    }

    protected boolean isGameover() {
        return stones < 1 || players.isEmpty();
    }

    private void print(String message) {
        writer.write(message);
    }
}
