package test.thread.oddEven.a2;

import java.util.LinkedList;

import test.utils.FileUtils;

public class OddConsumer implements Runnable{

	LinkedList<Integer> storage = new LinkedList<Integer>();

	public OddConsumer(LinkedList<Integer> storage) {
		super();
		this.storage = storage;
	}

	@Override
	public void run() {

		try{
			synchronized (storage) {
				if(storage.size()<1){
					try {
						FileUtils.appendToFile("\n"+Thread.currentThread().getName()+" Going to wait as no elements in storage","D:\\a.txt",true);
						storage.wait();
						FileUtils.appendToFile("\n"+Thread.currentThread().getName()+" Notified 1","D:\\a.txt",true);
					} catch (InterruptedException e) {
						FileUtils.appendToFile("\n"+Thread.currentThread().getName()+" Interrupted","D:\\a.txt",true);
					}
				}
			}

			for(int i=0;;i++){
				synchronized (storage) {
					if(i>=storage.size()){
						try {
							FileUtils.appendToFile("\n"+Thread.currentThread().getName()+" Going to wait as all are processed","D:\\a.txt",true);
							storage.wait();
							FileUtils.appendToFile("\n"+Thread.currentThread().getName()+" Notified 2","D:\\a.txt",true);
						} catch (InterruptedException e) {
							FileUtils.appendToFile("\n"+Thread.currentThread().getName()+" Interrupted","D:\\a.txt",true);
						}
					}
				}

				if(storage.get(i)%2 == 1){
					FileUtils.appendToFile("\n"+Thread.currentThread().getName()+" Consuming : "+storage.get(i),"D:\\a.txt",true);
				}
			}
		}catch(Exception e){
			FileUtils.appendToFile("\n"+Thread.currentThread().getName()+" Exception : "+e.getMessage(),"D:\\a.txt",true);
		}
	}
}
