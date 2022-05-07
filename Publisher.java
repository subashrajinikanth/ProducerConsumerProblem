package semaphore;

import java.util.LinkedList;
import java.util.Random;

public class Publisher implements Runnable {
	private LinkedList<Integer> ll;
	int i;

	public Publisher(LinkedList<Integer> ll, int i) {
		this.ll = ll;
		this.i = i;

	}

	@Override
	public void run() {
		while (true) {
			try {
				publish();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	private void publish() throws InterruptedException {
		synchronized (ll) {
			while (ll.size() == 5) {
				System.out.println(Thread.currentThread().getName()+"Publisher waiting....");
				ll.wait();
			}
			Random r = new Random();
			int n = r.nextInt(100);
			System.out.println(Thread.currentThread().getName()+"Publisher Published the book  :" + n);

			ll.add(n);
			System.out.println("current List of books is  :"+ll);
			Thread.sleep(2000);
			ll.notify();

		}

	}

}
