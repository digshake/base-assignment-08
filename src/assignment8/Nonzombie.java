package assignment8;

import edu.princeton.cs.introcs.StdDraw;

public class Nonzombie extends Entity {
    public Nonzombie(double x, double y) {
        super(x, y);
    }
 
    public void consume(){
        super.wasConsumed();
    }
 
    @Override
    public void draw() {
    	if(isAlive()) {
    		StdDraw.setPenColor(StdDraw.BLACK);
    	} else {
    		StdDraw.setPenColor(StdDraw.PINK);
    	}
    	StdDraw.filledCircle(x, y, super.getRadius());
    }
    
    public Zombie convert() {
    	System.out.println("CONVERTING");
    	return new Zombie(super.getX(), super.getY());
    }
    
    @Override
    public Entity update(Entity[] entities) {
        Zombie e = findClosestZombie(entities);
        if(e != null && this.isAlive()){
            this.moveAwayFrom(e);
            this.boundsCheck();
            if(this.isTouching(e)) {
            	System.out.println("TOUCHING");
                if(Math.random() > 0.2){
                    Zombie newGuy = this.convert();
                    return newGuy;
                }
                else {
                    this.consume();
                    e.eatNonzombie();
                }
            }
        }
        return this;
    }
    
    @Override
    public boolean isZombie() {
    	return false;
    }
    
}