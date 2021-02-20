import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Graph5 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int e = scan.nextInt();
		Graph5 g = new Graph5(n);
		for (int i = 0; i < e; i++) {
			int x = scan.nextInt();
			int y = scan.nextInt();
			g.addedges(x, y);
		}
		boolean b = g.isbipartite();
		if (b) {
			System.out.println("bipartite");
		} else {
			System.out.println("not bipartite");
		}
	}

	private int n;
	private LinkedList<Integer> adj[];

	public Graph5(int n) {
		this.n = n;
		adj = new LinkedList[n];
		for (int i = 0; i < n; i++) {
			adj[i] = new LinkedList();
		}
	}

	public void addedges(int x, int y) {
		adj[x].add(y);

	}

	public boolean isbipartite() {
		Queue<Integer> queue = new LinkedList<>();
		int color[] = new int[n];

		for (int i = 0; i < n; i++) {
			if (color[i] == 0) {
				color[i] = 1;
				queue.add(i);
				while (queue.size() != 0) {
					int x = queue.poll();
					Iterator<Integer> iter = adj[x].listIterator();
					while (iter.hasNext()) {
						int y = iter.next();
						if (color[y] == color[x]) {
							return false;
						}
						if (color[y] == 0) {
							color[y] = 3 - color[x];
							queue.add(y);
						}
					}
				}
			}
		}
		return true;
	}
}