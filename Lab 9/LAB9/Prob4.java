import java.util.Scanner;

public class Prob4 {

	static int count(int S[], int m, int n) {
		if (n == 0)
			return 1;

		if (n < 0)
			return 0;

		if (m <= 0 && n >= 1)
			return 0;

		return count(S, m - 1, n) + count(S, m, n - S[m - 1]);
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		int arr[] = new int[m];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scan.nextInt();
		}
		System.out.println(count(arr, m, n));

	}

}