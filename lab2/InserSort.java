import java.util.Scanner;

public class InserSort {
	public static int[] swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		return arr;
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

			InsSort(arr);
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[j] + " ");
			}
			System.out.println();
		}

	}

}
