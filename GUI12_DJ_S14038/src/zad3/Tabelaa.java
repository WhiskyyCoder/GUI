package zad3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.CellEditorListener;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class Tabelaa extends AbstractTableModel {

	static String[] col = { "Autor", "Tytul", "Cena", "Okladka" };
	static ArrayList<Ksiazka> dane = new ArrayList<Ksiazka>();
   public Tabelaa() {

		try {
			int li = 0;
			File file = new File("plik.txt");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			while (bufferedReader.readLine() != null) {
				li++;
			}
			fileReader.close();
			bufferedReader.close();
			li++;
		
			file = new File("plik.txt");
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
			String line;
			while ((line = bufferedReader.readLine()) != null) {

				String[] tab = line.split(";");

			dane.add(new Ksiazka(tab[0], tab[3], tab[1], tab[2]));
			}
			fileReader.close();
			bufferedReader.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,
				    "Blad pliku, sprawdz czy jest w folderze razem z obecnym programem !",
				    "",
				    JOptionPane.ERROR_MESSAGE);
			
		}
	

	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return col.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return dane.size();
	}

	@Override
	public boolean isCellEditable(int row, int column) {
		if (column == 2)
			return true;
		return false;
	}
	
	
	public String getColumnName(int coll) {
		return col[coll];
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		  if(arg1==0)
		    	return dane.get(arg0).author;
		  if(arg1==1)
		    	return dane.get(arg0).tytul;
		  if(arg1==3)
		    	return dane.get(arg0).obrazek;
		    	if(arg1==2)
			    	return dane.get(arg0).cena;
		  
		  return null;

	}

	@Override
	public void addTableModelListener(TableModelListener l) {
	
		
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		if(columnIndex==3)
		return dane.get(0).obrazek.getClass();
		return dane.get(0).author.getClass();
	}
	


	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		
		  if(columnIndex==2){
		     dane.get(rowIndex).cena=(String) aValue;}
		  fireTableCellUpdated(rowIndex, columnIndex);
	}

}
