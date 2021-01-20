package assignment8;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import assignment8.Drawable;
import assignment8.scenes.*;
import assignment8.scenes.ifs.*;
import cse131.ArgsProcessor;
import edu.princeton.cs.introcs.StdDraw;

public class SceneComposer {



	public static void main(String[] args) {

		ArgsProcessor ap = new ArgsProcessor(args);
		
		// Note: Double Buffering is enabled!  
		//       You'll need to call show() to update the screen.
		//       In most cases you'll want to call show() after you've drawn something
		StdDraw.enableDoubleBuffering();
		
		
		//
		// for demo only, remove this code and write your own to do what
		//   is needed for this assignment
		while(true) {
			StdDraw.show();
			StdDraw.pause(10);
			for (int i=0; i < 10; ++i) {
				Forest f = new Forest(5);
				f.draw(); f.draw(); f.draw(); f.draw();
				Leaves l = new Leaves(5);
				l.draw(); l.draw();
			}
			Bubbles b = new Bubbles(10);
			b.draw();
			StdDraw.show();
			StdDraw.pause(10);
			String resp = ap.nextString("Again?");
			if (resp.equals("no")) {
				break;
			}
			else {
				new Clear().draw();
			}
		}
		//
		// end of demo code
		//
	}

}
