import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Graph3 {
	int V;
	LinkedList<Integer>[] adjListArray;

	Graph3(int V) {
		this.V = V;
		adjListArray = new LinkedList[V];
		for (int i = 0; i < V; i++) {
			adjListArray[i] = new LinkedList<Integer>();
		}
	}

	void addEdge(int src, int dest) {
		adjListArray[src].add(dest);
		adjListArray[dest].add(src);
	}

	void DFS(int v, boolean[] visited) {
		visited[v] = true;
		System.out.print(v + " ");
		for (int x : adjListArray[v]) {
			if (!visited[x])
				DFS(x, visited);
		}

	}
	
	void DFS1(int v, boolean[] visited) {
		visited[v] = true;
		for (int x : adjListArray[v]) {
			if (!visited[x])
				DFS1(x, visited);
		}

	}

	void connectedComponents() {
		ArrayList<Integer> arlist = new ArrayList<Integer>();
		boolean[] visited = new boolean[V];
		int counter = 0;
		for (int v = 0; v < V; ++v) {
			if (!visited[v]) {
				DFS1(v, visited);
				counter++;
			}
		}
		System.out.println(counter);
		boolean[] visited2 = new boolean[V];

		for (int v = 0; v < V; ++v) {
			if (!visited2[v]) {
				DFS(v, visited2);
				System.out.println();
			}
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int count = 1;

		int v = scan.nextInt();
		int e = scan.nextInt();
		Graph3 g = new Graph3(v);

		while (count <= e) {
			int source = scan.nextInt();
			int destination = scan.nextInt();
			g.addEdge(source, destination);
			count++;
		}

		g.connectedComponents();

	}
}