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

    private boolean isPartOfFox(Fox fox, int x, int y) {
        return (fox.getX() == x && fox.getY() == y) || (fox.getX2() == x && fox.getY2() == y);
    }

    public List<Action> getPossibleActions(State state) {
        List<Action> actions = new ArrayList<>();

        // ----------Rabbit  ----------
        for (Rabbit rabbit : state.getRabbits()) {
            int rx = rabbit.getX();
            int ry = rabbit.getY();

            int[][] directions = { {-1,0}, {1,0}, {0,-1}, {0,1} }; // up, down, left, right
            String[] dirNames = { "up", "down", "left", "right" };

            for (int d = 0; d < 4; d++) {
                int dx = directions[d][0];
                int dy = directions[d][1];
                String dirName = dirNames[d];

                int cx = rx + dx;
                int cy = ry + dy;

                if (!isInside(cx, cy)) continue;

                Entity firstCell = state.getSquare(cx,cy).getEntity();
                if (firstCell instanceof Empty || firstCell instanceof Hole) continue;

                while (isInside(cx, cy) && !state.getSquare(cx,cy).isEmpty() 
                        && !(state.getSquare(cx,cy).getEntity() instanceof Hole)) {
                    Entity e = state.getSquare(cx,cy).getEntity();
                    if (!(e instanceof Rabbit || e instanceof Fox || e instanceof Mushroom)) break;
                    cx += dx;
                    cy += dy;
                }

                if (!isInside(cx, cy)) continue;

                Entity landing = state.getSquare(cx,cy).getEntity();
                if (landing instanceof Empty || (landing instanceof Hole && !((Hole) landing).isOccupied())) {
                    actions.add(new Action(rx, ry, cx, cy, "Rabbit", dirName));
                }
            }
        }

        // ---------- Fox ----------
        for (Fox fox : state.getFoxes()) {
            int[][] directions = fox.getDirection().equals("vertical") ?
                                 new int[][] { {-1,0}, {1,0} } :   // up, down
                                 new int[][] { {0,-1}, {0,1} };    // left, right

            for (int[] dir : directions) {
                int dx = dir[0];
                int dy = dir[1];

                int newX1 = fox.getX() + dx;
                int newY1 = fox.getY() + dy;
                int newX2 = fox.getX2() + dx;
                int newY2 = fox.getY2() + dy;

                if (isInside(newX1,newY1) && isInside(newX2,newY2) &&
                    (state.getSquare(newX1,newY1).isEmpty() || isPartOfFox(fox,newX1,newY1)) &&
                    (state.getSquare(newX2,newY2).isEmpty() || isPartOfFox(fox,newX2,newY2))) {

                    String dirName = fox.getDirection().equals("vertical") ?
                                     (dx == -1 ? "up" : "down") :
                                     (dy == -1 ? "left" : "right");

                    actions.add(new Action(fox.getX(), fox.getY(), newX1, newY1, "Fox", dirName));
                }
            }
        }

        return actions;
    }
}
