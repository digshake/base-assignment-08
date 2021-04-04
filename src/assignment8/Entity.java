package assignment8;

import java.awt.Color;
import java.util.List;

import edu.princeton.cs.introcs.StdDraw;
import support.cse131.NotYetImplementedException;

public class Entity {
	

	public Entity(boolean isZombie, double x, double y) {
		
			// FIXME
			throw new NotYetImplementedException();
		
	}

	public boolean isZombie() {
		
			// FIXME
			throw new NotYetImplementedException();
		
	}

	public double getX() {
		
			// FIXME
			throw new NotYetImplementedException();
		
	}

	public double getY() {
		
			// FIXME
			throw new NotYetImplementedException();
		
	}

	public double getRadius() {
		
			// FIXME
			throw new NotYetImplementedException();
		
	}

	public void draw() {
		
			// FIXME
			throw new NotYetImplementedException();
		
	}

	

	public double distanceCenterToCenter(double xOther, double yOther) {
		
			// FIXME
			throw new NotYetImplementedException();
		
	}

	public double distanceCenterToCenter(Entity other) {
		return distanceCenterToCenter(other.getX(), other.getY());
	}

	public double distanceEdgeToEdge(double xOther, double yOther, double radiusOther) {
		
			// FIXME
			throw new NotYetImplementedException();
		
	}

	public double distanceEdgeToEdge(Entity other) {
		return distanceEdgeToEdge(other.getX(), other.getY(), other.getRadius());
	}

	public boolean isTouching(double xOther, double yOther, double radiusOther) {
		
			// FIXME
			throw new NotYetImplementedException();
		
	}

	public boolean isTouching(Entity other) {
		return isTouching(other.getX(), other.getY(), other.getRadius());
	}

	public void moveToward(double xOther, double yOther, double amount) {
		double xVector = xOther - getX();
		double yVector = yOther - getY();
		double angle = Math.atan2(yVector, xVector);
		double xAmount = amount * Math.cos(angle);
		double yAmount = amount * Math.sin(angle);
		
			throw new RuntimeException(
					"\nRemove this line and uncomment the lines below.\nIf you named your x and y coordinate instance variables something other than x and y, update the lines to use those instance variables.");
			// this.x += xAmount;
			// this.y += yAmount;
		
	}

	public void moveToward(Entity other, double amount) {
		moveToward(other.getX(), other.getY(), amount);
	}

	public void moveAwayFrom(double xOther, double yOther, double amount) {
		
			// FIXME
			throw new NotYetImplementedException();
		
	}

	public void moveAwayFrom(Entity other, double amount) {
		moveAwayFrom(other.getX(), other.getY(), amount);
	}

	private Entity findClosest(List<Entity> entities, boolean includeZombies, boolean includeNonzombies) {
		Entity closest = null;
		double closestDist = Double.MAX_VALUE;
		for (Entity other : entities) {
			// NOTE:
			// We almost always want to use the equals method when comparing Objects.
			// In this case, we check if the two entities are the exact same instance.
			if (this != other) {
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

	public Entity findClosestNonzombie(List<Entity> entities) {
		return findClosest(entities, false, true);
	}

	public Entity findClosestZombie(List<Entity> entities) {
		return findClosest(entities, true, false);
	}

	public Entity findClosestEntity(List<Entity> entities) {
		return findClosest(entities, true, true);
	}

	

	/**
	 * Updates the state of this Entity for the current frame of the simulation.
	 * 
	 * @param entities  list of remaining entities in the simulation. undoubtedly,
	 *                  this instance will be in entities. Care should be taken to
	 *                  not overreact to oneself.
	 * @param deltaTime the change in time since the previous frame
	 * 
	 * @return true if this Entity remains in existence past the current frame,
	 *         false if consumed
	 */
	public boolean update(List<Entity> entities, double deltaTime) {
		
			// FIXME
			throw new NotYetImplementedException();
		
	}
}
