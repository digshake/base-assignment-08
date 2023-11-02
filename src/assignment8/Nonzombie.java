package assignment8;

import edu.princeton.cs.introcs.StdDraw;

public class Nonzombie extends Entity {
    public Nonzombie(double x, double y) {
        super(x, y);
    }
 
    public void consume(){
        super.wasConsumed();
    }
 
    public void draw() {
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledCircle(x, y, super.getRadius());
    }
    public Zombie convert() {
    	System.out.println("CONVERTING");
    	return new Zombie(super.getX(), super.getY());
    }

    public Entity update(Entity[] entities, double deltaTime) {
        Zombie e = findClosestZombie(entities);
        if(e != null){
            this.moveAwayFrom(e, deltaTime);
            super.update(entities, deltaTime);
            if(this.isTouching(e)) {
            	System.out.println("TOUCHING");
                if(Math.random() > 0.2){
                    Zombie newGuy = this.convert();
                    return newGuy;
                }
                else {
//                    e.eatNonzombie();
                    this.consume();
                }
            }
            return this;
        }
        return null;
    }
    
    
}