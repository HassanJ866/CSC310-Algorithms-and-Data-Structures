import java.util.Scanner;

public class VC {

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int e = scan.nextInt();
		int k = scan.nextInt();
		int[][] al = new int[n][n];
		int degree[] = new int[n];

		for (int i = 0; i < e; i++) {
			int v1 = scan.nextInt();
			int v2 = scan.nextInt();
			al[v1][degree[v1]++] = v2;
			al[v2][degree[v2]++] = v1;
		}

		if (vc(al, degree, k)) {
			System.out.println("Yes");
		} else
			System.out.println("No");

	}

	public static boolean deleteEdge(int[][] al, int[] degree, int v1, int v2) {

		for (int i = 0; i < degree[v1]; i++) {

			if (al[v1][i] == v2) {

				int tmp = al[v1][degree[v1] - 1];

				al[v1][degree[v1] - 1] = v2;

				al[v1][i] = tmp;

				degree[v1]--;
				return true;
			}
		}
		return false;
	}

	public static int maxdegree(int[] degree) {

		int max = 0;

		for (int i = 1; i < degree.length; i++) {
			if (degree[i] > degree[max]) {
				max = i;
			}
		}
		return max;
	}

	public static void deleteVertex(int[][] al, int[] degree, int v) {

		for (int i = 0; i < degree[v]; i++) {

			deleteEdge(al, degree, al[v][i], v);

		}

		degree[v] = 0;
	}

	public static void vtoc(int[][] al, int[] degree, int v) {

		for (int i = 0; i < degree[v]; i++) {

			deleteEdge(al, degree, al[v][i], v);
		}

		degree[v] = -1;
	}

	public static boolean edgeless(int[] degree) {

		for (int i = 0; i < degree.length; i++) {

			if (degree[i] > 0) {

				return false;
			}
		}
		return true;
	}

	public static boolean vc(int[][] al, int[] degree, int k) {

		int[] degree1 = new int[degree.length];

		int mdv = maxdegreeree(degree);

		if (degree[mdv] > 2) {

			while (!edgeless(degree)) {
				mdv = maxdegreeree(degree);
				vtoc(al, degree, mdv);
				k--;
			}
		}

		if (k < 0) {
			return false;
		}

		if (edgeless(degree)) {
			return true;
		}

		if (k == 0) {
			return false;
		}

		for (int i = 0; i < degree.length; i++) {

			degree1[i] = degree[i];
		}
		vtoc(al, degree1, mdv);

		if (vc(al, degree1, k)) {

			for (int i = 0; i < degree.length; i++) {
				degree[i] = degree1[i];
			}
			return true;
		}

		if (degree[mdv] > k) {
			return false;
		}
		for (int i = 0; i < degree[mdv]; i++) {

			vtoc(al, degree, mdv);
			k--;
		}

		return vc(al, degree, k);
	}
}