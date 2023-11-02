package assignment8;

import edu.princeton.cs.introcs.StdDraw;

public class Zombie extends Entity {
    public Zombie(double x, double y){
        super(x, y);
    }
    public boolean isZombie(){
        return true;
    }

    public double getRadius(){
        return super.radius;
    }

    public void eatNonzombie(){
        if(super.radius < 0.2) {
            super.radius *= 1.2;
        }
    }
 
    public void draw() {
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.filledCircle(super.getX(), super.getY(), super.radius);
    }

//    @Override
    public Entity update(Entity[] entities, double deltaTime) {
        Nonzombie e = this.findClosestNonzombie(entities);
        if(e != null){
            this.moveToward(e, deltaTime);
        	super.update(entities, deltaTime);
            return this;
        }
        return null;
    }
}