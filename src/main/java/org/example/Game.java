package org.example;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.List;
import java.util.Scanner;

public class Game {
    private int rowSize;
    private int colSize;

    public Game(int rowSize, int colSize) {
        this.rowSize = rowSize;
        this.colSize = colSize;
    }

    public boolean checkMove(int row, int col, int dx, int dy, State state) {
        int newRow = row + dx;
        int newCol = col + dy;
        return newRow >= 0 && newRow < this.rowSize && newCol >= 0 && newCol < this.colSize;
    }

    public void move(Rabbit rabbit, String direction, State state) {
        int row = rabbit.getRow();
        int col = rabbit.getCol();
        int dx = 0;
        int dy = 0;
        switch (direction.toLowerCase()) {
            case "up":
                dx = -1;
                break;
            case "down":
                dx = 1;
                break;
            case "left":
                dy = -1;
                break;
            case "right":
                dy = 1;
                break;
            default:
                System.out.println("Unknown direction!");
                return;
        }

        int newRow = row + dx;
        int newCol = col + dy;
        if (!this.checkMove(row, col, dx, dy, state)) {
            System.out.println("Invalid move! Out of bounds.");
        } else {
            String nextCell = state.getCell(newRow, newCol);
            if (!nextCell.equals("⬜") && !nextCell.equals("\ud83d\udd73️")) {
                System.out.println("Invalid move! Blocked.");
            } else {
                state.setCell(row, col, "⬜");
                state.setCell(newRow, newCol, "\ud83d\udc30");
                rabbit.setPosition(newRow, newCol);
                System.out.println("Rabbit moved " + direction + " to (" + newRow + ", " + newCol + ")");
            }
        }
    }

    public void userPlay(State state, List<Rabbit> rabbits) {
        Scanner input = new Scanner(System.in);
        System.out.println("Initial Board:");
        System.out.println(state.getSymbol());

        while(true) {
            System.out.println("Available rabbits:");

            for(int i = 0; i < rabbits.size(); ++i) {
                Rabbit r = (Rabbit)rabbits.get(i);
                System.out.println(i + ": (" + r.getRow() + "," + r.getCol() + ")");
            }

            System.out.print("Choose rabbit index to move or type exit: ");
            String line = input.nextLine();
            if (line.equalsIgnoreCase("exit")) {
                break;
            }

            int rabbitIndex;
            try {
                rabbitIndex = Integer.parseInt(line);
                if (rabbitIndex < 0 || rabbitIndex >= rabbits.size()) {
                    System.out.println("Invalid rabbit index!");
                    continue;
                }
            } catch (NumberFormatException var8) {
                System.out.println("Please enter a valid number.");
                continue;
            }

            Rabbit chosenRabbit = (Rabbit)rabbits.get(rabbitIndex);
            System.out.print("Enter move (up/down/left/right): ");
            String direction = input.nextLine();
            this.move(chosenRabbit, direction, state);
            System.out.println(state.getSymbol());
            if (state.isGoal()) {
                System.out.println("All rabbits are in holes!");
                break;
            }
        }

        input.close();
    }
}

