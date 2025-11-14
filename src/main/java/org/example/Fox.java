package org.example;


public class Fox extends Entity {
    private int x2;
    private int y2;
    private String direction; // "horizontal" or "vertical"

    public Fox(int x, int y, int x2, int y2) {
        super(x, y);
        this.x2 = x2;
        this.y2 = y2;
        

        if (y == y2) {
            this.direction = "horizontal";
        } else {
            this.direction = "vertical";
        }
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }

    public String getDirection() {
        return direction;
    }
}
