package src.tictactoe.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Board {
    private int size;
    private List<List<Cell>> grid;

    public Board (int size) {
        this.size = size;
        grid = new ArrayList<>();
        initializeGrid(grid);
    }

    private void initializeGrid(List<List<Cell>> grid) {
        for (int i=0;i<size;i++) {
            grid.add(new ArrayList<>());
            for (int j=0;j<size;j++) {
                grid.get(i).add(new Cell(i, j));
            }
        }
    }

    public void display() {
        for (List<Cell> row: grid) {
            for (Cell cell: row) {
                cell.display();
            }
            System.out.println();
        }
    }
}
