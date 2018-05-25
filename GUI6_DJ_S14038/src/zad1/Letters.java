package zad1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Letters {
List<Thread> arr=new ArrayList<Thread>();
Runnable rr;
int x=0;
	public Letters(String string) throws InterruptedException {
		
		while(x<=string.length()-1){
			char k=string.charAt(x);
			rr= () -> { while(!Thread.currentThread().isInterrupted()){try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				  Thread.currentThread().interrupt();
				  break;
			}System.out.print(""+k);} };
			arr.add(new Watek(rr, k));
			
			x++;
		}
		
	}

	public List<Thread> getThreads(){
		
		
		return arr;
	}


	
	
	
}
