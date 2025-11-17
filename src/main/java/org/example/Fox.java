package org.example;


public class Fox extends Entity {
    private int x2;
    private int y2;
    private String direction; // "horizontal" or "vertical"

    public Fox(int x1, int y1, int x2, int y2) {
        super(x1, y1);
        this.x2 = x2;
        this.y2 = y2;

        this.direction = findDir();
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    private String findDir() {
        return this.getX() == this.x2 ? "vertical" : "horizontal";
    }

    public String getDirection() {
        return direction;
    }
}
