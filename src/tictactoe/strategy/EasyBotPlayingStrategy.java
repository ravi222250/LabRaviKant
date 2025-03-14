package src.tictactoe.strategy;

import src.tictactoe.model.*;

import java.util.List;

public class EasyBotPlayingStrategy implements BotPlayingStrategy {
    @Override
    public Move chooseCellForBotMove(Board board, Character symbol) {
        // just return the first empty cell found
        List<List<Cell>> grid = board.getGrid();
        for (List<Cell> row: grid) {
            for (Cell cell: row) {
                if (cell.getCellState() == CellState.EMPTY) {
                    return new Move(new Cell(cell.getRow(), cell.getCol()), symbol);
                }
            }
        }
        return null;
    }
}
