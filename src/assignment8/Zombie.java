package assignment8;

import edu.princeton.cs.introcs.StdDraw;

public class Zombie extends Entity {
    public Zombie(double x, double y){
        super(x, y);
    }
    
    @Override
    public boolean isZombie(){
        return true;
    }

    public double getRadius(){
        return radius;
    }

    public void eatNonzombie(){
        if(radius < 0.2) {
            radius *= 1.2;
        }
    }
 
    @Override
    public void draw() {
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.filledCircle(super.getX(), super.getY(), super.radius);
    }

    @Override
    public Entity update(Entity[] entities) {
        Nonzombie e = this.findClosestNonzombie(entities);
        if(e != null){
            this.moveToward(e);
        	this.boundsCheck();
        }
        return this;
    }
}