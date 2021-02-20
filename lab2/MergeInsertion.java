import java.util.Scanner;

public class MergeInsertion {
	public static int[] swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		return arr;
	}

	public static void Sort(int[] arr, int l, int r) {
		if (r - l >= 2) {
			int m = (l + r) / 2;
			Sort(arr, l, m);
			Sort(arr, m + 1, r);
			merge(arr, l, m, r);
		}
		else {
			InsSort(arr);
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

	public static void InsSort(int arr[]) {
		for (int i = 1; i < arr.length; i++) {
			int j = i - 1;
			while (j >= 0 && arr[j] > arr[j + 1]) {
				int temp = arr[j];
				arr[j] = arr[j + 1];
				arr[j + 1] = temp;
				j--;
			}
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
