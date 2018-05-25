/**
 *
 *  @author Domański Jan S14038
 *
 */

package zad1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;


public class Main {

	public static void main(String[] args) {

		
		ArrayList<Towar> towar = new ArrayList<>();
	    
		
		
		Thread A = new Thread(new Runnable() {

			public void run() {

				try {
					FileReader fr = new FileReader("../Towary.txt");
					BufferedReader br = new BufferedReader(fr);
					int counter = 0;
					String sCurrentLine;

					String[] args;
					
						
					while ((sCurrentLine = br.readLine()) != null) {
						
						synchronized (towar) {
							
							while(Towar.lock){
							 try {
								
							        towar.wait();
							      } catch(InterruptedException exc) {
							    	  
							      }
							 
							}
			
							args = sCurrentLine.split("\\s+");

							towar.add(new Towar(Integer.parseInt(args[0]),
									Long.parseLong(args[1])));
					
							counter++;
							
							if (counter % 200 == 0 && counter != 0) {
								System.out.println("utworzono " + counter
										+ " obiektów");
							
								Towar.lock=true;
								 towar.notify();
						
							}
							
						
						}

					}
					
				} catch (Exception ex) {

				}
				Towar.koniec=false;
			//	System.out.println("Done -A:"+Towar.koniec);	
			}
			
		});
		A.start();
		
		
		

		Thread B = new Thread(new Runnable() {

			@Override
			public void run() {
				
	 long sum = 0;
	 
	 
	 while(Towar.koniec){
	 synchronized (towar) {
		
			while(!Towar.lock){
				 try {
					 
				        towar.wait();
				      } catch(InterruptedException exc) {
				    	  
				    }
				}
	
				for (int i = 0; i <towar.size(); i++) {
					
				sum+=towar.get(i).waga;
					if(Towar.counter%100==0){
				System.out.println("policzono wage " + Towar.counter
						+ " obiektów");	
					}
					Towar.counter++;
				}
				
				
				
				towar.clear();
				if(Towar.koniec!=false){
				Towar.lock=false;
				}
				
				towar.notify();
				
						
					}

	 }
	 System.out.println(sum);

				}

			

		});
		B.start();

	}
}
