package src.tictactoe.factory;

import src.tictactoe.model.BotDifficultyLevel;
import src.tictactoe.strategy.BotPlayingStrategy;
import src.tictactoe.strategy.EasyBotPlayingStrategy;

public class BotPlayingStrategyFactory {

    BotPlayingStrategy botPlayingStrategy;

    public static BotPlayingStrategy getBotPlayingStrategy (BotDifficultyLevel botDifficultyLevel) {
        if (botDifficultyLevel == BotDifficultyLevel.EASY) {
            return new EasyBotPlayingStrategy();
        }
        return null;
    }
}
