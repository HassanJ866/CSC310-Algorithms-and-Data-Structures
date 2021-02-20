import java.util.*;

public class Graph1 {

	public static void BFS(LinkedList<Integer> adj[]) {
		int[] color = new int[adj.length];
		Queue<Integer> queue = new LinkedList<Integer>();
		for (LinkedList<Integer> x : adj) {
			if (x.size() == 0)
				continue;
			if (color[x.getFirst()] == 0) {
				queue.offer(x.getFirst());
				color[x.getFirst()] = 1;
				while (!queue.isEmpty()) {
					int u = queue.poll();
					color[u] = 2;
					System.out.print(u + " ");
					Iterator<Integer> i = adj[u].listIterator();
					while (i.hasNext()) {
						int j = i.next();
						if (color[j] == 0) {
							color[j] = 1;
							queue.add(j);
						}
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

			int v = scan.nextInt();
			int e = scan.nextInt();

			LinkedList<Integer> adj[] = new LinkedList[v];
			for (int i = 0; i < v; i++)
				adj[i] = new LinkedList<>();
			for (int i = 0; i < e; i++) {
				int x = scan.nextInt();
				int y = scan.nextInt();
				if (!adj[x].contains(x))
					adj[x].add(x);
				adj[x].add(y);
			}

			BFS(adj);
			scan.close();
	}
}