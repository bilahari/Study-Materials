package test.thread.producerConsumer.a2;

import java.util.LinkedList;

interface Storage {

	LinkedList<Integer> storage = new LinkedList<Integer>();
	
	Object lock = new Object();
}
