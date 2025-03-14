package src.tictactoe.model;

import java.util.Scanner;

public class HumanPlayer extends Player {
    private int coins;
    private int level;
    private Scanner scanner;
    public HumanPlayer(String name, Character symbol, int coins, int level) {
        super(name, symbol, PlayerType.HUMAN);
        this.coins = coins;
        this.level = level;
        scanner = new Scanner(System.in);
    }

    @Override
    public Move chooseCellToMoveTo(Board board) {
        System.out.println("Enter the row and col separated by comma:");
        String input = scanner.nextLine();
        int row = Integer.parseInt(input.split(",")[0]);
        int col = Integer.parseInt(input.split(",")[1]);
        return new Move(new Cell(row, col), this.getSymbol());
    }
}
