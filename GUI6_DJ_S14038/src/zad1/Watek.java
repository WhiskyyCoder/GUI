package zad1;

public class Watek extends Thread {

public Watek(Runnable r,char x ){
	
	super(r, "Thread "+x);
}



}
