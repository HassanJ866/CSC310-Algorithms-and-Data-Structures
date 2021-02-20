
public class MyThread extends Thread {
	int id;

	public MyThread(int id) {
		super();
		this.id = id;
	}

	@Override
	public void run() {
		System.out.println("Hello world from " + id);
	}
}
