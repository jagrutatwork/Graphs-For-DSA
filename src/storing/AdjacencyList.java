package storing;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class AdjacencyList // List of lists //Array of ArrayLists
{

	static class Edge {
		int s;// Source
		int d;// Destination

		public Edge(int s, int d) {
			this.s = s;
			this.d = d;
		}
	}

	public static void createGraph(ArrayList<Edge> graph[]) {
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<Edge>();// Adding a null Arraylist<Edge> at all the poisitions inside the array
												// graph{}
		}

		
		
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

	//Breadth First Search
	public static void bfs(ArrayList<Edge> graph[], int V) { //for connected, joimed components graph
		
		Queue<Integer> q = new LinkedList<>();
		 boolean visited[] = new boolean[V];
		 q.add(0);
		 
		 while(!q.isEmpty())
		 {
			  int curr = q.remove(); 
			  if(visited[curr]==false)
			  {
				  System.out.print(curr+" ");
				  visited[curr] = true;
				  
				  for(int i=0; i<graph[curr].size(); i++)
				  {
					  Edge e = graph[curr].get(i);
					  q.add(e.d); 
				  }
			  }
		 }

	}
	

	//Disjointed(general) Breadth First Search
public static void bfs(ArrayList<Edge> graph[], int V, boolean visited[], int start) {
		
		Queue<Integer> q = new LinkedList<>();
		 
		 q.add(start);
		 
		 while(!q.isEmpty())
		 {
			  int curr = q.remove(); 
			  if(visited[curr]==false)
			  {
				  System.out.print(curr+" ");
				  visited[curr] = true;
				  
				  for(int i=0; i<graph[curr].size(); i++)
				  {
					  Edge e = graph[curr].get(i);
					  q.add(e.d); 
				  }
			  }
		 }

	}

	//Depth First Search --> Recursion


	public static void main(String[] args) {

		int V = 7;

		ArrayList<Edge> graph[] = new ArrayList[V];
		// Array which stores elements of type ArrayList(which is an ArrayList that
		// stored edges)

		createGraph(graph);
		// print 2's neighbours
		
		//bfs(graph, V);
		
		//For disjointed components graph :
		boolean visited[] = new boolean[V];
		
		for(int i=0; i<V; i++) {
			if(visited[i] == false)
			{
				 bfs(graph, V, visited, i);
			}
			
		}
//
//		for (int i = 0; i < graph[1].size(); i++) {
//			Edge e = graph[1].get(i);
//			System.out.print(e.d + " ");
//		}

	}

}
