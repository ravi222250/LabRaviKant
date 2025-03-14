package src.tictactoe.strategy;

import src.tictactoe.model.Board;
import src.tictactoe.model.Move;

import java.util.HashMap;
import java.util.Map;

public class ColumnWinningStrategy implements WinningStrategy {
    private Map<Integer, Map<Character, Integer>> perColSymbolCountMap;

    public ColumnWinningStrategy() {
        perColSymbolCountMap = new HashMap<>();
    }

    @Override
    public boolean checkWinner(Board board, Move move) {
        int col = move.getCell().getCol();
        Character symbol = move.getSymbol();

        if (!perColSymbolCountMap.containsKey(col)) {
            perColSymbolCountMap.put(col, new HashMap<>());
        }

        var colMap = perColSymbolCountMap.get(col);

        if (!colMap.containsKey(symbol)) {
            colMap.put(symbol, 0);
        }

        colMap.put(symbol, colMap.get(symbol) + 1);

        if (colMap.get(symbol) == board.getSize()) {
            return true;
        }
        return false;
    }

    @Override
    public void handleUndo(Move lastMove) {
        int col = lastMove.getCell().getCol();
        Character symbol = lastMove.getSymbol();

        var colMap = perColSymbolCountMap.get(col);
        colMap.put(symbol, colMap.get(symbol)-1);
    }
}
