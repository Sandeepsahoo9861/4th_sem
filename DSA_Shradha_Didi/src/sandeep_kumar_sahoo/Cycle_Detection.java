package sandeep_kumar_sahoo;

import java.util.ArrayList;

public class Cycle_Detection {
    static class Edge {                //
        int src;                       //      1------>0
        int dest;                      //              | ↖
                                       //                 \
        public Edge(int s, int d) {    //              ↓   3
            this.src = s;              //              2 ↗   
            this.dest = d;             //
        }                              //
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 0));
    }

    public static boolean isCycleDirected(ArrayList<Edge> graph[], boolean vis[], int curr, boolean rec[]) {
        vis[curr] = true; // it will detect the weather the node is already visited or not,so it will deny to
                          // visit the same node once again(because may be, we visited that node previously)
                            
        rec[curr] = true;// it will detect ,if same node is true before and and again check if it is true again
                         // it means there is cycle
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (rec[e.dest]) { //it's equivalent to:  if (rec[e.dest] == true) 
                return true;
            } else if (!vis[e.dest]) {
                if (isCycleDirected(graph, vis, e.dest, rec)) {
                    return true;
                }
            }
        }
        rec[curr] = false;
        return false;
    }

    public static void main(String[] args) {
        int v = 4;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        System.out.println(isCycleDirected(graph, new boolean[v], 0, new boolean[v]));
    }
}



//Given Graph Representation
//Copy
//Edit
//0 → 2
//1 → 0
//2 → 3
//3 → 0
//This forms a cycle: 0 → 2 → 3 → 0.
//
//Function Call
//We start with:
//
//
//isCycleDirected(graph, vis = [false, false, false, false], curr = 0, rec = [false, false, false, false])
//Initial Updates
//
//vis[0] = true;   // Mark 0 as visited → [true, false, false, false]
//rec[0] = true;   // Mark 0 in recursion stack → [true, false, false, false]
//Now, we loop through neighbors of 0.
//
//Step 1: Loop Execution for Node 0
//
//for (int i = 0; i < graph[0].size(); i++) { // graph[0] → [2]
//    Edge e = graph[0].get(i);  // e.dest = 2
//e.dest = 2, so we check:
//java
//Copy
//Edit
//if (rec[2]) {  // rec[2] = false
//False, so we move to:
//java
//Copy
//Edit
//else if (!vis[2]) {  // vis[2] = false
//True, so we call:
//
//isCycleDirected(graph, vis, 2, rec);
//Step 2: Function Call for Node 2
//
//isCycleDirected(graph, vis = [true, false, false, false], curr = 2, rec = [true, false, false, false])
//Updates
//
//vis[2] = true;   // Mark 2 as visited → [true, false, true, false]
//rec[2] = true;   // Mark 2 in recursion stack → [true, false, true, false]
//Now, loop through neighbors of 2.
//
//Step 3: Loop Execution for Node 2
//
//for (int i = 0; i < graph[2].size(); i++) { // graph[2] → [3]
//    Edge e = graph[2].get(i);  // e.dest = 3
//e.dest = 3, so we check:
//
//if (rec[3]) {  // rec[3] = false
//False, so we move to:
//
//else if (!vis[3]) {  // vis[3] = false
//True, so we call:
//
//isCycleDirected(graph, vis, 3, rec);
//Step 4: Function Call for Node 3
//
//isCycleDirected(graph, vis = [true, false, true, false], curr = 3, rec = [true, false, true, false])
//Updates
//
//vis[3] = true;   // Mark 3 as visited → [true, false, true, true]
//rec[3] = true;   // Mark 3 in recursion stack → [true, false, true, true]
//Now, loop through neighbors of 3.
//
//Step 5: Loop Execution for Node 3
//
//for (int i = 0; i < graph[3].size(); i++) { // graph[3] → [0]
//    Edge e = graph[3].get(i);  // e.dest = 0
//e.dest = 0, so we check:
//
//if (rec[0]) {  // rec[0] = true
//True! → Cycle detected!
//Return true from isCycleDirected(graph, vis, 3, rec).
//Since true is returned, the recursive calls propagate back, returning true from node 2, then from node 0.
//Tracking vis[] and rec[] in Each Step
//Step	Current Node	vis[] (Visited Nodes)	rec[] (Recursion Stack)	Next Action
//1	0	[true, false, false, false]	[true, false, false, false]	Call 2
//2	2	[true, false, true, false]	[true, false, true, false]	Call 3
//3	3	[true, false, true, true]	[true, false, true, true]	Call 0
//4	0	[true, false, true, true]	[true, false, true, true]	Cycle detected!
//Final Output
//
//true  // The graph contains a cycle
//Why was the Cycle Detected?
//We started from 0, followed 0 → 2 → 3 → 0.
//When we reached 0 again and it was still in the recursion stack (rec[0] = true), we detected a cycle.
//The function returned true up the recursion chain.
//
