package sandeep_kumar_sahoo;

import java.util.ArrayList;

import sandeep_kumar_sahoo.DFS.Edge;

public class All_paths_from_src_to_tar_by_DFS {

	 static class Edge {
	        int src;
	        int dest;

	        public Edge(int s, int d) {
	            this.src = s;
	            this.dest = d;
	        }
	    }

	    static void createGraph(ArrayList<Edge> graph[]) {//initially graph is fill with null if we not remove
	                                                       //  the null it will show error
	    for (int i = 0; i < graph.length; i++) {//initially it was filled with graph = [null, null, null, null];
	            graph[i] = new ArrayList<>();//later graph = [[], [], [], []];
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
	    public static void printAllPath(ArrayList<Edge>[] graph, boolean[] vis, int curr, String path, int tar) {
	        if (curr == tar) {
	            System.out.println(path);
	            return;
	        }
	        for (int i = 0; i < graph[curr].size(); i++) {
	            Edge e = graph[curr].get(i);
	            if (!vis[e.dest]) {
	                vis[curr] = true;
	                printAllPath(graph, vis, e.dest, path + e.dest, tar);
	                vis[curr] = false;
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

	      int src=0,tar=5;
	      boolean[] vis = new boolean[V];
	        String path = src + " ";
	      printAllPath(graph, vis, src, path, tar);
	    }
	}
