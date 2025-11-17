package org.example;


class Empty extends Entity {

    public Empty(int x, int y) {
        super(x, y);
    }

    @Override
    public Entity deepCopy() {
        return new Empty(getX(),getY());
    }
}
