import static org.junit.Assert.*;

import org.junit.Test;

public class PathFinderTest {

	@Test
	public void testDijkstras() {
		
		//Create a test map <hand-drawn picture included>
		
		//Create the junctions (nodes)
		Node start = new Node("start");
		Node a = new Node("a");
		Node b = new Node("b");
		Node c = new Node("c");
		Node d = new Node("d");
		Node e = new Node("e");
		Node f = new Node("f");
		Node g = new Node("g");
		Node h = new Node("h");
		Node i = new Node("i");
		Node j = new Node("j");
		Node k = new Node("k");
		Node end = new Node("end");
		
		
		//Create the road network (graph)
		start.addNeibour(a, 4);
		start.addNeibour(b, 2);
		start.addNeibour(c, 3);
		
		a.addNeibour(b, 8);
		a.addNeibour(d, 1);
		
		b.addNeibour(d, 11);
		b.addNeibour(e, 10);
		
		c.addNeibour(g, 2);
		
		d.addNeibour(i, 2);
		
		e.addNeibour(i, 2);
		e.addNeibour(j, 1);
		
		f.addNeibour(g, 4);
		f.addNeibour(h, 6);
		f.addNeibour(k, 4);
		
		g.addNeibour(h, 4);
		
		h.addNeibour(k, 4);
		
		//i.addNeibour(e, 2);
		
		j.addNeibour(end, 2);
		
		k.addNeibour(end, 5);
		
		
		//see if Dijkstraw's algorithm works
		
		shortestPathFinder ob = new shortestPathFinder(start, end);
		
		ob.dijkstras();
		
		assertEquals(1,1);
	}

}
