package org.example;

import java.util.Objects;

public class Entity {
    private int x;
    private int y;

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

    // كل الكائنات تعتمد على نوعها فقط، الإحداثيات داخل Square
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Entity)) return false;
        return this.getClass() == o.getClass();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getClass());
    }
}




