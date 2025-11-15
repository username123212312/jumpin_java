package org.example;

import java.util.ArrayList;
import java.util.List;

public class Node {

    private State state;
    private Node parent;
    private Action action;
    private int depth;
    private int cost;

    public Node(State state, Node parent, Action action) {
        this.state = state;
        this.parent = parent;
        this.action = action;

        if (parent == null) {
            this.depth = 0;
            this.cost = 0;
        } else {
            this.depth = parent.depth + 1;
            this.cost = parent.cost + 1;
        }
    }

    public State getState() {
        return state;
    }

    public Node getParent() {
        return parent;
    }

    public Action getAction() {
        return action;
    }

    public int getDepth() {
        return depth;
    }

    public int getCost() {
        return cost;
    }

    private static boolean isInside(int x, int y) {
        return x >= 0 && x < 5 && y >= 0 && y < 5;
    }

    public List<Action> getPossibleActions(State state) {
        List<Action> actions = new ArrayList<>();
        List<Rabbit> rabbits = state.getRabbits();

        int[][] directions = {
                {-1, 0},
                {1, 0},
                {0, -1},
                {0, 1}
        };
        String[] dirNames = {"up", "down", "left", "right"};

        for (Rabbit rabbit : rabbits) {
            int rx = -1, ry = -1;
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (state.getSquare(i, j).getEntity() == rabbit) {
                        rx = i;
                        ry = j;
                        break;
                    }
                }
                if (rx != -1) break;
            }
            if (rx == -1) continue;
            for (int d = 0; d < 4; d++) {
                int dx = directions[d][0];
                int dy = directions[d][1];
                String dirName = dirNames[d];

                int cx = rx + dx;
                int cy = ry + dy;

                if (!isInside(cx, cy) || state.getSquare(cx, cy).isEmpty() || state.getSquare(cx, cy).getEntity() instanceof Hole)
                    continue;

                while (isInside(cx, cy) && !state.getSquare(cx, cy).isEmpty() && !(state.getSquare(cx, cy).getEntity() instanceof Hole)) {
                    cx += dx;
                    cy += dy;
                }

                if (!isInside(cx, cy)) continue;

                Entity landing = state.getSquare(cx, cy).getEntity();
                if (landing instanceof Empty || landing instanceof Hole) {
                    actions.add(new Action(rx, ry, cx, cy, "Rabbit", dirName));
                }
            }
        }

        return actions;
    }

}




