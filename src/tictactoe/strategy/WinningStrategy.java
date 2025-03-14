package src.tictactoe.strategy;

import src.tictactoe.model.Board;
import src.tictactoe.model.Move;

public interface WinningStrategy {
    public boolean checkWinner(Board board, Move move);

    void handleUndo(Move lastMove);
}
