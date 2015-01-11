package test.thread.producerConsumer.a7;

import java.util.LinkedList;

import test.utils.FileUtils;

public class Storage {

	LinkedList<Integer> storage;
	int maxSize=20;

	@Override
	public String toString() {
		return "Storage [storage=" + storage.getFirst() + "..."+storage.getLast()+"]";
	}

	public Storage(LinkedList<Integer> storage) {
		super();
		this.storage = storage;
	}

	public Storage(LinkedList<Integer> storage, int maxSize) {
		super();
		this.storage = storage;
		this.maxSize = maxSize;
	}

	public LinkedList<Integer> getStorage() {
		return storage;
	}

	public int getMaxSize() {
		return maxSize;
	}

	public synchronized void addToStorage(Integer i){
		FileUtils.appendToFile("\n_____________________________________", "D:\\a.txt",true);
		if(storage.size()>=maxSize){
			try {
				FileUtils.appendToFile("\n"+Thread.currentThread().getName()+" Going to wait","D:\\a.txt",true);
				wait();
				return;	// else i value issue
			} catch (InterruptedException e) {
				FileUtils.appendToFile("\n"+Thread.currentThread().getName()+" Interrupted","D:\\a.txt",true);
			}
		}
		storage.add(i);
		FileUtils.appendToFile("\n"+Thread.currentThread().getName()+" Producing : "+i,"D:\\a.txt",true);
		FileUtils.appendToFile("\nStorage size : "+storage.size(), "D:\\a.txt",true);
		FileUtils.appendToFile("\n"+"Storage : "+this,"D:\\a.txt",true);
		notifyAll();
	}

	public synchronized int takeFromSTorage(){
		FileUtils.appendToFile("\n_____________________________________", "D:\\a.txt",true);
		if(storage.size()<1){
			try {
				FileUtils.appendToFile("\n"+Thread.currentThread().getName()+" Going to wait","D:\\a.txt",true);
				wait();
				return -1;	//	just to make outputs separation clean
			} catch (InterruptedException e) {
				FileUtils.appendToFile("\n"+Thread.currentThread().getName()+" Interrupted","D:\\a.txt",true);
			}
		}
		int num = storage.remove();
		FileUtils.appendToFile("\n"+Thread.currentThread().getName()+" Consuming : "+num,"D:\\a.txt",true);
		FileUtils.appendToFile("\nStorage size : "+storage.size(), "D:\\a.txt",true);
		if(storage!=null && this.storage.size()>0){
			FileUtils.appendToFile("\n"+"Storage : "+this,"D:\\a.txt",true);
		}
		notifyAll();
		return num;
	}

}
