package zad1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Okno extends JPanel {
	
	JFrame w=null;
	public Okno(JFrame jf) {
		w=jf;
		setPreferredSize(new Dimension(800,600));
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	
		
		g.setColor(Color.BLUE);
		
		g.drawLine(0, 0, this.getWidth(),this.getHeight());
	

	}
	


}