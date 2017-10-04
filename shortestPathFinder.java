import java.util.*;
//import java.util.Map.Entry;

public class shortestPathFinder {
	
	final int limit = 11;
	final Node start;
	final Node end;
	HashMap<Node, String > visited;
	HashMap<Node, Long> distance;
	PriorityQueue<Node> stack;
	
	public shortestPathFinder(Node start, Node end)	{
		this.start = start;
		this.end = end;
		stack = new PriorityQueue<Node>(limit, new Comparator<Node>() {
		    public int compare(Node n1, Node n2) {
		    	return n1.current_distance > n2.current_distance ? 1:-1;
		    }
		});
		
		visited = new HashMap<Node, String>();
	}
	
	
	public void dijkstras()	{
		
		start.setDistance(0L);
		stack.add(start);
		
		while(!stack.isEmpty())	{
			dijkstrasHelper(stack.poll());
			
			if(stack.peek().my_name=="end")	{
				System.out.println("Destination Reached");
				break;
			}
		}
	}
	
	
	public void dijkstrasHelper(Node n)	{
		for(int i = 0; i < n.neibours.size(); i++)	{
			if(!visited.containsKey(n.neibours.get(i)))	{
				if((n.current_distance + n.weights_to.get(i)) < n.neibours.get(i).current_distance)
					n.neibours.get(i).setDistance(n.current_distance + n.weights_to.get(i));
				stack.add(n.neibours.get(i));
				System.out.println("added -> " + n.neibours.get(i).my_name);
			}
			
		}
		
		System.out.println(n.my_name + " " + n.current_distance);
		
		visited.put(n, n.my_name);
	}

	public static void main(String[] args) {
		
		System.out.println("Hello World");
	}

}
