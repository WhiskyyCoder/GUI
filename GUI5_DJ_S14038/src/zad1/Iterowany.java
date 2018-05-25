package zad1;

import java.util.Iterator;
import java.util.LinkedList;

public class Iterowany implements Iterator<Integer>{


public static LinkedList<Integer> list;

public Iterowany() {
	list=new LinkedList<Integer>();
}

public void dodaj(int i){
	list.add(i);
	
}
public Iterator<Integer> getIt(){
	
	return list.iterator();
}
@Override
public boolean hasNext() {
	
	return list.iterator().hasNext();
}

@Override
public Integer next() {
	// TODO Auto-generated method stub

	return (Integer) list.iterator().next();
}
}