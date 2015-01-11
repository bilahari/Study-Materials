package test.thread.producerConsumer.a4;

import java.util.LinkedList;

/**
 *	here both Producer and consumer jobs are synchronized on the lock object in storage interface 
 *	@see the run method for both
 *
 */
public class Test {

	public static void main(String[] args){

		LinkedList<Integer> ll = new LinkedList<Integer>();
		Storage storage = new Storage(ll);

		Producer producer = new Producer(storage);
		Consumer consumer = new Consumer(storage);

		Thread producerThread = new Thread(producer);
		producerThread.setName("P-1");
		producerThread.start();
		Thread producerThread2 = new Thread(producer);
		producerThread2.setName("P-2");
		producerThread2.start();
		Thread producerThread3 = new Thread(producer);
		producerThread3.setName("P-3");
		producerThread3.start();

		Thread consumerThread = new Thread(consumer);
		consumerThread.setName("C-1");
		consumerThread.start();
		Thread consumerThread2 = new Thread(consumer);
		consumerThread2.setName("C-2");
		consumerThread2.start();
		Thread consumerThread3 = new Thread(consumer);
		consumerThread3.setName("C-3");
		consumerThread3.start();

	}
}