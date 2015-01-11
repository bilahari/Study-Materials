package test.thread.oddEven.a4;

import java.util.LinkedList;

import test.utils.FileUtils;

public class Producer implements Runnable{

	LinkedList<Integer> storage = new LinkedList<Integer>();
	private int num=0;

	public Producer(LinkedList<Integer> storage) {
		super();
		this.storage = storage;
	}

	@Override
	public void run() {
		while(num++<100){
			FileUtils.appendToFile("\n"+Thread.currentThread().getName()+" Producing : "+num,"D:\\a.txt",true);
			synchronized (storage) {
				storage.add(num);
				storage.notifyAll();
			}
		}
	}
}
