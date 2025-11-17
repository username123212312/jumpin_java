package org.example;

public class Hole extends Entity {
    private Rabbit occupant; 

    public Hole(int x, int y) {
        super(x, y);
        this.occupant = null;    
    }

    @Override
    public Entity deepCopy() {
        return new Hole(getX(),getY());
    }

    public void setOccupant(Rabbit rabbit) {
        this.occupant = rabbit;
    }

    public void removeOccupant() {
        this.occupant = null;
    }

    public boolean isOccupied() {
        return occupant != null;
    }

    public Rabbit getOccupant() {
        return occupant;
    }
}

