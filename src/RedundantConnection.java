// A Java Program to detect cycle in an undirected graph
import java.io.*;
import java.util.*;

// This class represents a directed graph using adjacency list
// representation
class Graph
{
	private int V; // No. of vertices
	private LinkedList<Integer> adj[]; // Adjacency List Represntation
	
	// Constructor
	Graph(int v) {
		V = v;
		adj = new LinkedList[v];
		for(int i=0; i<v; ++i)
			adj[i] = new LinkedList();
	}
	
	// Function to add an edge into the graph
	void addEdge(int v,int w) {
		adj[v].add(w);
		adj[w].add(v);
	}
	
	void removeEdge(int v,int w){
	    adj[v].remove(adj[v].indexOf(w));
	    adj[w].remove(adj[w].indexOf(v));
	}

	// A recursive function that uses visited[] and parent to detect
	// cycle in subgraph reachable from vertex v.
	Boolean isCyclicUtil(int v, Boolean visited[], int parent)
	{
		// Mark the current node as visited
		visited[v] = true;
		Integer i;

		// Recur for all the vertices adjacent to this vertex
		Iterator<Integer> it = adj[v].iterator();
		while (it.hasNext())
		{
			i = it.next();

			// If an adjacent is not visited, then recur for that
			// adjacent
			if (!visited[i])
			{
				if (isCyclicUtil(i, visited, v))
					return true;
			}

			// If an adjacent is visited and not parent of current
			// vertex, then there is a cycle.
			else if (i != parent)
				return true;
		}
		return false;
	}

	// Returns true if the graph contains a cycle, else false.
	Boolean isCyclic()
	{
		// Mark all the vertices as not visited and not part of
		// recursion stack
		Boolean visited[] = new Boolean[V];
		for (int i = 0; i < V; i++)
			visited[i] = false;

		// Call the recursive helper function to detect cycle in
		// different DFS trees
		for (int u = 0; u < V; u++)
			if (!visited[u]) // Don't recur for u if already visited
				if (isCyclicUtil(u, visited, -1))
					return true;

		return false;
	}
}

public class RedundantConnection {

	public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int count = 0;
        for(int[] edge : edges){
        	for(int node : edge){
        	if(!map.containsKey(node)){
        		map.put(node, count);
        		count++;
        	}
        	}
        }
        Graph graph = new Graph(count);
        for(int[] edge : edges){
        	graph.addEdge(map.get(edge[0]),map.get(edge[1]));
        }
        for(int i = n - 1 ; i >= 0 ; i--){
        	int[] edge = edges[i];
        	graph.removeEdge(map.get(edge[0]), map.get(edge[1]));
        	if(!graph.isCyclic())
        		return edge;
        	graph.addEdge(map.get(edge[0]), map.get(edge[1]));
        }
        return null;
    }
	
	/*
	public static void main(String[] args){
		RedundantConnection obj = new RedundantConnection();
		int[][] edges = {{1,2},{1,3},{2,3}};
		int[] result = obj.findRedundantConnection(edges);
		System.out.println("result");
		for(int i : result)
			System.out.println(i);
	}
	*/
}
