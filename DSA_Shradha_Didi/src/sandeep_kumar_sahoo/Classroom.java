package sandeep_kumar_sahoo;

import java.util.ArrayList;

public class Classroom {

    // Static nested class for Edge
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;  // Assign 's' to 'src'
            this.dest = d; // Assign 'd' to 'dest'
        }
    }

    // Method to create the graph
    public static void createGraph(ArrayList<Edge>[] graph) {//initially graph is fill with null if we not remove
    	                                               // the null it will show error
    	                                     //initially it was filled with graph = [null, null, null, null];
    	                                    //later graph = [[], [], [], []];
        for (int i = 0; i < graph.length; i++) {// * graph.length effectively gives the number of vertices.
                                           //*length is a property of arrays and gives the total number of elements the array can hold.

            graph[i] = new ArrayList<Edge>(); // Initialize each list
        }
        // Add edges to the graph
        graph[0].add(new Edge(0, 2));//  What It Means:
                                        //graph[0]:
        	                            // This refers to the adjacency list for vertex 0.
        	                           //It is an ArrayList that will store all the outgoing edges from vertex 0.
                                        //Imagine vertex 0 is a city, and graph[0] is the list of all cities you can drive to from city 0.
                                      // Adding Edge(0, 2) means you’ve added a road from city 0 to city 2.
                                      //0 → 2
                                       // graph[0] = [Edge(0, 2)]
        graph[1].add(new Edge(1, 2));//graph[1] = [Edge(1, 2), Edge(1, 3)]
        graph[1].add(new Edge(1, 3)); 
        graph[2].add(new Edge(2, 0));  //graph[2] = [Edge(2, 0), Edge(2, 1), Edge(2, 3)]
        		                         
      
        graph[2].add(new Edge(2, 0));//
        graph[2].add(new Edge(2, 1));//
        graph[2].add(new Edge(2, 3));//
        graph[3].add(new Edge(3, 1));//graph[3] = [Edge(3, 1), Edge(3, 2)]
        graph[3].add(new Edge(3, 2));//
    }

    public static void main(String[] args) {
        int v = 4;                        //graph is an array of size v (4 in this case), 
                                           //where each index (graph[0], graph[1], etc.) will store a list of edges 
        ArrayList<Edge>[] graph = new ArrayList[v]; //connected to that vertex.

        // Create the graph
        createGraph(graph);

        // Print the destinations of edges for vertex 2
        for (int i = 0; i < graph[2].size(); i++) {//size() is a method of ArrayList and gives the actual number of elements
        	                                       //stored in the list
        	
        	// So, graph[2] has 3 edges, and hence, graph[2].size() 
        	                                        //will return 3.
        	                                      // graph[2].add(new Edge(2, 0));
        	                                      // graph[2].add(new Edge(2, 1));
        	                                      // graph[2].add(new Edge(2, 
        	Edge e = graph[2].get(i);            //The for loop iterates over all edges in graph[2].
            System.out.println(e.src + "->" + e.dest + " ");    //Edge e = graph[2].get(i):
                                                 //When i = 0, graph[2].get(0) gives the edge Edge(2, 0).
                                                 //When i = 1, graph[2].get(1) gives the edge Edge(2, 1).
            		                             //When i = 2, graph[2].get(2) gives the edge Edge(2, 3).
        }
    }
}


       // important for knowledge

//The Edge Constructor and Object Creation
//When you write this line inside the createGraph method:
//

//graph[2].add(new Edge(2, 0));
//Creating an Edge Object:
//
//The new Edge(2, 0) part calls the Edge constructor.
//The constructor takes two arguments (s and d), and assigns them to src and dest:

//public Edge(int s, int d) {
//    this.src = s;  // src = 2
//    this.dest = d; // dest = 0
//}
//An Edge object is created with src = 2 and dest = 0.
//Adding the Edge to the List:
//
//After creating the Edge(2, 0) object, it is added to the graph[2] list:

//graph[2].add(new Edge(2, 0)); // Adds Edge(2, 0) to graph[2]
//So now, graph[2] contains one Edge object:

//graph[2] = [Edge(2, 0)];
//Multiple Edge Objects in the List
//When you do this:

//graph[2].add(new Edge(2, 1));
//graph[2].add(new Edge(2, 3));
//Here’s what happens step-by-step:
//
//Create Edge(2, 1):
//
//A new Edge object is created using the constructor, and src = 2, dest = 1 is assigned.
//This new Edge(2, 1) object is then added to graph[2]:

//graph[2].add(new Edge(2, 1)); // Adds Edge(2, 1) to graph[2]
//Now graph[2] contains:

//graph[2] = [Edge(2, 0), Edge(2, 1)];
//Create Edge(2, 3):
//
//Another new Edge object is created, this time with src = 2 and dest = 3, and added to graph[2]:

//graph[2].add(new Edge(2, 3)); // Adds Edge(2, 3) to graph[2]
//Now graph[2] contains:

//graph[2] = [Edge(2, 0), Edge(2, 1), Edge(2, 3)];
//How It Stores Multiple Values
//The graph[2] list holds multiple Edge objects.
//
//Each Edge object has its own src and dest values:
//
//The first Edge has src = 2 and dest = 0.
//The second Edge has src = 2 and dest = 1.
//The third Edge has src = 2 and dest = 3.
//Each Edge object is a separate entity (or instance) that is stored in the graph[2] list.
//
//So, the list graph[2] can contain multiple Edge objects, each with its own src and dest values, because each Edge is a separate object created by the constructor.
//
//Final Example for graph[2]:
//After all the edges are added:

//graph[2] = [Edge(2, 0), Edge(2, 1), Edge(2, 3)];
//Each Edge object is independent, meaning the src and dest values are stored separately in each object, and the graph[2] list just keeps references to these Edge objects.
//
//
