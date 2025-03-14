package src.tictactoe.strategy;

import src.tictactoe.model.Board;
import src.tictactoe.model.Move;

public interface BotPlayingStrategy {

    public Move chooseCellForBotMove(Board board, Character symbol);
}
