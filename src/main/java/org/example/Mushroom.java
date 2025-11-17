package org.example;

public class Mushroom extends Entity {
    public Mushroom(int x, int y) {
        super(x, y);
    }

    @Override
    public Entity deepCopy() {
        return new Mushroom(getX(), getY());
    }
}
