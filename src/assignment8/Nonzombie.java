public class Nonzombie extends Entity {
    public Nonzombie(double x, double y) {
        super(x, y);
    }

    public void isConsumed(){
        super.setAlive(false);
    }

    public void draw() {
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledCircle(x, y, super.getRadius());
    }

    public void update(Entity[] entities, double deltaTime) {
        Entity e = findClosestZombie(entities);
        if(e != null){
            this.moveAwayFrom(e, deltaTime);
        }
    }
}