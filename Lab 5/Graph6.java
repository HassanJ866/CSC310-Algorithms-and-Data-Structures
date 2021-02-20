
import java.io.*;
import java.util.*;

public class Graph6 {
	private int V; 
	private LinkedList<Integer> adj[]; 


	@SuppressWarnings("unchecked")
	Graph6(int v) {
		V = v;
		adj = new LinkedList[V];
		for (int i = 0; i < v; ++i)
			adj[i] = new LinkedList<Integer>();
	}

	void addEdge(int v, int w) {
		adj[v].add(w);
		adj[w].add(v);
	}

	boolean isCyclicUtil(int v, boolean visited[], int parent) {
		visited[v] = true;
		Integer i;

		Iterator<Integer> it = adj[v].iterator();
		while (it.hasNext()) {
			i = it.next();

			if (!visited[i]) {
				if (isCyclicUtil(i, visited, v))
					return true;
			}

			else if (i != parent)
				return true;
		}
		return false;
	}

	boolean isTree() {
		boolean visited[] = new boolean[V];
		for (int i = 0; i < V; i++)
			visited[i] = false;

		if (isCyclicUtil(0, visited, -1))
			return false;

		for (int u = 0; u < V; u++)
			if (!visited[u])
				return false;

		return true;
	}

	public static void main(String args[]) {
		int count = 1;
		Scanner scan = new Scanner(System.in);

		int v = scan.nextInt();
		int e = scan.nextInt();
		Graph6 g = new Graph6(v);

		while (count <= e) {
			int source = scan.nextInt();
			int destination = scan.nextInt();
			g.addEdge(source, destination);
			count++;
		}

		if (g.isTree())
			System.out.println("tree");
		else
			System.out.println("not tree");

	}
}