/**
 *
 *  @author Domański Jan S14038
 *
 */

package zad2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CountWords {
	String path="";

	public CountWords(String path) {
		this.path = path;
	}
	
	
	public List<String> getResult(){
		ArrayList<String> arr= new ArrayList<String>();
		ArrayList<String> pomoc= new ArrayList<String>();
try{
		FileReader fr= new FileReader(this.path);
		BufferedReader br = new BufferedReader(fr);
		Pattern p ;
		Matcher m;
		String line="";
		Scanner s;
	while((line=br.readLine())!=null){
		s= new Scanner(line);
		s.useDelimiter("[\\.\\!\\?\\,\\-\\:\\;\\s]{1,}");
	while(s.hasNext()){
			String czytane=s.next();
				if(czytane.length()>1){
					String pp=czytane.trim().replace("(\\s+)|(\\n)", "");
				pomoc.add(pp);

			}
				
			}

HashMap<String,Integer> mapa= new HashMap<String,Integer>();
	
ArrayList<String> pomoc2= new ArrayList<>();

for (int i = 0; i < pomoc.size(); i++) {
	if(!(mapa.containsKey(pomoc.get(i)))){
		
		mapa.put(pomoc.get(i), 1);
		pomoc2.add(pomoc.get(i));
	}else{
		Integer r=mapa.get(pomoc.get(i));
		//mapa.remove(pomoc.get(i));
		r++;
		mapa.put(pomoc.get(i), r);
		
		
	}
}

//for (String entry : mapa.keySet()) {
//    String klucz = entry;
//    Integer wartosc = mapa.get(entry);
//}


for (int i = 0; i < pomoc2.size(); i++) {
	  arr.add(pomoc2.get(i)+" "+mapa.get(pomoc2.get(i)));
}
  
  



	}
		
		
}catch(Exception file){
System.out.println(file.getMessage());	
	
	
}	
		
		
		
		return arr;
		
	}
	
	
}  
