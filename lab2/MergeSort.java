import java.util.Scanner;

public class MergeSort {
	public static int[] swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		return arr;
	}

	public static void Sort(int[] arr, int l, int r) {
		if (l < r) {
			int m = (l + r) / 2;

			Sort(arr, l, m);
			Sort(arr, m + 1, r);

			merge(arr, l, m, r);
		}
	}

	private static void merge(int[] arr, int l, int m, int r) {

		int[] L = new int[m - l + 1];
		int[] R = new int[r - m];

		for (int i = 0; i < L.length; i++)
			L[i] = arr[i + l];

		for (int i = 0; i < R.length; i++)
			R[i] = arr[m + 1 + i];

		int i = 0;
		int j = 0;
		int k = l;

		while (i < L.length && j < R.length) {
			if (L[i] >= R[j]) {
				arr[k] = R[j];
				j++;
			} else {
				arr[k] = L[i];
				i++;
			}
			k++;
		}

		while (i < L.length) {
			arr[k] = L[i];
			i++;
			k++;
		}

		/* Copy remaining elements of R[] if any */
		while (j < R.length) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		for (int i = 0; i < n; i++) {
			int n2 = scan.nextInt();
			int[] arr = new int[n2];
			for (int j = 0; j < n2; j++) {
				arr[j] = scan.nextInt();
			}

			Sort(arr, 0, arr.length - 1);
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[j] + " ");
			}
			System.out.println();
		}

	}

}
