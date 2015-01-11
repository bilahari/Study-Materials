package test.thread.producerConsumer.a1;

/**
 *	here both Producer and consumer jobs are not synchronized  @see the run method for both
 *
 */
public class Test {

	public static void main(String[] args){

		Producer producer = new Producer();
		Consumer consumer = new Consumer();

		Thread producerThread = new Thread(producer);
		producerThread.setName("producer");
		producerThread.start();

		Thread consumerThread = new Thread(consumer);
		consumerThread.setName("consumer");
		consumerThread.start();
	}
}