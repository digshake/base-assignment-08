public class Zombie extends Entity {
    public Zombie(double x, double y){
        super(x, y);
    }
    public boolean isZombie(){
        return true;
    }

    public double getRadius(){
        return this.radius;
    }

    public void eatNonzombie(){
        if(this.radius < 0.2) {
            this.radius *= 1.2;
        }
    }

    public void draw() {
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.filledCircle(super.getX(), super.getY(), this.radius);
    }

    public void update(Entity[] entities, double deltaTime) {
        Entity e = this.findClosestNonzombie(entities);
        if(e != null){
            this.moveToward(e, deltaTime);
            if(this.isTouching(e)) {
                if(Math.random() > 0.2){
                    e.consume();
                }
                else {
                    this.eatNonzombie();
                }
            }
        }
    }
}