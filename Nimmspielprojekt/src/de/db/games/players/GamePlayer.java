package de.db.games.players;

public interface GamePlayer<Board, Turn> {

    String getName();
    Turn doTurn(Board board);
}
