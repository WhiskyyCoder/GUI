package zad2;

import java.util.ArrayList;

import javax.swing.AbstractListModel;

public class ModelText extends AbstractListModel {

	ArrayList<String> arr= new ArrayList<String>();
	
	@Override
	public Object getElementAt(int index) {
		// TODO Auto-generated method stub
		return arr.get(index);
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return arr.size();
	}
	public void add(String str,int index){
		arr.add(str);
		 this.fireContentsChanged(str, index, index);
		
	}
public void remove(int index){
	   arr.remove(index);
	   fireIntervalRemoved(this, index, index);
	}

}
