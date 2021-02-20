
public class MyRun implements Runnable {
	int id;

	public MyRun(int i) {
		this.id = i;
	}

	public void run() {
		System.out.println("Heloooo + " + id);
	}
}
