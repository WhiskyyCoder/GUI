/**
 *
 *  @author Domański Jan S14038
 *
 */

package zad2;

import java.util.concurrent.LinkedBlockingQueue;


public class Author implements Runnable {
String[] tab;
public  LinkedBlockingQueue<String> kolejka=new LinkedBlockingQueue<>();
public Author(String [] tab) {
	this.tab=tab;
}
	@Override
	public void run() {
		for(String x:tab){
			
			try {
				Thread.sleep(1000);
				kolejka.put(x);
			} catch (InterruptedException e) {
				// TODO: handle exception
				return;
			}catch(NullPointerException nullp){
				return;
				
			}
			
			
			
		}
		
	}

}  
