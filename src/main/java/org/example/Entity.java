package org.example;

import java.util.Objects;

public class Entity {
    protected int x;
    protected int y;

    public Entity(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    //equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Entity)) return false;
        Entity entity = (Entity) o;
        return x == entity.x && y == entity.y && this.getClass() == entity.getClass();

    }

    //hashCode
    @Override
    public int hashCode() {
        return Objects.hash(x, y, this.getClass());
    }

}
