package semaphore;

import java.util.LinkedList;
import java.util.Random;

public class Reader implements Runnable{
	private LinkedList<Integer> ll;

	public Reader(LinkedList<Integer> ll) {
		this.ll = ll;

	}

	@Override
	public void run() {
		while(true) {
			try {
				read();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

	private void read() throws InterruptedException {
		synchronized (ll) {
			while(ll.size()==0) {
				System.out.println(Thread.currentThread().getName()+"Reader is Waiting......");
				ll.wait();
			}
			
		
			System.out.println(Thread.currentThread().getName()+"Reader Reading the book..."+ll.remove(0));
			Thread.sleep(2000);
			ll.notify();
		}
		
	}

}
