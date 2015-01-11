package test.thread.oddEven.a4;

import java.util.LinkedList;

/**
 *	here both Producer and consumer jobs are synchronized on the lock object in storage interface 
 *	@see the run method for both
 *
 */
public class Test {

	public static void main(String[] args){
		LinkedList<Integer> ll = new LinkedList<Integer>();

		Producer producer = new Producer(ll);
		Thread producerThread = new Thread(producer);
		producerThread.setName("P-1");

		OddConsumer oddConsumer = new OddConsumer(ll);
		Thread oddConsThread = new Thread(oddConsumer);
		oddConsThread.setName("OC");

		EvenConsumer evenConsumer = new EvenConsumer(ll);
		Thread evenConsThread = new Thread(evenConsumer);
		evenConsThread.setName("EC");

		Thread firstThread = oddConsThread;
		if(firstThread==oddConsThread){
			evenConsumer.setOtherThread(oddConsThread);
		}else{
			oddConsumer.setOtherThread(evenConsThread);
		}

		oddConsThread.start();
		evenConsThread.start();
		producerThread.start();


		System.err.println(ll);
		try {
			oddConsThread.join();
			evenConsThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(ll);
	}
}