import java.util.*;

public class Node {
	final String my_name;
	final List<Node> neibours = new ArrayList<Node>();
	final List<Integer> weights_to = new ArrayList<Integer>();
	final long distance_to_target;
	
	//Don't like it this way, but this is the easiest way 
	// with the comparator working off of this value.
	long current_distance;
	
	public Node(String n, long l)	{
		this.my_name = n;
		distance_to_target = l;
		current_distance = Integer.MAX_VALUE;
	}
	
	public boolean addNeibour(Node n, int wt)	{
		if((this != n) && (!this.neibours.contains(n)))	{
			this.neibours.add(n);
			this.weights_to.add(wt);
			n.addNeibour(this, wt);
			return true;
		}
		else {return false;}
	}
	
	public void setDistance(long l)	{
		this.current_distance = l;
	}
}
