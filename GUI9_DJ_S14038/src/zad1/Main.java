/**
 *
 *  @author Domański Jan S14038
 *
 */

package zad1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;


public class Main {

  public static void main(String[] args) {
	  JFrame jf=new JFrame("Edytor");
	  jf.getContentPane().setLayout(new BorderLayout());
	  Area ar=new Area(Color.BLUE,Color.YELLOW,"Dialog",20);
	 ar.setWrapStyleWord(true);
      JScrollPane jp=new JScrollPane(ar);
      

	jf.getContentPane().add(jp,BorderLayout.CENTER);

jp.setPreferredSize(new Dimension(800,600));

	
    jf.pack();
	 jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  jf.setVisible(true);
  }
}
