package test.thread.producerConsumer.a5;

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
		storage.add(i);
		FileUtils.appendToFile("\n"+Thread.currentThread().getName()+"Producing : "+i,"D:\\a.txt",true);
		FileUtils.appendToFile("\n"+"Storage : "+this
				+"\n_____________________________________________","D:\\a.txt",true);
	}

	public synchronized int takeFromSTorage(){
		if(storage.size()>0){
			int num = storage.remove();
			FileUtils.appendToFile("\n"+Thread.currentThread().getName()+"Consuming : "+num,"D:\\a.txt",true);
			if(storage!=null && this.storage.size()>0){
				FileUtils.appendToFile("\n"+"Storage : "+this
						+"\n_____________________________________________","D:\\a.txt",true);
			}
			return num;
		}else{
			FileUtils.appendToFile("\n"+Thread.currentThread().getName()+"\nnothing left to consume","D:\\a.txt",true);
			return -1;
		}
	}

}
