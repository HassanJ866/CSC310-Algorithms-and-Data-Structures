import java.util.Scanner;

public class prob6 {
	public static void main(String args[]) throws InterruptedException {
		double min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		double average = 0;
		Scanner scan = new Scanner(System.in);
		int array[] = new int[scan.nextInt()];
		for (int i = 0; i < array.length; i++)
			array[i] = scan.nextInt();
		thread6 t = new thread6("MAX", array, max);
		thread6 t2 = new thread6("MIN", array, min);
		thread6 t3 = new thread6("AVERAGE", array, average);
		t.start();
		t2.start();
		t3.start();
		t.join();
		t2.join();
		t3.join();
		System.out.println("min = " + (int)t2.getRes());
		System.out.println("max = " + (int) t.getRes());
		System.out.println("average = " + t3.getRes());
	}
}
