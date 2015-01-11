package test.thread.producerConsumer.a1;

public class Consumer implements Runnable{

	@Override
	public void run() {
		while(true){
				if(!Storage.storage.isEmpty()){
					System.out.println("Consuming : "+Storage.storage.remove());
					System.out.println("Storage : "+Storage.storage.toString()+"\n_____________________________________________");
				}
		}
	}
}
