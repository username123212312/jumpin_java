package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String[][] board = State.initialBoard();
        new State(board);
        Game g = new Game(board.length, board[0].length);
        g.userPlay(new State(board), Rabbit.findAllRabbits(board));
    }
}
