/**
 * 
 */
package test.thread;

import java.util.ArrayList;

/**
 * @author bilahari.th
 *
 */
public class Test {

	public static void main(String[] args){
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(1);
		a.add(2);
		a.add(3);
		a.add(4);
		a.add(5);
		a.add(6);
		a.add(7);
		a.add(8);
		a.add(9);
		a.add(10);
		ThreadTest tt = new ThreadTest(a);

		Thread thread = new Thread(tt);
		thread.setName("odd");
		thread.start();
		
		Thread evenThread = new Thread(tt);
		evenThread.setName("even");
		evenThread.start();
	}
}
