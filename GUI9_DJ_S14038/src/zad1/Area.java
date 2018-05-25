package zad1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JTextArea;

public class Area extends JTextArea {
public Area(Color blue, Color yellow, String string,  int i) {
	this.setBackground(blue);
	Font font = new Font("Dialog",Font.BOLD|Font.ITALIC,i);
	this.setFont(font);
	this.setForeground(yellow);

	}

@Override
protected void paintComponent(Graphics g) {
	super.paintComponent(g);
}

}
