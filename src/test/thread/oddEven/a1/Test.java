package test.thread.oddEven.a1;

import java.util.LinkedList;

/**
 *	here both Producer and consumer jobs are synchronized on the lock object in storage interface 
 *	@see the run method for both
 *
 */
public class Test {

	public static void main(String[] args){

		LinkedList<Integer> ll = new LinkedList<Integer>();
		for(int i=0;i<1000;i++){
			ll.add(i);
		}

		EvenConsumer evenConsumer = new EvenConsumer(ll);
		OddConsumer OddConsumer = new OddConsumer(ll);

		Thread consumerThread = new Thread(OddConsumer);
		consumerThread.setName("Odd-Consumer");
		consumerThread.start();
		
		Thread consumerThread2 = new Thread(evenConsumer);
		consumerThread2.setName("Even-Consumer");
		consumerThread2.start();
	}
}