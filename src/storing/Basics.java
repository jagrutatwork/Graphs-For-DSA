package storing;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Basics {

	// Edge class to represent edges in the vertices that will be used in an
	// ArrayList to
	// represent connections between vertices of our Graph
	static class Edge {

		int src;
		int dest;

		public Edge(int src, int dest) {
			this.src = src;
			this.dest = dest;
		}

	}

	// REPRESTATION USING ADJECANCY LIST :
	// We use an Array of ArrayList<Edge> to represent a Graph
	// We create a null Array of ArrayList<Edge> and pass it to th createGraph
	// function
	public static void createGraph(ArrayList<Edge> graph[]) {
		// First we will add an empty ArrayList<Edge> at every index of the graph
		for (int i = 0; i < graph.length; i++) {

			// at every index of the graph array we are adding an empty ArrayList<Edge>
			graph[i] = new ArrayList<Edge>();
		}

		// now inside the graph we would add egdes in the ArrayList<Edge>
		// so every index has an ArrayList, to which we will add Edges
		graph[0].add(new Edge(0, 1));
		graph[0].add(new Edge(0, 2));

		graph[1].add(new Edge(1, 0));
		graph[1].add(new Edge(1, 3));

		graph[2].add(new Edge(2, 0));
		graph[2].add(new Edge(2, 4));

		graph[3].add(new Edge(3, 1));
		graph[3].add(new Edge(3, 4));
		graph[3].add(new Edge(3, 5));

		graph[3].add(new Edge(4, 2));
		graph[3].add(new Edge(4, 3));
		graph[3].add(new Edge(4, 5));

		graph[3].add(new Edge(5, 3));
		graph[3].add(new Edge(5, 4));
		graph[3].add(new Edge(5, 6));

		graph[3].add(new Edge(6, 5));
	}

	// CREATE GRAPH USING LINKED LIST :
	public static void createGraphUsingLL(LinkedList<Edge> graph[]) {
		// First we will add an empty ArrayList<Edge> at every index of the graph
		for (int i = 0; i < graph.length; i++) {

			// at every index of the graph array we are adding an empty ArrayList<Edge>
			graph[i] = new LinkedList<Edge>();
		}

		// now inside the graph we would add egdes in the ArrayList<Edge>
		// so every index has an ArrayList, to which we will add Edges
		graph[0].add(new Edge(0, 1));
		graph[0].add(new Edge(0, 2));

		graph[1].add(new Edge(1, 0));
		graph[1].add(new Edge(1, 3));

		graph[2].add(new Edge(2, 0));
		graph[2].add(new Edge(2, 4));

		graph[3].add(new Edge(3, 1));
		graph[3].add(new Edge(3, 4));
		graph[3].add(new Edge(3, 5));

		graph[3].add(new Edge(4, 2));
		graph[3].add(new Edge(4, 3));
		graph[3].add(new Edge(4, 5));

		graph[3].add(new Edge(5, 3));
		graph[3].add(new Edge(5, 4));
		graph[3].add(new Edge(5, 6));

		graph[3].add(new Edge(6, 5));
	}

	// BFS --> BREADTH FIRST SEARCH FOR JOINED (CONNECTED GRAPHS WITHOUT DISJOINTED
	// COMPONENTS)
	public static void bfs(ArrayList<Edge> graph[], int V) {

		// We declare a queue using linkedlist
		Queue<Integer> q = new LinkedList<>();

		// we declare a boolean array to keep a track of the visited nodes
		boolean visited[] = new boolean[V];
		q.add(0);

		// Until the queue is Empty
		while (!q.isEmpty()) {
			// at every step we remove the front element from the queue //FIFO
			int curr = q.remove();
			// We perform next steps --> printing the current and adding it's neighbours to
			// the quueue
			// Only if the curr is not visitec i.e. visited[curr]==false
			if (visited[curr] == false) {
				// print the curr
				System.out.print(curr + " ");

				// add the curr's neighbours i.e.
				// we get the edges at that position in the graph, and then add their
				// destinations(neighours to the queue)
				for (int i = 0; i < graph[curr].size(); i++) {
					Edge e = graph[curr].get(i);
					q.add(e.dest);
				}
			}
		}

	}

	// BFS --> BREADTH FIRST SEARCH FOR JOINED (CONNECTED GRAPHS WITHOUT DISJOINTED
	// COMPONENTS)
	public static void bfs2(ArrayList<Edge> graph[], int V, boolean visited[], int start) {

		// We declare a queue using linkedlist
		Queue<Integer> q = new LinkedList<>();

		//passing start instead of 0
		q.add(start);

		// Until the queue is Empty
		while (!q.isEmpty()) {
			// at every step we remove the front element from the queue //FIFO
			int curr = q.remove();
			// We perform next steps --> printing the current and adding it's neighbours to
			// the quueue
			// Only if the curr is not visitec i.e. visited[curr]==false
			if (visited[curr] == false) {
				// print the curr
				System.out.print(curr + " ");

				// add the curr's neighbours i.e.
				// we get the edges at that position in the graph, and then add their
				// destinations(neighours to the queue)
				for (int i = 0; i < graph[curr].size(); i++) {
					Edge e = graph[curr].get(i);
					q.add(e.dest);
				}
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Creating graph using ArrayList<Edge>
		int V = 7;

		ArrayList<Edge> graph[] = new ArrayList[V];
		// Array which stores elements of type ArrayList(which is an ArrayList that
		// stored edges)

		createGraph(graph);

		// CreatingGraph using a LinkedList:
		int V1 = 7;

		LinkedList<Edge> graph1[] = new LinkedList[V1];
		// Array which stores elements of type ArrayList(which is an ArrayList that
		// stored edges)

		createGraphUsingLL(graph1);

		// simplified bfs:
		bfs(graph, V);

		// BFS FOR DISJOINTED GRAPH WITH MULTIPLE COMPONENTS:
		// We create the visited in the main itself
		boolean visited[] = new boolean[V];
		
		//and we apply a loop from 0 to the number of vertices 
		//so that we can pass disjointed components to our bfs method
		//Here we need to pass the start too everytime the component changes
		//in our case we have a single component so we dont need to
		for (int i = 0; i < V; i++) {
			if (visited[i] == false) {
				bfs2(graph, V, visited, i);
			}

		}

	}

}
