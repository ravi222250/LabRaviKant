package src.tictactoe.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cell {
    private int row;
    private int col;
    private CellState cellState;
    private Character symbol;

    public Cell (int row, int col) {
        this.row = row;
        this.col = col;
        cellState = CellState.EMPTY;
        symbol = null;
    }

    public void display() {
        if (cellState == CellState.EMPTY) {
            System.out.print("| - |");
        } else {
            System.out.print("| " + this.symbol + " |");
        }
    }
}
