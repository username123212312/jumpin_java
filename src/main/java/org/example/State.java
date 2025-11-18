package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class State {

    private final Square[][] board;

    public State(Square[][] board) {
        this.board = board;
    }

    public State deepCopy() {
        Square[][] newBoard = new Square[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
//                Entity oldEntity = board[i][j].getEntity();
//                Entity newEntity = copyEntity(oldEntity);
                newBoard[i][j] = board[i][j].deepCopy();
            }
        }
        return new State(newBoard);
    }

    public Square getSquare(int x, int y) {
        return board[x][y];
    }

    public void setEntity(int x, int y, Entity e) {
        board[x][y].setEntity(e);
    }

    public State copy() {
        return new State(board);
    }

    public List<Rabbit> getRabbits() {
        List<Rabbit> list = new ArrayList<>();
        for (Square[] row : board)
            for (Square sq : row)
                if (sq.getEntity() instanceof Rabbit)
                    list.add((Rabbit) sq.getEntity());
        return list;
    }

    public List<Fox> getFoxes() {
        List<Fox> list = new ArrayList<>();
        for (Square[] row : board)
            for (Square sq : row)
                if (sq.getEntity() instanceof Fox)
                    list.add((Fox) sq.getEntity());
        return list;
    }

    public List<Hole> getHoles() {
        List<Hole> list = new ArrayList<>();
        for (Square[] row : board)
            for (Square sq : row)
                if (sq.getEntity() instanceof Hole)
                    list.add((Hole) sq.getEntity());
        return list;
    }

    public List<Mushroom> getMushrooms() {
        List<Mushroom> list = new ArrayList<>();
        for (Square[] row : board)
            for (Square sq : row)
                if (sq.getEntity() instanceof Mushroom)
                    list.add((Mushroom) sq.getEntity());
        return list;
    }

    private Entity copyEntity(Entity e) {
        if (e instanceof Rabbit) return e.deepCopy();
        if (e instanceof Hole) return e.deepCopy();
        if (e instanceof Mushroom) return e.deepCopy();
        if (e instanceof Empty) return e.deepCopy();
        if (e instanceof Fox f) return e.deepCopy();

        return null;
    }

    public void printBoard() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {

                System.out.print(board[i][j].toString() + " ");


            }
            System.out.println();
        }
    }

    public static State initialState(String[][] b) {
        Square[][] board = new Square[5][5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                Entity e = new Empty(i, j);
                switch (b[i][j]) {
                    case "R":
                        e = new Rabbit(i, j);
                        break;
                    case "M":
                        e = new Mushroom(i, j);
                        break;

                    case "H":
                        e = new Hole(i, j);
                        break;

                    case "F":
                        e = getFoxCoordinates(i, j, b);
                        break;

                    case "RH":
                        Hole h = new Hole(i, j);
                        h.setOccupant(new Rabbit(i, j));
                        e = h;
                        break;


                }
                board[i][j] = new Square(i, j, e);
            }
        }

//        board[0][1].setEntity(new Rabbit(0, 1));
//        board[0][2].setEntity(new Mushroom(0, 2));
//        board[0][3].setEntity(new Hole(0, 3));
//        board[2][1].setEntity(new Rabbit(2, 1));
//        board[2][2].setEntity(new Mushroom(2, 2));
//        board[2][3].setEntity(new Mushroom(2, 3));
//        board[2][4].setEntity(new Hole(2, 4));
//        board[1][1].setEntity(new Hole(2, 1));
//        board[1][2].setEntity(new Fox(1, 2, 1, 3));
//        board[1][3].setEntity(board[1][2].getEntity());

        return new State(board);
    }

    private static Fox getFoxCoordinates(int x, int y, String[][] board) {
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // up, down, left, right

        for (int d = 0; d < 4; d++) {
            int dx = directions[d][0];
            int dy = directions[d][1];

            int cx = x + dx;
            int cy = y + dy;

            if (cx >= 0 && cx < 5 && cy >= 0 && cy < 5) {
                if (Objects.equals(board[cx][cy], "F")) {
                    return new Fox(x, y, cx, cy);
                }
            }
        }
        return null;
    }

}
