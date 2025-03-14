package src.tictactoe;

import src.tictactoe.model.*;
import src.tictactoe.strategy.ColumnWinningStrategy;
import src.tictactoe.strategy.RowWinningStrategy;

import java.util.List;

public class Client {

    public static void main(String[] args) {


        GameController controller = GameController.getInstance();
        Player player1 = new HumanPlayer("Alex", 'A', 1, 1);
        Player player2 = new BotPlayer("Botty", 'B');

        Game game1 = controller.startNewGame(3,
                List.of(player1, player2),
                List.of(new RowWinningStrategy(), new ColumnWinningStrategy()));

        controller.display(game1);

        while (game1.getGameState() != GameState.WINNER_DECIDED && game1.getGameState() != GameState.DRAW) {
            controller.makeMove(game1);
            controller.display(game1);
        }

        if (game1.getGameState() == GameState.WINNER_DECIDED) {
            System.out.println("Winner is: " + game1.getWinner().getName());
        } else if (game1.getGameState() == GameState.DRAW) {
            System.out.println("Game ended in a draw!!!");
        }

    }

}
