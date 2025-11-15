public class Square {

    private Entity entity;
    private final int x;
    private final int y;

    public Square(int x, int y, Entity entity) {
        this.x = x;
        this.y = y;
        this.entity = entity;
    }

    public Entity getEntity() {
        return entity;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    public boolean isEmpty() {
         return entity instanceof Empty;
    }

    @Override
    public String toString() {
        if (entity instanceof Rabbit) return "R";
        if (entity instanceof Fox) return "F";
        if (entity instanceof Mushroom) return "M";
        if (entity instanceof Hole) return "H";
        return "E";
    }
}
