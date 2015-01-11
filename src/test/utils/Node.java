/**
 * 
 */
package test.utils;

/**
 * @author bilahari.th
 *
 */
public class Node {

	int val;
	
	/**
	 * @param val
	 */
	public Node(int val) {
		super();
		this.val = val;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Node [val=" + val + "]";
	}

	private static void swap(Node a, Node b){
		Node temp = a;
		a=b;
		b=temp;

		System.out.println("a : "+a);
		System.out.println("b : "+b);
	}
	
	public static void main(String[] args){
		
		Node a= new Node(5);
		Node b= new Node(10);/*
		System.out.println("a : "+a);
		System.out.println("b : "+b);*/
		swap(a, b);/*
		System.out.println("a : "+a);
		System.out.println("b : "+b);*/
	}
}
