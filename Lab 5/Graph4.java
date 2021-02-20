
import java.io.*;
import java.util.*;

public class Graph4 {
	private int V;
	private LinkedList<Integer> adj[];
	private boolean visited[] = new boolean[V];

	Graph4(int v) {
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i)
			adj[i] = new LinkedList();
	}

	void addEdge(int v, int w) {
		adj[v].add(w);
	}

	void BFS(int s) {
		LinkedList<Integer> queue = new LinkedList<Integer>();

		queue.add(s);
		visited[s] = true;

		while (queue.size() != 0) {
			s = queue.poll();
			System.out.print(s + " ");

			Iterator<Integer> i = adj[s].listIterator();
			while (i.hasNext()) {
				int n = i.next();
				if (!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}
		}

	}

	Boolean visitedAlr(int v, Boolean visited[], int parent) {
		visited[v] = true;
		Integer i;

		Iterator<Integer> it = adj[v].iterator();
		while (it.hasNext()) {
			i = it.next();

			if (!visited[i]) {
				if (visitedAlr(i, visited, v))
					return true;
			}

			else if (i != parent)
				return true;
		}
		return false;
	}

	Boolean isCyclic() {

		Boolean visited[] = new Boolean[V];
		for (int i = 0; i < V; i++)
			visited[i] = false;

		for (int u = 0; u < V; u++) {

			if (!visited[u])
				if (visitedAlr(u, visited, -1))
					return true;
		}

		return false;
	}

	public static void main(String args[]) {
		int count = 1;
		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();
		int e = scan.nextInt();
		Graph4 g = new Graph4(n);

		while (count <= e) {
			int source = scan.nextInt();
			int destination = scan.nextInt();
			g.addEdge(source, destination);
			count++;
		}
		if (g.isCyclic())
			System.out.println("no");
		else
			System.out.println("yes");
	}
}
