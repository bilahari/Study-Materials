package test.thread.producerConsumer.a3;

import test.utils.FileUtils;

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
			storage.getStorage().add(num++);
			FileUtils.appendToFile("\n"+Thread.currentThread().getName()+"Producing : "+num,"D:\\a.txt",true);
			FileUtils.appendToFile("\n"+"Storage : "+storage.toString()
					+"\n_____________________________________________","D:\\a.txt",true);
		}
	}
}
