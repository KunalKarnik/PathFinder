import java.util.*;
//import java.util.Map.Entry;

public class shortestPathFinder {
	
	final int limit = 11;
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
		    	return n1.current_distance > n2.current_distance ? 1:-1;
		    }
		});
		visited = new HashMap<Node, String>();
		previous = new HashMap<String, String>();
	}
	
	
	public String dijkstras()	{
		start.setDistance(0L);
		stack.add(start);
		while(!stack.isEmpty())	{
			dijkstrasHelper(stack.poll());
			if(stack.peek().my_name=="end")	{
				System.out.println("Destination is " +  stack.peek().current_distance + " units away.");
				break;
			}
		}
		String trace_back = "";
		String temp = "end";
		while(temp!="start")	{
			trace_back = temp + " --> " + trace_back;
			temp = previous.get(temp);
		}
		trace_back = "start --> " + trace_back;
		System.out.println(trace_back+ "\uDFC1");	//checkered flag	
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
