import java.util.Scanner;

public class SelcSort {
	public static int[] swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		return arr;
	}

	public static void SelSort(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			int minInd = i;
			for (int k = i + 1; k < n; k++) {
				if (arr[k] < arr[minInd])
					minInd = k;
			}
			swap(arr, i, minInd);

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

			SelSort(arr);
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[j] + " ");
			}
			System.out.println();
		}

	}

}
