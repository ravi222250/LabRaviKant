package src.tictactoe.model;

import lombok.Getter;
import lombok.Setter;
import src.tictactoe.strategy.WinningStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Getter
@Setter
public class Game {
    private int size;
    private Board board;
    private List<Player> players;
    private int nextPlayerIndex;
    private List<Move> moves;
    private GameState gameState;
    private Player winner;
    private List<WinningStrategy> winningStrategies;

    public Game(int size, List<Player> players, List<WinningStrategy> winningStrategies) {
        this.size = size;
        this.players = players;
        this.winningStrategies = winningStrategies;
        this.moves = new ArrayList<>();
        this.nextPlayerIndex = 0;
        this.winner = null;
        this.gameState = GameState.NOT_STARTED;
        board = new Board(size);
    }

    public void display() {
        board.display();
    }

    public void makeMove() {
        Player player = players.get(nextPlayerIndex);
        System.out.println();
        System.out.println("Next turn to play is for: " + player.getName());
        Move move = player.chooseCellToMoveTo(board);
        if (player.getPlayerType() == PlayerType.HUMAN) {
            if (!validateMove(move)) {
                System.out.println("MOVE IS INVALID!!! TRY AGAIN....");
                return;
            }
        }

        commitMoveToBoard(move);

        for (WinningStrategy winningStrategy: winningStrategies) {
            if (winningStrategy.checkWinner(board, move)) {
                gameState = GameState.WINNER_DECIDED;
                winner = player;
                return;
            }
        }

        if (checkDraw()) {
            gameState = GameState.DRAW;
            return;
        }

        if (player.getPlayerType() == PlayerType.HUMAN) {
            display();
            System.out.println("Do you want to undo last move? (y/n)");
            String choice = new Scanner(System.in).nextLine();
            if (choice.equalsIgnoreCase("y")) {
                undo();
            }
        }

    }

    private boolean checkDraw() {
        if (size*size == moves.size()){
            return true;
        }
        return false;
    }

    private void commitMoveToBoard(Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        Character symbol = move.getSymbol();

        Cell cellToUpdate = board.getGrid().get(row).get(col);
        cellToUpdate.setCellState(CellState.FILLED);
        cellToUpdate.setSymbol(symbol);

        // rotate player
        nextPlayerIndex++;
        nextPlayerIndex = nextPlayerIndex % players.size();

        // add to move list
        moves.add(move);
    }

    private boolean validateMove(Move move) {
        if (move.getCell().getRow() >= size || move.getCell().getCol()>=size) {
            return false;
        }
        if (board.getGrid().get(move.getCell().getRow()).get(move.getCell().getCol()).getCellState() == CellState.FILLED) {
            return false;
        }
        return true;
    }

    public void undo() {
        Move lastMove = moves.get(moves.size()-1);
        moves.remove(moves.size()-1);

        // change the board
        int row = lastMove.getCell().getRow();
        int col = lastMove.getCell().getCol();
        Cell cellToUndo = board.getGrid().get(row).get(col);
        cellToUndo.setCellState(CellState.EMPTY);
        cellToUndo.setSymbol(null);

        // undo rotating the turn of the player
        nextPlayerIndex--;
        nextPlayerIndex = (nextPlayerIndex + players.size()) % players.size();

        // undo setting winner and gamestate
        gameState = GameState.IN_PROGRESS;
        winner = null;

        // undo the map set in the RowWinningStrategy
        for (WinningStrategy winningStrategy: winningStrategies) {
            winningStrategy.handleUndo(lastMove);
        }
        System.out.println("Undo successful!!!");
    }
}
