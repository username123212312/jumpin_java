package org.example;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Rabbit {
    private int row;
    private int col;

    public Rabbit(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }

    public void setPosition(int newRow, int newCol) {
        this.row = newRow;
        this.col = newCol;
    }

    public static List<Rabbit> findAllRabbits(String[][] board) {
        List<Rabbit> rabbits = new ArrayList();

        for(int i = 0; i < board.length; ++i) {
            for(int j = 0; j < board[i].length; ++j) {
                if (board[i][j].equals("\ud83d\udc30")) {
                    rabbits.add(new Rabbit(i, j));
                }
            }
        }

        return rabbits;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Rabbit rabbit = (Rabbit) o;
        return row == rabbit.row && col == rabbit.col;
    }


    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }

    public String toString() {
        return "Rabbit position: (" + this.row + ", " + this.col + ")";
    }
}

