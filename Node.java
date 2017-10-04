import java.util.*;

public class Node {
	final String my_name;
	final List<Node> neibours = new ArrayList<Node>();
	final List<Integer> weights_to = new ArrayList<Integer>();
	long current_distance;
	
	public Node(String n)	{
		this.my_name = n;
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
