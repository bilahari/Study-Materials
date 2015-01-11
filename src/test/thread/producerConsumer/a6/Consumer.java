package test.thread.producerConsumer.a6;

public class Consumer implements Runnable{

	Storage storage;

	public Consumer(Storage storage) {
		super();
		this.storage = storage;
	}

	@Override
	public void run() {
		while(true){
			consume();	
		}
	}

	private void consume(){
		synchronized (storage) {
			storage.takeFromSTorage();
		}
	}
}
