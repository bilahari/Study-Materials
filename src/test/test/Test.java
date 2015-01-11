/**
 * 
 */
package test.test;

import java.util.LinkedList;

/**
 * @author bilahari.th
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedList<Integer> c = new LinkedList<Integer>();
		
		A a= new A(c);
		B b=new B(c);
		
		c.add(1);
		a.getA().add(2);
		b.getB().add(3);

		System.out.println("c : "+c);
		System.out.println("a : "+a);
		System.out.println("b : "+b);
		
		if (a.getA()==b.getB() && b.getB()==c) {
			System.out.println(":)");
		}
	}

}
