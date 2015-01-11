/**
 * 
 */
package test.thread;

import java.util.ArrayList;

/**
 * @author bilahari.th
 *
 */
public class ThreadTest implements Runnable{

	ArrayList<Integer> a = new ArrayList<Integer>();

	/**
	 * @param a
	 */
	public ThreadTest(ArrayList<Integer> a) {
		super();
		this.a = a;
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){

			if(Thread.currentThread().getName().equalsIgnoreCase("odd")){
				if(!a.isEmpty()){
					for(int i=0;i<a.size();i++){
						if(a.get(i)%2==1){
							System.out.println("Odd : "+a.get(i));
							a.remove(i);
						}
					}
				}
			}

			if(Thread.currentThread().getName().equalsIgnoreCase("even")){
				if(!a.isEmpty()){
					for(int i=0;i<a.size();i++){
						if(a.get(i)%2==0){
							System.out.println("Even : "+a.get(i));
							a.remove(i);
						}
					}
				}
			}
		}
	}

}
