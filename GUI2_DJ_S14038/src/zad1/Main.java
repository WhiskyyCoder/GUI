/**
 *
 *  @author Domański Jan S14038
 *
 */

package zad1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    String fname = System.getProperty("user.home") + "/tab.txt";            
    try {
		FileReader fr= new FileReader(fname);
		
		   ArrayList<Integer> arr=new ArrayList<Integer>();
		
		   
		   Scanner sc= new Scanner(fr);
		   
		   
		   while(sc.hasNext()){
			  arr.add(sc.nextInt());
			   
		   }
		   
		   
		   int tab[]=new int[arr.size()];
			for (int i = 0; i < arr.size(); i++) {
				
				tab[i]=arr.get(i);
				
			}
		  
		   
	    int x=0;
		for (int i = 0; i < tab.length; i++) {
			if(i==0)
				x=tab[i];
			if(tab[i]>=x){
				x=tab[i];
				
			}

		}
	ArrayList<Integer> arr2=new ArrayList<Integer>();
		for (int i = 0; i < arr.size(); i++) {
			
			if(arr.get(i)==x){
				arr2.add(i);
				
			}

		}
	for (int i = 0; i < arr.size(); i++) {
			
		System.out.print(arr.get(i)+" ");
		}
	System.out.println("\n"+x);
	for (int i = 0; i < arr2.size(); i++) {
		
		System.out.print(arr2.get(i)+" ");

	}
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		System.out.println("***");
	}
    
    
    
 
  }
}
