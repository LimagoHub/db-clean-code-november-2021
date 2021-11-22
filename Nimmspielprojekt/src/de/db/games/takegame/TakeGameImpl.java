package de.db.games.takegame;

import de.db.games.Game;
import de.db.games.takegame.players.TakeGamePlayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TakeGameImpl implements Game {

    private final Scanner scanner = new Scanner(System.in);
    private int stones;
    private int turn;
    private List<TakeGamePlayer> players = new ArrayList<>();

    public void addPlayer(TakeGamePlayer player) {
        players.add(player);
    }
    public void removePlayer(TakeGamePlayer player) {
        players.remove(player);
    }

    public TakeGameImpl() {
        stones = 23;

    }

    @Override
    public void play() {
        while( ! isGameover())  executeTurns();

    }

    private void executeTurns() {
        for (TakeGamePlayer player: players) {
            executeSinglePlayerTurn(player);
        }
    }

    private void executeSinglePlayerTurn(TakeGamePlayer player) {
        if(isGameover()) return;
        executeTurn(player);
        terminateTurn(player);
    }

    private void executeTurn(TakeGamePlayer player) {
        while (playerImpl(player)){
            System.out.println("Ungueltiger Zug!");
        }
    }

    private boolean playerImpl(TakeGamePlayer player) {
        turn =  player.doTurn(stones);
        return ! isValid();
    }







    private void terminateTurn(TakeGamePlayer player) { // Integratiom
        updateGameState();
        checkLosing(player);
    }

    private void checkLosing(TakeGamePlayer player) { // Operatiom
        if(isGameover()) {
            System.out.println(String.format("%s hat verloren", player.getName()));
        }
    }

    private boolean isValid() {
        return turn >= 1 && turn <= 3;
    }
    private void updateGameState() {
        stones -= turn;
    }

    private boolean isGameover() {
        return stones < 1 || players.isEmpty();
    }
}
