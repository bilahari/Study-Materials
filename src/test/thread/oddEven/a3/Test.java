package test.thread.oddEven.a3;

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
			producerThread.start();

			OddConsumer OddConsumer = new OddConsumer(ll);
			Thread oddConsThread = new Thread(OddConsumer);
			oddConsThread.setName("OC");
			oddConsThread.start();

			EvenConsumer evenConsumer = new EvenConsumer(ll);
			evenConsumer.setOtherThread(oddConsThread);
			Thread evenConsThread = new Thread(evenConsumer);
			evenConsThread.setName("EC");
			evenConsThread.start();
			
			System.err.println(ll);
			try {
				oddConsThread.join();
				evenConsThread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(ll);
	}
}