package zad2;

import java.util.ArrayList;

public class Box {
ArrayList<Flower> zawartosc=new ArrayList<Flower>();
Customer wlasciciel=null;
	public Box(Customer cust) {
wlasciciel=cust;
		
		
		
	}
	@Override
	public String toString() {
		String koszyk ="";
		ArrayList<Flower> arr=zawartosc;
		for (int i = 0; i < arr.size(); i++) {
			koszyk+=arr.get(i).getNazwa()+":"+arr.get(i).count+" ";
		}
		return koszyk;
	}

}
