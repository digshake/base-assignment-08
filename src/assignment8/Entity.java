package assignment8;

import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;
import support.cse131.NotYetImplementedException;

public class Entity {
	private static final double MOVE_DISTANCE = 0.01;
	protected double x, y, radius;
	private boolean isConsumed;

	/**
	 * @param isZombie the undead state of this Entity.
	 *                 true if zombie, false otherwise.
	 * @param x        the x-coordinate of this Entity's center.
	 * @param y        the y-coordinate of this Entity's center.
	 */
	public Entity(double x, double y) {
		this.x = x;
		this.y = y;
		this.radius = 0.008;
		this.isConsumed = false;
	}
	/**
	 * @return the center x-coordinate
	 */
	public double getX() {
		return this.x;
	}

	/**
	 * @return the center y-coordinate
	 */
	public double getY() {
		return this.y;
	}

	public double getRadius() {
		return this.radius;
	}
	public boolean isAlive() {
		return !this.isConsumed;
	}
	public void wasConsumed(){
		this.isConsumed = true;
	}
	
	public boolean isZombie() {
		return false;
	}


	/**
	 * @param xOther x-coordinate of the other point.
	 * @param yOther y-coordinate of the other point.
	 * @return distance between this Entity's center and the specified other point.
	 */
	public double distanceCenterToPoint(double xOther, double yOther) {
		return Math.sqrt(Math.pow(this.x - xOther, 2) + Math.pow(this.y - yOther, 2));
	}

	/**
	 * @param other the other Entity
	 * @return the distance between this Entity's center and the specified other
	 *         Entity's center.
	 */
	public double distanceCenterToCenter(Entity other) {
		return distanceCenterToPoint(other.getX(), other.getY());
	}

	/**
	 * @param xOther      the x-coordinate of another Entity's center.
	 * @param yOther      the y-coordinate of another Entity's center.
	 * @param radiusOther the radius of another Entity.
	 * @return the distance between this Entity's edge and the specified other
	 *         Entity's edge.
	 */
	public double distanceEdgeToEdge(double xOther, double yOther, double radiusOther) {
		return distanceCenterToPoint(xOther, yOther) - (this.getRadius() + radiusOther);
	}

	/**
	 * @param other the other Entity.
	 * @return the distance between this Entity's edge and the specified other
	 *         Entity's edge.
	 */
	public double distanceEdgeToEdge(Entity other) {
		return distanceEdgeToEdge(other.getX(), other.getY(), other.getRadius());
	}

	/**
	 * @param xOther      the x-coordinate of another Entity's center.
	 * @param yOther      the y-coordinate of another Entity's center.
	 * @param radiusOther the radius of another Entity.
	 * @return true if the bounding circle of this Entity overlaps with the bounding
	 *         circle of the specified other Entity, false otherwise.
	 */
	public boolean isTouching(double xOther, double yOther, double radiusOther) {
		return distanceEdgeToEdge(xOther, yOther, radiusOther) <= 0;
	}

	/**
	 * @param other the other Entity
	 * @return true if the bounding circle of this Entity overlaps with the bounding
	 *         circle of the specified other Entity, false otherwise.
	 */
	public boolean isTouching(Entity other) {
		return isTouching(other.getX(), other.getY(), other.getRadius());
	}

	/**
	 * @param xOther x-coordinate of the other point.
	 * @param yOther y-coordinate of the other point.
	 * @param amount the amount to move toward the point.
	 */
	public void moveToward(double xOther, double yOther, double amount) {
		double xVector = xOther - getX();
		double yVector = yOther - getY();
		double angle = Math.atan2(yVector, xVector);
		double xAmount = amount * Math.cos(angle);
		double yAmount = amount * Math.sin(angle);
		
			 this.x += xAmount;
			 this.y += yAmount;
		
	}
 
	/**
	 * @param other  the other Entity
	 * @param amount the amount to move toward the other Entity.
	 */
	public void moveToward(Entity other) {
		moveToward(other.getX(), other.getY(), MOVE_DISTANCE);
	}

	/**
	 * @param xOther x-coordinate of the other point.
	 * @param yOther y-coordinate of the other point.
	 * @param amount the amount to move away from the point.
	 */
	public void moveAwayFrom(double xOther, double yOther) {
		moveToward(xOther, yOther, -MOVE_DISTANCE);
	}

	/**
	 * @param other  the other Entity
	 * @param amount the amount to move away from the other Entity.
	 */
	public void moveAwayFrom(Entity other) {
		moveAwayFrom(other.getX(), other.getY());
	}

	/**
	 * @param entities          this array of entities to search.
	 * @param includeZombies    whether to include zombies in this search or not.
	 * @param includeNonzombies whether to include nonzombies in this search or not.
	 * @return the closest Entity to this Entity in entities (which is not this).
	 */
	private Entity findClosest(Entity[] entities, boolean includeZombies, boolean includeNonzombies) {
		Entity closest = null;
		double closestDist = Double.MAX_VALUE;
		for (Entity other : entities) {
			// NOTE:
			// We almost always want to use the equals method when comparing Objects.
			// In this case, we check if the two entities are the exact same instance.
			if (this != other && other != null) {
				if ((other.isZombie() && includeZombies) || (!other.isZombie() && includeNonzombies)) {
					double dist = distanceEdgeToEdge(other);
					if (dist < closestDist) {
						closest = other;
						closestDist = dist;
					}
				}
			}
		}
		return closest;
	}

	/**
	 * @param entities this array of entities to search.
	 * @return the closest nonzombie to this Entity in entities (which is not this).
	 */
	public Nonzombie findClosestNonzombie(Entity[] entities) {
		Entity e = findClosest(entities, false, true);
		if(e != null) {
			return (Nonzombie)e;
		}
		return null;
	}

	/**
	 * @param entities this array of entities to search.
	 * @return the closest zombie to this Entity in entities (which is not this).
	 */
	public Zombie findClosestZombie(Entity[] entities) {
		Entity e = findClosest(entities, true, false);
		if(e == null) {
			return null;
		}
		return (Zombie)e;
	}

	/**
	 * @param entities this array of entities to search.
	 * @return the closest Entity to this Entity in entities (which is not this).
	 */
	public Entity findClosestEntity(Entity[] entities) {
		return findClosest(entities, true, true);
	}
	
	public void draw() {
		StdDraw.setPenColor(Color.orange);
		StdDraw.point(x, y);
	}
	
	public Entity update(Entity[] e) {
		return this;
	}
	
	public void boundsCheck() {
		if(this.x > 1) {
			this.x = 1;
		}
		if(this.x < 0) {
			this.x = 0;
		}
		if(this.y > 1) {
			this.y = 1;
		}
		if(this.y < 0) {
			this.y = 0;
		}
	}

}
