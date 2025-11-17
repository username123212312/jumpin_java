package org.example;

class Rabbit extends Entity {
    public Rabbit(int x, int y) {
        super(x, y);
    }

    @Override
    public Entity deepCopy() {
        return new Rabbit(getX(),getY());
    }
}
