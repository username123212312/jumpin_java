public class Fox extends Entity {
    private int x2;
    private int y2;
    private String direction; // "horizontal" or "vertical"

    public Fox(int y1, int x1, int y2, int x2) {
        super(y1, x1);
        this.y2 = y2;
        this.x2 = x2;

        if (y1 == y2) {
            this.direction = "horizontal";
        } else {
            this.direction = "vertical";
        }
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }

    public String getDirection() {
        return direction;
    }
}
