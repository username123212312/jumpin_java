package org.example;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.List;

public class State {
    private final String[][] board;

    public State(String[][] board) {
        this.board = board;
    }

    public String getCell(int r, int c) {
        return this.board[r][c];
    }

    public void setCell(int r, int c, String val) {
        this.board[r][c] = val;
    }

    public List<Rabbit> getAllRabbits() {
        return Rabbit.findAllRabbits(this.board);
    }

    public String[][] copyBoard() {
        String[][] copy = new String[this.board.length][this.board[0].length];

        for(int i = 0; i < this.board.length; ++i) {
            System.arraycopy(this.board[i], 0, copy[i], 0, this.board[i].length);
        }

        return copy;
    }

    public String getSymbol() {
        StringBuilder sb = new StringBuilder();

        for(String[] row : this.board) {
            for(String s : row) {
                sb.append(s).append(" ");
            }

            sb.append("\n");
        }

        return sb.toString();
    }

    public boolean isGoal() {
        for(Rabbit r : this.getAllRabbits()) {
            if (!this.getCell(r.getRow(), r.getCol()).equals("\ud83d\udd73️")) {
                return false;
            }
        }

        return true;
    }

    public static String[][] initialBoard() {
        return new String[][]{{"\ud83d\udd73️", "⬜", "⬜", "\ud83e\udd8a", "\ud83d\udd73️"}, {"\ud83c\udf44", "⬜", "⬜", "\ud83e\udd8a", "\ud83d\udc30"}, {"⬜", "\ud83c\udf44", "\ud83d\udd73️", "⬜", "⬜"}, {"⬜", "⬜", "\ud83c\udf44", "⬜", "⬜"}, {"\ud83d\udd73️", "⬜", "\ud83d\udc30", "⬜", "\ud83d\udd73️"}};
    }
}
