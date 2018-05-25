package zad2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.sun.javafx.scene.control.skin.VirtualFlow.ArrayLinkedList;

public class Customer {
private double konto;
String imie;
Box pudelko=null;
ShoppingCart koszyk;
ArrayList<Flower> przedmioty=null;

Customer(String imie,int konto){
	
	this.imie=imie;
	this.konto=konto;
	
}
public void get(Flower fl){

	if(koszyk!=null){
		koszyk.add(fl);
	}else{
		
		koszyk=new ShoppingCart();
		koszyk.add(fl);
	}
}
public ShoppingCart getShoppingCart(){
	return koszyk;
}

public void flowerExist(){
	przedmioty=koszyk.getCart();

	HashMap<String,Double> cennik=PriceList.getInstance().mapa;
	
	for (int i = 0; i < przedmioty.size(); i++) {
		if(!cennik.containsKey(przedmioty.get(i).getNazwa())){
			przedmioty.remove(przedmioty.get(i));
		}else{
			if(cennik.get(przedmioty.get(i).getNazwa())==0){
				przedmioty.remove(przedmioty.get(i));
				
			}
			
			
		}
	}

}
public void pay(){
	HashMap<String,Double> cennik=PriceList.getInstance().mapa;
	flowerExist();
double total=0;
double total2=0;
for (int i = 0; i < przedmioty.size(); i++) {
	

	if(!(total+przedmioty.get(i).count*cennik.get(przedmioty.get(i).getNazwa())<=konto)){

	
		przedmioty.remove(i);
		
	}else{
		total=total+przedmioty.get(i).count*cennik.get(przedmioty.get(i).getNazwa());
	}
	}
for (int i = 0; i < przedmioty.size(); i++) {
	total2=total2+przedmioty.get(i).count*cennik.get(przedmioty.get(i).getNazwa());


	}
konto=konto-total2;
	
	
	
}
public double getCash() {
	// TODO Auto-generated method stub
	return konto;
}
public void pack(Box pudelko) {
pudelko.zawartosc=przedmioty;
}
}
