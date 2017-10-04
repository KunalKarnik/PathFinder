This is an implementation of Dijkstra's algorithm to find the shortest path between a given start and end point.

To make it more powerful for solving the routing problem, I have added a heuristic (A*) to give it some sense.

Ordinarily,
the Dijkstra's algorithm, goes down the shortest path till it encounters a path shorter than what it is currently following;
once it finds a shorter path, it goes down down that path till that is no longer the shortest path; and so on...
Evenually it finds the destination node and stops running since it has travelled down the shortest path that exists to get there!
When the A* heuristic is applied;
We can negatively reinforce going in any direction other than towards the final target node. 
And positively reinforce any path moving towards the destination. 
If we use a large value for the dampener, only the path leading towards the destination 
will be checked (i.e. the optimal path might not be found) 
where as if we use a smaller value for the dampener, more paths will be checked.
