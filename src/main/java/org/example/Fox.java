package org.example;


public class Fox extends Entity {

    private String direction; // "horizontal" or "vertical"

    public Fox(String direction) {
        this.direction = direction;
    }

    public String getDirection() {
        return direction;
    }
}
