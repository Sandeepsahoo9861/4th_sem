package sandeep_kumar_sahoo;
import java.util.*;
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.Queue;

public class BFS {
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // Adding edges
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));
        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));
        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));
        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));
        graph[6].add(new Edge(6, 5));
    }

    public static void bfs(ArrayList<Edge> graph[],int v, boolean vis[], int start) {
        Queue<Integer> q = new LinkedList<>();//Queue<Integer> → This declares q as a queue that will store Integer values
        q.add(start);//new LinkedList<>(); → Creates a LinkedList to implement the queue.
                     //Queue is an interface in Java.
                    //LinkedList is a class that implements Queue, meaning it supports FIFO (First-In-First-Out) operations.
                    //Using Queue<Integer> as the reference type ensures that only queue-specific methods 
                     //(add(), remove(), poll(), etc.) are used.
        
        
        
        while (!q.isEmpty()) {
            int curr = q.remove();
            if (vis[curr]==false) {
                System.out.print(curr + " ");
                vis[curr] = true;

                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        /*
          Graph:
          1 --- 3
         /       | \
        0        |  5 -- 6
         \       | /
          2 ---- 4
        */
       
    	
    	int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V];// V is the size of the array graph[].
                                            // ArrayList<Edge> graph[] = new ArrayList[V]; → Creates 
                                              //an array of ArrayLists,
                                                   // where each index represents a node storing its edges 
                                                     //    (connections to other nodes).
                                                       // graph[0]	     {(0,1), (0,2)}
                                                       //graph[1]	  {(1,0), (1,3)}
                                                        // ................... 
                                                        //graph[5]	     {(5,3), (5,4), (5,6)}
                                                       //  graph[6]	       {(6,5)}
        
        
        createGraph(graph);

        boolean vis[] = new boolean[V];//Java, when you create a boolean array, all values
                                       //are automatically initialized to false by default.
        for (int i = 0; i < V; i++) {//This loop is useful if the graph is disconnected (i.e., has multiple separate components).
            if (vis[i]==false) {//If the graph is connected → The loop is unnecessary.
            	              //If the graph is disconnected → The loop ensures all nodes are visited.
            	
                bfs(graph,V, vis,i);
            }
        }
    }
}


//Dry Run for bfs(graph, V, vis, 0)
//We start BFS from node 0.
//
//Initial State
//Queue: {0}
//vis[] = {false, false, false, false, false, false, false}
//Iteration 1: Processing Node 0
//
//curr = q.remove(); // curr = 0
//for (int i = 0; i < graph[0].size(); i++) {
//    Edge e = graph[0].get(i);
//    q.add(e.dest);
//}
//Loop Execution for graph[0]
//
//graph[0].size() = 2 → It has two edges: (0,1) and (0,2).
//graph[0].get(0) = (0,1) → e.dest = 1, so q.add(1).
//graph[0].get(1) = (0,2) → e.dest = 2, so q.add(2).
//Updated Queue: {1,2}
//Updated vis[]: {true, false, false, false, false, false, false}
//
//Iteration 2: Processing Node 1
//
//curr = q.remove(); // curr = 1
//for (int i = 0; i < graph[1].size(); i++) {
//    Edge e = graph[1].get(i);
//    q.add(e.dest);
//}
//Loop Execution for graph[1]
//
//graph[1].size() = 2 → Two edges: (1,0) and (1,3).
//graph[1].get(0) = (1,0) → e.dest = 0, but 0 is already visited, so ignored.
//graph[1].get(1) = (1,3) → e.dest = 3, so q.add(3).
//Updated Queue: {2,3}
//Updated vis[]: {true, true, false, true, false, false, false}
//
//Iteration 3: Processing Node 2
//
//curr = q.remove(); // curr = 2
//for (int i = 0; i < graph[2].size(); i++) {
//    Edge e = graph[2].get(i);
//    q.add(e.dest);
//}
//Loop Execution for graph[2]
//
//graph[2].size() = 2 → Two edges: (2,0) and (2,4).
//graph[2].get(0) = (2,0) → e.dest = 0, but 0 is already visited, so ignored.
//graph[2].get(1) = (2,4) → e.dest = 4, so q.add(4).
//Updated Queue: {3,4}
//Updated vis[]: {true, true, true, true, true, false, false}
//
//Iteration 4: Processing Node 3
//
//curr = q.remove(); // curr = 3
//for (int i = 0; i < graph[3].size(); i++) {
//    Edge e = graph[3].get(i);
//    q.add(e.dest);
//}
//Loop Execution for graph[3]
//
//graph[3].size() = 3 → Three edges: (3,1), (3,4), (3,5).
//graph[3].get(0) = (3,1) → e.dest = 1, but 1 is already visited, so ignored.
//graph[3].get(1) = (3,4) → e.dest = 4, but 4 is already visited, so ignored.
//graph[3].get(2) = (3,5) → e.dest = 5, so q.add(5).
//Updated Queue: {4,5}
//Updated vis[]: {true, true, true, true, true, true, false}
//
//Iteration 5: Processing Node 4
//
//curr = q.remove(); // curr = 4
//for (int i = 0; i < graph[4].size(); i++) {
//    Edge e = graph[4].get(i);
//    q.add(e.dest);
//}
//Loop Execution for graph[4]
//
//graph[4].size() = 3 → Three edges: (4,2), (4,3), (4,5).
//graph[4].get(0) = (4,2) → e.dest = 2, but 2 is already visited, so ignored.
//graph[4].get(1) = (4,3) → e.dest = 3, but 3 is already visited, so ignored.
//graph[4].get(2) = (4,5) → e.dest = 5, but 5 is already visited, so ignored.
//Updated Queue: {5}
//Updated vis[]: {true, true, true, true, true, true, false}
//
//Iteration 6: Processing Node 5
//
//curr = q.remove(); // curr = 5
//for (int i = 0; i < graph[5].size(); i++) {
//    Edge e = graph[5].get(i);
//    q.add(e.dest);
//}
//Loop Execution for graph[5]
//
//graph[5].size() = 3 → Three edges: (5,3), (5,4), (5,6).
//graph[5].get(0) = (5,3) → e.dest = 3, but 3 is already visited, so ignored.
//graph[5].get(1) = (5,4) → e.dest = 4, but 4 is already visited, so ignored.
//graph[5].get(2) = (5,6) → e.dest = 6, so q.add(6).
//Updated Queue: {6}
//Updated vis[]: {true, true, true, true, true, true, true}
//
//Iteration 7: Processing Node 6
//
//
//curr = q.remove(); // curr = 6
//for (int i = 0; i < graph[6].size(); i++) {
//    Edge e = graph[6].get(i);
//    q.add(e.dest);
//}
//Loop Execution for graph[6]
//
//graph[6].size() = 1 → One edge: (6,5).
//graph[6].get(0) = (6,5) → e.dest = 5, but 5 is already visited, so ignored.
//Queue is now empty → BFS ends.
//
//Final Output
//
//0 1 2 3 4 5 6
//This loop ensures BFS explores all neighbors of curr before moving forward.
//
//Let me know if you need more clarification! 🚀
//
//
//
//
//
//
//
//You said:
//  for (int i = 0; i < V; i++) {
//            if (vis[i]==false) {
//                bfs(graph,V, vis,i);
//            }
//        }
//it is useful if the graph is disconnected or what
//ChatGPT said:
//Is This Loop Useful for Disconnected Graphs?
//
//for (int i = 0; i < V; i++) {
//    if (vis[i] == false) {
//        bfs(graph, V, vis, i);
//    }
//}
//Yes, this loop ensures that all nodes in the graph are visited, even if the graph is disconnected.
//
//1. When is This Loop Needed?
//This loop is useful if the graph is disconnected (i.e., has multiple separate components).
//In a connected graph, a single BFS call from any node will visit all nodes, making the loop redundant.
//In a disconnected graph, BFS might miss some nodes if they are not connected to the starting node.
//2. Example 1: Connected Graph (Loop Not Necessary)
//Consider this connected graph:
//
//lua
//Copy
//Edit
//   1 --- 3
//  /       | \
// 0        |  5 -- 6
//  \       | /
//   2 ---- 4
//If we call bfs(graph, V, vis, 0), BFS will visit all nodes in a single call.
//The loop is not needed because all nodes are connected.
//BFS Output (Starting from 0):
//
//Copy
//Edit
//0 1 2 3 4 5 6
//Since vis[] will be {true, true, true, true, true, true, true}, the loop will not enter BFS again.
//
//3. Example 2: Disconnected Graph (Loop is Necessary)
//Consider this disconnected graph:
//
//	Consider this disconnected graph:
//
//		
//		
//		   1 --- 3       5 -- 6
//		  /       |       
//		 0        |       
//		  \       |       
//		   2 ---- 4       
//
//
//
//  IF THE GRAPH IS DISCONNECTED (DRY RUN )

//(i = 1, 2, 3, 4)
//vis[1], vis[2], vis[3], vis[4] are already true, so the loop skips these nodes.
//Step 4: Sixth Iteration (i = 5)
//vis[5] == false, so bfs(graph, V, vis, 5) is called.
//BFS starts at node 5, marking it as visited.
//BFS Call 2 (bfs(graph, V, vis, 5))
//Step	Current Node	Queue (q)	vis[] (Updated)
//1	5	{6}	{true, true, true, true, true, true, false}
//2	6	{}	{true, true, true, true, true, true, true}
//BFS Output after Second Call:
//
//5 6
//BFS stops here because the queue is empty.
//All nodes in component {5,6} are visited.
//Final BFS Output
//
//0 1 2 3 4
//5 6
//First BFS call covered {0,1,2,3,4}.
//Second BFS call covered {5,6}.
//The loop ensured that both disconnected components were visited.
//How Does the for Loop Ensure BFS Runs for the Second Component?
//The reason why BFS automatically runs again for the second component without needing a return statement is because of the structure of the for loop in main().
//
//Let's walk through how it works step by step.
//
//Step 1: The for Loop in main()
//
//for (int i = 0; i < V; i++) {  
//    if (vis[i] == false) {  
//        bfs(graph, V, vis, i);  
//    }
//}
//i = 0 → vis[0] == false, so BFS starts from 0.
//i = 1, 2, 3, 4 → Already visited (vis[i] == true), so BFS is skipped.
//i = 5 → vis[5] == false, so BFS starts again from 5 (second component).
//i = 6 → Already visited from previous BFS, so skipped.
//The loop does not exit after the first BFS call. It keeps checking each node, ensuring BFS runs for all disconnected components.
//
//Step 2: What Happens After First BFS (bfs(graph, V, vis, 0))
//The first BFS call only visits {0,1,2,3,4}.
//
//✔ At this point, vis[] looks like this:
//
//
//vis[] = {true, true, true, true, true, false, false}
//Nodes {0,1,2,3,4} are visited.
//Nodes {5,6} are still unvisited.
//🚀 Now, the for loop continues checking i = 5.
//
//Step 3: The for Loop Detects vis[5] == false
//Since vis[5] == false, the loop calls:
//
//bfs(graph, V, vis, 5);
//Now, BFS runs again for component {5,6}, ensuring those nodes are also visited.
//
//Step 4: BFS Runs for {5,6}
//Step	Current Node	Queue (q)	vis[] (Updated)
//1	5	{6}	{true, true, true, true, true, true, false}
//2	6	{}	{true, true, true, true, true, true, true}
//✔ Now, vis[] becomes:
//
//vis[] = {true, true, true, true, true, true, true}
//Now all nodes are visited.
//
//Step 5: The for Loop Completes
//After BFS finishes for {5,6}:
//
//The loop checks i = 6, but vis[6] == true, so BFS is not called again.
//The loop exits, since all nodes are now visited.
//Final BFS Output
//
//0 1 2 3 4
//5 6
//
//
























