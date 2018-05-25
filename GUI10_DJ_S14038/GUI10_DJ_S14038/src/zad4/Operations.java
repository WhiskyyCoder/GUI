package zad4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public abstract class Operations {

	public  static void save_as(JFrame jf,JTextArea text){
		
		JFileChooser fc = new JFileChooser();
		int val=fc.showDialog(fc,"Save As");
		if(val==JFileChooser.APPROVE_OPTION){
		if(!Main.mainpath.isEmpty()){
		fc.setCurrentDirectory(new File(Main.mainpath));
		}else{
		File workingDirectory = new File(System.getProperty("user.dir"));
		fc.setCurrentDirectory(workingDirectory);	
		}
		String path="";
		fc.setDialogTitle("Gdzie mam zapisac ???");
		try {
		path=fc.getSelectedFile().getAbsolutePath();
		
		File f= new File(path);
		FileWriter fw;
		
			
			fw = new FileWriter(f,false);
			fw.write(text.getText());
			fw.flush();
			fw.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
		}
		JOptionPane.showMessageDialog(jf, "Correctly saved");
		load(jf, text, path,fc.getSelectedFile().getName());
		}
	}
	public static  void load(JFrame jf,JTextArea text,String mainpath,String filename){
		jf.setTitle("Prosty edytor - "+filename);

		try {
			text.setText(null);
			Main.mainpath=mainpath;
			FileReader fr= new FileReader(new File(mainpath));
			BufferedReader br=new BufferedReader(fr);

			String p="";
			try {
				while((p=br.readLine())!=null){
					text.append(p+"\n");
					
				}
			br.close();
			fr.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
			//	e1.printStackTrace();
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
	}
	public static  void open(JFrame jf,JTextArea text,String mainpath){
		JFileChooser fc = new JFileChooser();
		int val=fc.showDialog(jf, "Open file");
if(val==JFileChooser.APPROVE_OPTION){
		if(!Main.mainpath.isEmpty()){
			fc.setCurrentDirectory(new File(Main.mainpath));
			}else{
			File workingDirectory = new File(System.getProperty("user.dir"));
			fc.setCurrentDirectory(workingDirectory);	
			}
		
		String path=fc.getSelectedFile().getAbsolutePath();
		Main.mainpath=path;
		String filename=fc.getSelectedFile().getName();
		jf.setTitle("Prosty edytor - "+filename);
	
		try {
			text.setText(null);
			FileReader fr= new FileReader(new File(path));
			BufferedReader br=new BufferedReader(fr);

			String p="";
			try {
				while((p=br.readLine())!=null){
					text.append(p+"\n");
					
				}
			br.close();
			fr.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (FileNotFoundException e1) {
			JOptionPane.showMessageDialog(jf, "Not found file");
		}

		}
		
		
		
	}
}
