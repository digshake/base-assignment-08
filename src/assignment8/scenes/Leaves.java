package assignment8.scenes;

import java.util.HashSet;
import java.util.Set;

import assignment8.Drawable;
import assignment8.scenes.ifs.Leaf;
import edu.princeton.cs.introcs.StdDraw;

public class Leaves implements Drawable {
	
	private Set<Leaf> leaves;
	public Leaves(int numTrees) {
		this.leaves = new HashSet<Leaf>();
		for (int i=0; i < numTrees; ++i) {
			leaves.add(new Leaf(2*Math.random()-1.0, 2*Math.random()-1.0, Math.random()));
		}
	}
	
	public void draw() {
		for (Leaf t : leaves) {
			t.draw();
		}
	}
	
	public static void main(String[] args) {
		StdDraw.enableDoubleBuffering();
		Leaves f = new Leaves(80);
		StdDraw.show();
		StdDraw.pause(10);
		f.draw();
		StdDraw.show();
		StdDraw.pause(10);
	}

}
