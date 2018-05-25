package zad2;

import java.util.ArrayList;



public class ShoppingCart {

	public ArrayList<Flower> kwiatki;
	public  void add(Flower fl){
		kwiatki.add(fl);
	}
	public ArrayList<Flower> getCart(){

		
		return kwiatki;
		
	}
	public ShoppingCart() {
		kwiatki= new ArrayList<Flower>();
	}
	@Override
	public String toString() {
		String koszyk ="";
		ArrayList<Flower> arr=kwiatki;
		for (int i = 0; i < arr.size(); i++) {
			koszyk+=arr.get(i).getNazwa()+":"+arr.get(i).count+" ";
		}
		return koszyk;
	}
	
}
