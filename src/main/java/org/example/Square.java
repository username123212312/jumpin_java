package org.example;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

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
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrevType() {
        return this.prev_type;
    }

    public void setPrevType(String prev_type) {
        this.prev_type = prev_type;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public boolean isType(String t) {
        return this.type.equals(t);
    }

    public String getSymbol() {
        switch (this.type) {
            case "Rabbit" -> {
                return "\ud83d\udc30";
            }
            case "Fox" -> {
                return "\ud83e\udd8a";
            }
            case "Mushroom" -> {
                return "\ud83c\udf44";
            }
            case "Hole" -> {
                return "\ud83d\udd73️";
            }
            default -> {
                return "⬜";
            }
        }
    }

    public String toString() {
        return this.getSymbol();
    }
}

