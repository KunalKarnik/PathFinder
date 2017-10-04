import java.util.*;
//import java.util.Map.Entry;

public class shortestPathFinder {
	
	final int limit = 11;
	final double dampener = 1; // the lever to control the heuristic power
	final Node start;
	final Node end;
	HashMap<Node, String > visited;
	HashMap<String, String > previous;
	PriorityQueue<Node> stack;
	
	public shortestPathFinder(Node start, Node end)	{
		this.start = start;
		this.end = end;
		stack = new PriorityQueue<Node>(limit, new Comparator<Node>() {
		    public int compare(Node n1, Node n2) {
		    	//We can negatively reinforce going in any direction other than 
		    	//towards the final target node.
		    	//And positively reinforce any path moving towards the destination.
		    	//If we use a large value for the dampener, only the path leading 
		    	//towards the destination will be checked (i.e. the optimal path might not be found)
		    	//where as if we use a smaller value for the dampener, more paths will be checked.
		    	return (n1.current_distance + dampener*n1.distance_to_target) > (n2.current_distance + dampener*n2.distance_to_target) ? 1:-1;
		    //The comparator controls the positioning of nodes in the priority Queue,
		    	//thus we simply need to add a component of the distance_to_target to the 
		    	//comparison formulae as shown above!
		    }
		});
		visited = new HashMap<Node, String>();
		previous = new HashMap<String, String>();
	}
	
	
	public String dijkstras()	{
		start.setDistance(0L);
		stack.add(start);
		int count = 0;
		while(!stack.isEmpty())	{
			dijkstrasHelper(stack.poll());
			if(stack.peek().my_name=="end")
				break;
			count++;
		}
		String trace_back = "";
		String temp = "end";
		while(temp!="start")	{
			trace_back = temp + " --> " + trace_back;
			temp = previous.get(temp);
		}
		trace_back = "start --> " + trace_back;
		System.out.println(trace_back + "\uDFC1");	//checkered flag	
		System.out.println("Nodes checked --> " + count);
		return trace_back;
	}
	
	
	public void dijkstrasHelper(Node n)	{
		for(int i = 0; i < n.neibours.size(); i++)	{
			if(!visited.containsKey(n.neibours.get(i)))	{
				Node temp = n.neibours.get(i);
				if(stack.contains(temp))
					stack.remove(temp);
				if((n.current_distance + n.weights_to.get(i)) < n.neibours.get(i).current_distance)	{
					n.neibours.get(i).setDistance(n.current_distance + n.weights_to.get(i));
					previous.put(n.neibours.get(i).my_name, n.my_name);
				}
				stack.add(n.neibours.get(i));
			}	
		}
		visited.put(n, n.my_name);
	}
}
