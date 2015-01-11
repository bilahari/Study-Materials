package test.thread.producerConsumer.a3;

import test.utils.FileUtils;

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
			if(storage.getStorage().size()>0){
				FileUtils.appendToFile("\n"+Thread.currentThread().getName()+"Consuming : "+storage.getStorage().remove(),"D:\\a.txt",true);
				FileUtils.appendToFile("\n"+"Storage : "+storage
						+"\n_____________________________________________","D:\\a.txt",true);
			}
		}
	}
}
