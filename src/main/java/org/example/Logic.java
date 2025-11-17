package org.example;

import java.util.List;

public class Logic {
    public void userPlay(Node node){
        List<Action> actions = node.getPossibleActions();

        System.out.println("Possible Actions:");
        for (Action a : actions) {
            System.out.println("Move " + a.getEntityType() +
                    " from (" + a.getOldX() + "," + a.getOldY() + ")" +
                    " to (" + a.getNewX() + "," + a.getNewY() + ")");
        }
    }
}
