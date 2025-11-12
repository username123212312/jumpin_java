package org.example;

public class Fox {
    private int row1;
    private int col1;
    private int row2;
    private int col2;
    private String direction;

    public Fox(int row1, int col1, int row2, int col2, String direction) {
        this.row1 = row1;
        this.col1 = col1;
        this.row2 = row2;
        this.col2 = col2;
        this.direction = direction;
    }

    static Fox foxPosition(String[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        for(int i = 0; i < rows; ++i) {
            for(int j = 0; j < cols; ++j) {
                if (board[i][j].equals("\ud83e\udd8a")) {
                    if (i + 1 < rows && board[i + 1][j].equals("\ud83e\udd8a")) {
                        return new Fox(i, j, i + 1, j, "vertical");
                    }

                    if (j + 1 < cols && board[i][j + 1].equals("\ud83e\udd8a")) {
                        return new Fox(i, j, i, j + 1, "horizontal");
                    }
                }
            }
        }

        return new Fox(-1, -1, -1, -1, "unknown");
    }

    public String toString() {
        return "Fox position: (" + this.row1 + ", " + this.col1 + ") and (" + this.row2 + ", " + this.col2 + "), direction: " + this.direction;
    }
}
