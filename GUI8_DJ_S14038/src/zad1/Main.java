/**
 *
 *  @author Domański Jan S14038
 *
 */

package zad1;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;


public class Main {

  public static void main(String[] args) {
	  JFrame j=new JFrame(); 
	JPanel jp=new Okno(j);
	
	
	j.add(jp);
	j.pack();
	
	j.setVisible(true);
  }
}
