/**
 * 
 */
package test.test;

import java.util.LinkedList;

/**
 * @author bilahari.th
 *
 */
public class B {

	LinkedList<Integer> b;

	/**
	 * @param a
	 */
	public B(LinkedList<Integer> a) {
		super();
		this.b = a;
	}

	/**
	 * @return the a
	 */
	public LinkedList<Integer> getB() {
		return b;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "B [b=" + b + "]";
	}
	
	
}
