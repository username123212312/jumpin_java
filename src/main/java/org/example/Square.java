package org.example;


public class Square {
    private int x;
    private int y;
    private String type;
    private String prev_type;

    public Square(int x, int y, String type, String prev_type) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.prev_type = prev_type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrevType() {
        return prev_type;
    }

    public void setPrevType(String prev_type) {
        this.prev_type = prev_type;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isType(String t) {
        return this.type.equals(t);
    }

    public String getSymbol() {
        switch (type) {
            case "Rabbit": return "R";
            case "Fox": return "F";
            case "Mushroom": return "M";
            case "Hole": return "H";
            default: return "E";
        }
    }
    @Override
    public String toString() {
        return getSymbol();
    }
}
