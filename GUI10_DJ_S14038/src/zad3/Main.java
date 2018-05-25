/**
 *
 *  @author Domański Jan S14038
 *
 */

package zad2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Main {

  public static void main(String[] args) {

JFrame okno=new JFrame();

JButton p1=new JButton("Przycisk 1");
JButton p2=new JButton("P 2");
JButton p3=new JButton("Wiekszy przycisk numer 3");
JButton p4=new JButton("Przycisk 4");
JButton p5=new JButton("P 5");
JPanel jp=new JPanel();

String s = (String)JOptionPane.showInputDialog( "Podaj litery od A do G" );


switch(s){
case "A":
	jp.setLayout(new BorderLayout());
	jp.add(p1);
	jp.add(p2);
	jp.add(p3);
	jp.add(p4);
	jp.add(p5);
	break;
case "B":
jp.setLayout(new FlowLayout());
	jp.add(p1);
	jp.add(p2);
	jp.add(p3);
	jp.add(p4);
	jp.add(p5);
	break;
case "C":
	jp.setLayout(new FlowLayout());
	jp.add(p1,FlowLayout.LEFT);
	jp.add(p2,FlowLayout.LEFT);
	jp.add(p3,FlowLayout.LEFT);
	jp.add(p4,FlowLayout.LEFT);
	jp.add(p5,FlowLayout.LEFT);
	break;
case "D":
	jp.setLayout(new FlowLayout(FlowLayout.RIGHT));
	jp.add(p1);
	jp.add(p2);
	jp.add(p3);
	jp.add(p4);
	jp.add(p5);
	break;
case "E":
	jp.setLayout(new GridLayout(1,0));
	
	jp.add(p1);
	jp.add(p2);
	jp.add(p3);
	jp.add(p4);
	jp.add(p5);
	break;
case "F":
	jp.setLayout(new GridLayout(0,1));
	jp.add(p1);
	jp.add(p2);
	jp.add(p3);
	jp.add(p4);
	jp.add(p5);
	break;
case "G":
	jp.setLayout(new GridLayout(3,2));
	jp.add(p1);
	jp.add(p2);
	jp.add(p3);
	jp.add(p4);
	jp.add(p5);
	break;
default:
		
	jp.setLayout(new FlowLayout());
	jp.add(p1);
	jp.add(p2);
	jp.add(p3);
	jp.add(p4);
	jp.add(p5);	
		break;



}
okno.add(jp);
okno.pack();
okno.setVisible(true);
  }
}
