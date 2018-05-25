/**
 *
 *  @author Domański Jan S14038
 *
 */

package zad2;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calc {

HashMap<String,Operacje> funkcje = new HashMap<>();
	
public void funkcjeInit(BigDecimal p,BigDecimal q){
	
	
	funkcje.put("+",new Dodawanie(p,q));
	funkcje.put("-",new Odejmowanie(p,q));
	funkcje.put("/",new Dzielenie(p,q));
	funkcje.put("*",new Mnozenie(p,q));
	
	
}


public String doCalc(String string) {
	String calc="";	
	try{

	
		String[] tekst=string.split("\\s+");
		String op = null;
		 BigDecimal v1 = null;
		 BigDecimal v2 = null;
		
			 
		 v1=new BigDecimal(tekst[0].trim());
			 op=tekst[1].trim();
			 v2=new BigDecimal(tekst[2].trim());
		
		 
		 funkcjeInit(v1,v2);
		calc=funkcje.get(op).wynik();
	
	}catch(Exception ex){
			System.out.println("Invalid command to calc");
	}
		
		
		return calc;
		
		
}
	
}  
