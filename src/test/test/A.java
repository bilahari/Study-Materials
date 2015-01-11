/**
 * 
 */
package test.test;

import java.util.LinkedList;

/**
 * @author bilahari.th
 *
 */
public class A {

	LinkedList<Integer> a;

	/**
	 * @param a
	 */
	public A(LinkedList<Integer> a) {
		super();
		this.a = a;
	}

	/**
	 * @return the a
	 */
	public LinkedList<Integer> getA() {
		return a;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "A [a=" + a + "]";
	}
	
	
}
