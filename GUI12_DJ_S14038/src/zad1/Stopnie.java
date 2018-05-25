package zad1;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class Stopnie extends JFrame {
	public Stopnie() {
		super("JList");
		JPanel jp= new JPanel();
		JList list = new JList(new Model());
	    JScrollPane pane = new JScrollPane(list);
		
		
		add(pane);
		pack();
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

}
