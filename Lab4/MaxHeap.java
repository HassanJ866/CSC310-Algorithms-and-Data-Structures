import java.util.Scanner;

public class MaxHeap {
	private int[] heap;
	private int size;
	private int maxsize;

	public MaxHeap(int maxsize) {
		this.maxsize = maxsize;
		this.size = 0;
		heap = new int[this.maxsize + 1];
		heap[0] = Integer.MAX_VALUE;
	}

	private int parent(int p) {
		return p / 2;
	}

	private void swap(int first, int sec) {
		int tmp;
		tmp = heap[first];
		heap[first] = heap[sec];
		heap[sec] = tmp;
	}

	public void insert(int element) {
		heap[++size] = element;

		int current = size;
		while (heap[current] > heap[parent(current)]) {
			swap(current, parent(current));
			current = parent(current);
		}
	}

	public void print() {
		for (int i = 1; i <= size; i++) {
			System.out.print(heap[i] + " ");
		}
	}

	public static void main(String[] arg) {
		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();
		MaxHeap maxheap = null;
		for (int i = 0; i < n; i++) {
			int n2 = scan.nextInt();
			maxheap = new MaxHeap(n2);
			for (int j = 0; j < n2; j++) {
				maxheap.insert(scan.nextInt());
			}
			maxheap.print();
		}

	}
}
