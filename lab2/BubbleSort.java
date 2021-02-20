import java.util.Scanner;

public class BubbleSort {

	// Modified Bubble Sort
	public static void BublSort(int arr[]) {
		int n = arr.length;
		boolean swaps = false;

		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {

					swaps = true;
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
			if (swaps == false)
				break;
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

			BublSort(arr);
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[j] + " ");
			}
			System.out.println();
		}

	}

}
