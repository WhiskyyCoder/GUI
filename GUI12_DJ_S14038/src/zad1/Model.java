package zad1;


import javax.swing.AbstractListModel;


public class Model extends AbstractListModel {
	public Model() {
	

	}

	@Override
	public Object getElementAt(int k) {
	
		
		return (k+-70)+" stopni C = "+(((k+-70)*9/5)+32)+" stopni F ";
	}

	@Override
	public int getSize() {
		
		return 131;
	}


}
