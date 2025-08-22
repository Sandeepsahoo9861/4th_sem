package sandeep_kumar_sahoo;
import java.util.*;
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.Queue;

public class DFS {
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
        graph[0].add(new Edge(0, 1));
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

    public static void dfs(ArrayList<Edge> graph[], int curr, boolean vis[]) {
        System.out.println(curr + " ");
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (vis[e.dest]==false) { // Removed the semicolon here
                dfs(graph, e.dest, vis);
              
       		// dfs(graph,e.dest,vis);
            }
        }
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
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        boolean vis[] = new boolean[V]; // When you create a boolean array, all values are initialized to false
        dfs(graph, 0, vis); // Corrected the dfs method call
        System.out.println();
    }
}


//
//Initial Setup
//boolean vis[] = {false, false, false, false, false, false, false};
//Call dfs(graph, 0, vis)
//We will manually follow each recursive call.
//Step-by-Step Dry Run
//Step 1: Start DFS from Node 0
//Mark 0 as visited:
//vis[] = {true, false, false, false, false, false, false}
//Print 0
//Neighbors of 0: [1, 2]
//1 is unvisited → Recur on dfs(graph, 1, vis)
//Step 2: DFS on Node 1
//Mark 1 as visited:
//vis[] = {true, true, false, false, false, false, false}
//Print 1
//Neighbors of 1: [0, 3]
//0 is already visited (skip)
//3 is unvisited → Recur on dfs(graph, 3, vis)
//Step 3: DFS on Node 3
//Mark 3 as visited:
//vis[] = {true, true, false, true, false, false, false}
//Print 3
//Neighbors of 3: [1, 4, 5]
//1 is already visited (skip)
//4 is unvisited → Recur on dfs(graph, 4, vis)
//Step 4: DFS on Node 4
//Mark 4 as visited:
//vis[] = {true, true, false, true, true, false, false}
//Print 4
//Neighbors of 4: [2, 3, 5]
//3 is already visited (skip)
//2 is unvisited → Recur on dfs(graph, 2, vis)
//Step 5: DFS on Node 2
//Mark 2 as visited:
//vis[] = {true, true, true, true, true, false, false}
//Print 2
//Neighbors of 2: [0, 4]
//0 and 4 are already visited, so return to 4.
//Step 6: Backtrack to Node 4
//Next neighbor is 5, which is unvisited → Recur on dfs(graph, 5, vis)
//Step 7: DFS on Node 5
//Mark 5 as visited:
//vis[] = {true, true, true, true, true, true, false}
//Print 5
//Neighbors of 5: [3, 4, 6]
//3 and 4 are already visited (skip)
//6 is unvisited → Recur on dfs(graph, 6, vis)
//Step 8: DFS on Node 6
//Mark 6 as visited:
//vis[] = {true, true, true, true, true, true, true}
//Print 6
//Neighbors of 6: [5]
//5 is already visited, so return to 5.
//Step 9: Backtrack to Node 5
//All neighbors are visited → return to 4.
//Step 10: Backtrack to Node 4
//All neighbors are visited → return to 3.
//Step 11: Backtrack to Node 3
//All neighbors are visited → return to 1.
//Step 12: Backtrack to Node 1
//All neighbors are visited → return to 0.
//Step 13: Backtrack to Node 0
//Next neighbor is 2, but it's already visited.
//All neighbors are visited, so DFS ends.
//Final Output (DFS Traversal Order)
//Copy
//Edit
//0 1 3 4 2 5 6
//This is the order in which nodes were visited.
//
//Key Observations
//DFS goes as deep as possible before backtracking.
//It ensures each node is visited only once using the vis[] array.
//DFS works recursively and stops when all nodes are visited.
