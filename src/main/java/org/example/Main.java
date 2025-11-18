package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        State state = State.initialState(Levels.levels.get(26));
        System.out.println("Initial Board:");
        state.printBoard();

        Node node = new Node(state, null, null);

        Logic l = new Logic();
        l.userPlay(node);


    }
}
