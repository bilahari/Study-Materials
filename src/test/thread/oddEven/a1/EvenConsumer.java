package test.thread.oddEven.a1;

import java.util.LinkedList;

import test.utils.FileUtils;

public class EvenConsumer implements Runnable{

	LinkedList<Integer> storage = new LinkedList<Integer>();

	public EvenConsumer(LinkedList<Integer> storage) {
		super();
		this.storage = storage;
	}

	@Override
	public void run() {
		for(int i:storage){
			if(i%2==0){
				FileUtils.appendToFile("\n"+Thread.currentThread().getName()+" : "+i,"D:\\a.txt",true);
			}
		}
	}
}
