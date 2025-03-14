package src.tictactoe.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Player {
    private String name;
    private Character symbol;
    private PlayerType playerType;

    public Player(String name, Character symbol, PlayerType playerType) {
        this.name = name;
        this.symbol = symbol;
        this.playerType = playerType;
    }

    public abstract Move chooseCellToMoveTo(Board board);
}
