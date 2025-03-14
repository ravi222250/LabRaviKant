package src.tictactoe.model;

import src.tictactoe.factory.BotPlayingStrategyFactory;

public class BotPlayer extends Player {

    public BotPlayer(String name, Character symbol) {
        super(name, symbol, PlayerType.BOT);
    }

    @Override
    public Move chooseCellToMoveTo(Board board) {
        return BotPlayingStrategyFactory.getBotPlayingStrategy(BotDifficultyLevel.EASY)
                .chooseCellForBotMove(board, this.getSymbol());
    }
}
