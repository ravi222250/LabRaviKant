package src.tictactoe.model;

import src.tictactoe.strategy.WinningStrategy;

import java.util.List;
import java.util.stream.Collectors;

public class GameController {

    private static GameController gameController;

    private GameController() {}

    public static GameController getInstance() {
        if (gameController == null) {
            synchronized (GameController.class) {
                if (gameController == null) {
                    gameController = new GameController();
                }
            }
        }
        return gameController;
    }

    public Game startNewGame(int size, List<Player> players, List<WinningStrategy> winningStrategies) {
        System.out.println("New game starting: "
                + players.stream().map(Player::getName).collect(Collectors.joining(" vs ")));
        return new Game(size, players, winningStrategies);
    }

    public void display(Game game) {
        game.display();
    }

    public void makeMove(Game game) {
        game.makeMove();
    }

//    public void undo(Game game) {
//        game.undo();
//    }
}
