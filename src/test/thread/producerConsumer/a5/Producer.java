package test.thread.producerConsumer.a5;

public class Producer implements Runnable{

	Storage storage;
	private int num=0;

	public Producer(Storage storage) {
		super();
		this.storage = storage;
	}

	@Override
	public void run() {
		while(true){
			produce();
		}
	}

	private void produce(){
		synchronized (storage) {
			storage.addToStorage(num++);
		}
	}
}
