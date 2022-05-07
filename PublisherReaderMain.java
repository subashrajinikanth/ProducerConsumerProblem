package semaphore;

import java.util.LinkedList;

public class PublisherReaderMain {

	public static void main(String[] args) {
		LinkedList<Integer> ll = new LinkedList<>();
		
		Publisher publisher1 = new Publisher(ll,1);
		Reader reader1= new Reader(ll);
		
		Thread t1 = new Thread(publisher1,"publisher thread - 1 ");
		Thread t2= new Thread(reader1,"Reader Thread- 1");
		t1.start();
		t2.start();
		
		System.out.println("Main thread........");
		
		
		Publisher publisher2 = new Publisher(ll, 2);
		Reader reader2 = new Reader(ll);
		
		Thread t3 = new Thread(publisher2,"publisherThread - 2 ");
		Thread t4 = new Thread(reader2,"reader thread - 2 ");
		t3.start();
		t4.start();
		
		Reader reader3 = new Reader(ll);
		Reader reader4 = new Reader(ll);
		Reader reader5 = new Reader(ll);
		Thread r3= new Thread(reader3,"reader Thread - 3 ");
		Thread r4= new Thread(reader4,"reader Thread - 4 ");
		Thread r5= new Thread(reader5,"reader Thread - 5 ");
		r3.start();
		r4.start();
		r5.start();
		
		
		
		
		
		
		

	}

}
