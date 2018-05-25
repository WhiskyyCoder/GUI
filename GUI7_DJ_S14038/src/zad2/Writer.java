/**
 *
 *  @author Domański Jan S14038
 *
 */

package zad2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


//Klasa "wypisywacza"
public class Writer implements Runnable{
Author auth;
ExecutorService exec=Executors.newCachedThreadPool();
	public Writer(Author autor) {
		auth=autor;
	
		exec.execute(autor);
		exec.execute(this);
		exec.shutdown();
	}

	@Override
	public void run() {
		while(true){
			try {
				String w=auth.kolejka.take();
				if(w.equals(""))break;
				System.out.println("-> "+w);
			} catch (InterruptedException e) {
				// TODO: handle exception
				break;
			}
			
			
		}
	}



}
