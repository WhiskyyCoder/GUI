/**
 *
 *  @author Domański Jan S14038
 *
 */

package zad1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;


public class Main {

  public static void main(String[] args) {
	  SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame jf = new JFrame("Label");

				JPanel jp = new JPanel();
				jp.setLayout(new BorderLayout());
				JLabel jl = new JLabel("Etykieta 1");
				jl.setBackground(Color.RED);
				jl.setForeground(Color.BLUE);
				jl.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 30));
				jp.add(jl, BorderLayout.PAGE_START);
				jl = new JLabel("Etykieta 2");
				jl.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 50));
				jl.setBorder(new LineBorder(Color.YELLOW, 5));
				jl.setForeground(Color.CYAN);
				jp.add(jl, BorderLayout.WEST);
				jl = new JLabel("Etykieta 3");

				jl.setFont(new Font("Arial", Font.BOLD, 80));
				jl.setForeground(Color.ORANGE);
				jl.setBorder(BorderFactory.createLineBorder(Color.green));
				jp.add(jl, BorderLayout.EAST);
				jl = new JLabel("Etykieta 4");
				jl.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 100));
				jl.setBorder(new BevelBorder(BevelBorder.RAISED));
				jl.setForeground(Color.MAGENTA);
				jp.add(jl, BorderLayout.PAGE_END);
				jl = new JLabel("Etykieta 5");
				jl.setBorder(new BevelBorder(BevelBorder.LOWERED));
				jl.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 100));
				jl.setForeground(Color.DARK_GRAY);
				jl.setToolTipText("Etykieta 5");
				jp.add(jl, BorderLayout.CENTER);

				jf.add(jp);
				jf.pack();
				jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				jf.setVisible(true);

			}
		});
  }
}
