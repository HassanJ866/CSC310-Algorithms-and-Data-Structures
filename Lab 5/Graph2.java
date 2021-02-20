import java.util.LinkedList;
import java.util.Scanner;

public class Graph2 {

	static class Graph {
		int v;
		LinkedList<Integer> adj[];

		public Graph(int v) {
			this.v = v;
			adj = new LinkedList[v];
			for (int i = 0; i < v; i++) {
				adj[i] = new LinkedList<>();
			}
		}

		public void addEdge(int source, int destination) {
			adj[source].addFirst(destination);
			adj[destination].addFirst(source);
		}
	}

	public void isConnected(Graph graph) {

		int v = graph.v;
		LinkedList<Integer> adj[] = graph.adj;

		boolean[] visited = new boolean[v];

		DFS(0, adj, visited);

		int count = 0;
		for (int i = 0; i < visited.length; i++) {
			if (visited[i])
				count++;
		}
		if (v == count) {
			System.out.println("connected");
		} else {
			System.out.println("not connected");
		}
	}

	public void DFS(int source, LinkedList<Integer> adj[], boolean[] visited) {

		visited[source] = true;

		for (int i = 0; i < adj[source].size(); i++) {
			int neighbor = adj[source].get(i);
			if (visited[neighbor] == false) {
				DFS(neighbor, adj, visited);
			}
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int count = 1;

		int v = scan.nextInt();
		int e = scan.nextInt();
		Graph g = new Graph(v);

		while (count <= e) {
			int source = scan.nextInt();
			int destination = scan.nextInt();
			g.addEdge(source, destination);
			count++;
		}
		Graph2 c = new Graph2();

		c.isConnected(g);
	}

}