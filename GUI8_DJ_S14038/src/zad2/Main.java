/**
 *
 *  @author Domański Jan S14038
 *
 */

package zad2;

import java.awt.Font;

import javax.swing.JFrame;


public class Main {

  public static void main(String[] args) {
	  JFrame j=new JFrame("Obrazki");  
	  Obrazki r=new Obrazki("",5,50);
	j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	j.add(r);
	j.pack();
    j.setVisible(true);
    r.set(j);
    r.startuj();
  
   
	  
  }
}
