package src.tictactoe.strategy;

import src.tictactoe.model.Board;
import src.tictactoe.model.Move;

import java.util.HashMap;
import java.util.Map;

public class RowWinningStrategy implements WinningStrategy {
    private Map<Integer, Map<Character, Integer>> perRowSymbolCountMap;

    public RowWinningStrategy() {
        perRowSymbolCountMap = new HashMap<>();
    }
    @Override
    public boolean checkWinner(Board board, Move move) {
        int row = move.getCell().getRow();
        Character symbol = move.getSymbol();

        if (!perRowSymbolCountMap.containsKey(row)) {
            perRowSymbolCountMap.put(row, new HashMap<>());
        }

        var rowMap = perRowSymbolCountMap.get(row);

        if (!rowMap.containsKey(symbol)) {
            rowMap.put(symbol, 0);
        }

        rowMap.put(symbol, rowMap.get(symbol) + 1);

        if (rowMap.get(symbol) == board.getSize()) {
            return true;
        }
        return false;
    }

    @Override
    public void handleUndo(Move lastMove) {
        int row = lastMove.getCell().getRow();
        Character symbol = lastMove.getSymbol();

        var rowMap = perRowSymbolCountMap.get(row);
        rowMap.put(symbol, rowMap.get(symbol) - 1);
    }
}
