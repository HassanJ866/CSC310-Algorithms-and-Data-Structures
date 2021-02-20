import java.util.Scanner;

public class Prob5 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] pr = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			pr[i] = scan.nextInt();
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				pr[i] = Math.min(pr[i], pr[i - j] + pr[j]);
			}
		}
		System.out.println(pr[n]);

	}

}