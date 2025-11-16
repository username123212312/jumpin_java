package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        State state = State.initialState();
        System.out.println("Initial Board:");
        state.printBoard();

        Node node = new Node(state, null, null);

        List<Action> actions = node.getPossibleActions(state);

        System.out.println("Possible Actions:");
        for (Action a : actions) {
            System.out.println("Move " + a.getEntityType() +
                    " from (" + a.getOldX() + "," + a.getOldY() + ")" +
                    " to (" + a.getNewX() + "," + a.getNewY() + ")");
        }
    }
}
