package zad2;

import java.util.HashMap;

public class PriceList {
HashMap<String,Double> mapa;
	static PriceList lista;
	public static PriceList getInstance() {
if(lista!=null){
		return lista;
}else{
	lista=new PriceList();
	return lista;
}
	}
	public void put(String name,double koszt){
	
		mapa.put(name, koszt);
		
	}
	public PriceList() {
		mapa= new HashMap<String,Double>();
	}
}
