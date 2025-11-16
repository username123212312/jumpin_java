package org.example;

import java.util.ArrayList;
import java.util.List;

public class State {

    private Square[][] board;

    public State(Square[][] board) {
        this.board = new Square[5][5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                Entity oldEntity = board[i][j].getEntity();
                Entity newEntity = copyEntity(oldEntity);
                this.board[i][j] = new Square(i, j, newEntity);
            }
        }
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
        if (e instanceof Rabbit) return new Rabbit(e.getX(), e.getY());
        if (e instanceof Hole) return new Hole(e.getX(), e.getY());
        if (e instanceof Mushroom) return new Mushroom(e.getX(), e.getY());
        if (e instanceof Empty) return new Empty(e.getX(), e.getY());
        if (e instanceof Fox f) return new Fox(f.getX(), f.getY(), f.getX2(), f.getY2());

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

    public static State initialState() {
        Square[][] board = new Square[5][5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                board[i][j] = new Square(i, j, new Empty(j, i));
            }
        }
        board[0][1].setEntity(new Rabbit(0, 1));
        board[0][2].setEntity(new Mushroom(0, 2));
        board[0][3].setEntity(new Hole(0,3));
        board[2][1].setEntity(new Rabbit(2, 1));
        board[2][2].setEntity(new Mushroom(2, 2));
        board[2][3].setEntity(new Mushroom(2, 3));
        board[2][4].setEntity(new Hole(2,4));
        board[1][1].setEntity(new Hole(2,1));
        board[1][2].setEntity(new Fox(1,2,1,3));
        board[1][3].setEntity(board[1][2].getEntity());

        return new State(board);
    }

}
