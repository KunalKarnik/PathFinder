import java.util.*;
import java.util.Map.Entry;

public class shortestPathFinder {
	
	final Node start;
	final Node end;
	SortedMap<Long, Node> stack;
	HashMap<Node, String > visited;
	
	public shortestPathFinder(Node start, Node end)	{
		this.start = start;
		this.end = end;
		stack = new TreeMap<Long, Node>();
		// Two places might have the same name, thus the key is the Node itself
		visited = new HashMap<Node, String>();
	}
	
	
	public void dijkstras()	{
		
		stack.put(0L,start);
		
		while(!stack.isEmpty())	{
			run(stack.get(stack.firstKey()));
		}
	}
	
	
	public void run(Node n)	{
		for(int i = 0; i < n.neibours.size(); i++)	{
			if(!visited.containsKey(n.neibours.get(i)))	{
				stack.put((long) Integer.MAX_VALUE, n.neibours.get(i));
				
			}
		}
		visited.put(n, n.my_name);
		stack.remove(stack.firstKey(),n);

		for(Entry<Long, Node> entry : stack.entrySet()) {
			  System.out.print(entry.getValue().my_name);
			}
		System.out.println(stack.toString());
		
	}
	
	
	
	

	public static void main(String[] args) {
		
		System.out.println("Hello World");
	}

}
