package test.thread.producerConsumer.a3;

import java.util.LinkedList;

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
}
