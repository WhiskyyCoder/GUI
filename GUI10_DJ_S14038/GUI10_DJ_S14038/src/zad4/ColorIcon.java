package zad4;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.Icon;

public class ColorIcon implements Icon{

	Color cl;
	int size=0;
	public ColorIcon(Color color,int s) {
		// TODO Auto-generated constructor stub
		cl=color;
		size=s;
	
	}
	@Override
	public int getIconHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getIconWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void paintIcon(Component arg0, Graphics arg1, int arg2, int arg3) {
		arg1.setColor(cl);
		arg1.fillOval(5, 3, size, size);	
		
	}

	
	
}
