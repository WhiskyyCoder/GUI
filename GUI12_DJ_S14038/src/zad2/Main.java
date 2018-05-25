/**
 *
 *  @author Domański Jan S14038
 *
 */

package zad2;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class Main {
	 static int licznik=0;
	
  public static void main(String[] args) {
	  
	 
		JFrame jf=new JFrame("JList");
		JPanel jp= new JPanel();

		ModelText m= new ModelText();
		
		   JList list = new JList(m);
		   list.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				   int modifiersEx = e.getModifiersEx();
				    int onmask = MouseEvent.ALT_DOWN_MASK;
				    if ((modifiersEx & onmask) == onmask) {
						m.remove(list.getSelectedIndex());
				    }
				
			
				
			}
		});
	    JScrollPane pane = new JScrollPane(list);
	 
		jf.setLayout(new BorderLayout());
		JTextField jtf= new JTextField();
		jtf.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				;
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					
					m.add(jtf.getText(),licznik);
					licznik++;
					jtf.setText(null);
				}
				
			}
		});
		
		jf.add(pane,BorderLayout.CENTER);
		jf.add(jtf,BorderLayout.PAGE_END);
		jf.pack();
	    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
  }
}
