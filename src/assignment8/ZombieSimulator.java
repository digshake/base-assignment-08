package assignment8;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import edu.princeton.cs.introcs.StdDraw;
import support.cse131.ArgsProcessor;
import support.cse131.NotYetImplementedException;
import support.cse131.Timing;
import zombies.ZombieSimulationFiles;

public class ZombieSimulator {
	private static final String ZOMBIE_TOKEN_VALUE = "Zombie";

	

	public ZombieSimulator() {
		
			// FIXME
			throw new NotYetImplementedException();
		
	}

	public List<Entity> getEntities() {
		
			// FIXME
			throw new NotYetImplementedException();
		
	}

	public void readEntities(ArgsProcessor ap) {
		
			// FIXME
			throw new NotYetImplementedException();
		
	}

	public int getZombieCount() {
		
			// FIXME
			throw new NotYetImplementedException();
		
	}

	public int getNonzombieCount() {
		
			// FIXME
			throw new NotYetImplementedException();
		
	}

	public void draw() {
		StdDraw.clear();

		// NOTE: feel free to edit this code to support additional features
		for (Entity entity : getEntities()) {
			entity.draw();
		}

		StdDraw.show(); // commit deferred drawing as a result of enabling double buffering
	}

	public void update(double deltaTime) {
		
			// FIXME
			throw new NotYetImplementedException();
		
	}

	public static void main(String[] args) {
		StdDraw.enableDoubleBuffering(); // reduce unpleasant drawing artifacts, speed things up

		ArgsProcessor ap = ZombieSimulationFiles.createArgsProcessorFromFile(args);
		ZombieSimulator zombieSimulator = new ZombieSimulator();
		zombieSimulator.readEntities(ap);
		zombieSimulator.draw();
		StdDraw.pause(500);

		double prevTime = Timing.getCurrentTimeInSeconds();
		while (zombieSimulator.getNonzombieCount() > 0) {
			double currTime = Timing.getCurrentTimeInSeconds();
			double deltaTime = currTime - prevTime;
			if (deltaTime > 0.0) {
				zombieSimulator.update(deltaTime);
				zombieSimulator.draw();
			}
			StdDraw.pause(10);
			prevTime = currTime;
		}
	}
}
