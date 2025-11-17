package org.example;

public class Action {

    private int oldX;
    private int oldY;

    private int newX;
    private int newY;

    private String entityType; // "Rabbit" or "Fox"
    private String direction;  // "up", "down", "left", "right"

    public Action(int oldX, int oldY, int newX, int newY, String entityType, String direction) {
        this.oldX = oldX;
        this.oldY = oldY;
        this.newX = newX;
        this.newY = newY;
        this.entityType = entityType;
        this.direction = direction;
    }

    public Action deepCopy() {
        return new Action(oldX, oldY, newX, newY, entityType, direction);
    }

    public String getEntityType() {
        return entityType;
    }

    public int getOldX() {
        return oldX;
    }

    public int getOldY() {
        return oldY;
    }

    public int getNewX() {
        return newX;
    }

    public int getNewY() {
        return newY;
    }

    public String getDirection() {
        return direction;
    }
}
