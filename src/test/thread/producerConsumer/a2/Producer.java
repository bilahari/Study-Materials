package test.thread.producerConsumer.a2;

public class Producer implements Runnable{

	static int num=0;
	@Override
	public void run() {
		while(true){
			synchronized (Storage.lock) {
				Storage.storage.add(num++);
				System.out.println("Producing : "+num);
				System.out.println("Storage : "+Storage.storage.toString()+"\n_____________________________________________");
			}
		}
	}
}
