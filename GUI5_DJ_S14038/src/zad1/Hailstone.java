package zad1;

import java.util.Iterator;
import java.util.LinkedList;

public class Hailstone implements Iterable<Integer>{
	public static int start=0;
	
Iterowany it=null;

	public Hailstone(int init) {
		it=new Iterowany();
	while(init!=1){
		if(start==0){
			start++;
			
			it.dodaj(init);
		}else{
			
			while(init!=1){
				if(init%2==0){
					init=init/2;
					it.dodaj(init);
				}else{
					init=3*init+1;
					it.dodaj(init);
				}
				
			}
			
		}
	
	}



        
	}
	

	@Override
	public Iterator<Integer> iterator() {
		
		
		
		return it.getIt();
	
		
	}
	
	


}
