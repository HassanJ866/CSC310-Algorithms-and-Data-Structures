//Thread Class vs Runnable Interface
//1. If we extend the Thread class, our class cannot extend any other class because Java doesn’t support multiple inheritance. But, if we implement the Runnable interface, our class can still extend other base classes.
//2. We can achieve basic functionality of a thread by extending Thread class because it provides some inbuilt methods like yield(), interrupt() etc. that are not available in Runnable interface.
//https://www.geeksforgeeks.org/multithreading-in-java/

public class prob2 {
	public static void main(String[] args) {
		//Method 1: This is printing the ids assigned by the system
		for (int i = 0; i < 5; i++) {
			Thread t = new Thread(new Runnable() {
				@Override
				public void run() {
					System.out.println("HEllo from " +
				Thread.currentThread().getId());
				}
			});
			t.start();
		}
		//Method 2: Printing the ids we assign in the for loop.
		//MyThread is a class we created that 
		//extends the Thread class
		for (int i = 0; i < 5; i++) {
			MyThread th = new MyThread(i);
			th.start();
		}
		//MEthod 3: printing the ids we assign
		//The thread objects takes as an argument a Runnable object
		//we created a MyRun class that implements 
		//the Runnable interface
		for (int i = 0; i < 5; i++) {
			Thread th = new Thread(new MyRun(i));
			th.start();
		}
	}

}
