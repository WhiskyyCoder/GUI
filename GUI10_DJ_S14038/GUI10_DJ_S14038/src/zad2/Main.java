/**
 *
 *  @author Domański Jan S14038
 *
 */

package zad2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;


public class Main {

  public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
JFrame okno=new JFrame();
okno.setLayout(new BorderLayout());
JPanel jp=new JPanel();
jp.setLayout(new BorderLayout());
JButton p1=new JButton("A1");
JPanel min=new JPanel();
min.setLayout(new FlowLayout());
min.add(p1);
JButton p2=new JButton("A2");
min.add(p2);
JButton p3=new JButton("A3");
min.add(p3);
jp.add(min,BorderLayout.WEST);
JTextArea jt=new JTextArea(20,60);
JScrollPane jsp=new JScrollPane(jt);

okno.add(jsp,BorderLayout.CENTER);
JPanel max=new JPanel();
JButton p4=new JButton("B1");
jp.add(p4);
max.add(p4);
JButton p5=new JButton("B2");
max.add(p5);
JButton p6=new JButton("B3");
max.add(p6);
jp.add(max,BorderLayout.EAST);
okno.add(jp,BorderLayout.NORTH);
JPanel bottom=new JPanel();
bottom.setLayout(new BorderLayout());
JPanel gridjp  =new JPanel();
gridjp.setLayout(new GridLayout(3,3));
gridjp.add(new JButton("1"));
gridjp.add(new JButton("2"));
gridjp.add(new JButton("3"));
gridjp.add(new JButton("4"));
gridjp.add(new JButton("5"));
gridjp.add(new JButton("6"));
gridjp.add(new JButton("7"));
gridjp.add(new JButton("8"));
gridjp.add(new JButton("9"));
bottom.add(gridjp,BorderLayout.WEST);
JPanel texts  =new JPanel();
texts.setLayout(new GridLayout(3,1,5,8));
JTextField jtf =new JTextField("To jest JTextField      ");
LineBorder lb=new LineBorder(Color.ORANGE,2);

jtf.setBorder(lb);
texts.add(jtf);
jtf =new JTextField("To jest JTextField       ");

jtf.setBorder(lb);
texts.add(jtf);
jtf =new JTextField("To jest JTextField     ");

jtf.setBorder(lb);
texts.add(jtf);
texts.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 40));

bottom.add(texts,BorderLayout.EAST);
okno.add(bottom,BorderLayout.SOUTH);
okno.pack();
okno.setVisible(true);
			}});
  }
}
