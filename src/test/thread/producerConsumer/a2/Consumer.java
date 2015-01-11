package test.thread.producerConsumer.a2;

public class Consumer implements Runnable{

	@Override
	public void run() {
		while(true){
			synchronized (Storage.lock) {
				if(!Storage.storage.isEmpty()){
					System.out.println("Consuming : "+Storage.storage.remove());
					System.out.println("Storage : "+Storage.storage.toString()+"\n_____________________________________________");
				}
			}
		}
	}
}
