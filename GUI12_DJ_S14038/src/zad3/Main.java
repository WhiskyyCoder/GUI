/**
 *
 *  @author Domański Jan S14038
 *
 */

package zad3;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;


public class Main {

  public static void main(String[] args) {
	  SwingUtilities.invokeLater(new Runnable() {
          @Override
          public void run() {
	  JFrame jf=new JFrame("Tabele");
	  jf.setLayout(new BorderLayout());
	  
	  Tabelaa tm=new Tabelaa();
	 JTable tabela=new JTable(tm);

	 //tabela.getColumnModel().getColumn(3).setCellRenderer(new Image());
tabela.setRowHeight(600);
	 JScrollPane scrollPane = new JScrollPane(tabela);
	 JPanel header = new JPanel();
	 header.setLayout(new FlowLayout());
	 JButton add=new JButton("Dodaj");
	 add.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String nowe = (String)JOptionPane.showInputDialog(
                    jf,
                    "Podaj dane po kolei odzielajac ; \n"
                    + "Autor;Tytul;Cena;Nazwa_Pliku_okladki",
                    "",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    null,
                    "Autor;Tytul;Cena;Nazwa_Pliku_okladki");
			
			if(nowe.contains(";")&&!nowe.isEmpty()){
				
				String tab[]=nowe.split(";");
				
				tm.dane.add(new Ksiazka(tab[0],tab[3],tab[1],tab[2]));
				tm.fireTableDataChanged();
				jf.repaint();
				
				
			}else{
				JOptionPane.showMessageDialog(jf,
					    "Bledne wprowadzone dane, np \n Tolkien;Hobbit;23,45;tolkien.jpg",
					    "",
					    JOptionPane.ERROR_MESSAGE);
				
				
			}
			
		}});
	 JButton del=new JButton("Usun");
	 del.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			try{
			tm.dane.remove(tabela.getSelectedRow());
			tm.fireTableDataChanged();
			jf.repaint();
			}catch(ArrayIndexOutOfBoundsException ar){
				
				JOptionPane.showMessageDialog(jf,
					    "Nie zaznaczyles wiersza !",
					    "",
					    JOptionPane.ERROR_MESSAGE);
				
			}
		}
	});
	 header.add(add);
	 header.add(del);
	 
	 jf.add(header,BorderLayout.PAGE_START);
	 jf.add(scrollPane,BorderLayout.CENTER);

		jf.pack();
		
	    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 jf.setVisible(true);
          }
          });
  }
}
