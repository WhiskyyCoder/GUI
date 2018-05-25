/**
 *
 *  @author Domański Jan S14038
 *
 */

package zad3;

import static java.awt.Color.BLACK;
import static java.awt.Color.BLUE;
import static java.awt.Color.GREEN;
import static java.awt.Color.ORANGE;
import static java.awt.Color.RED;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;


public class Main {
	static int licz = 0;
  public static void main(String[] args) {
	  SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ArrayList<Color> ar = new ArrayList<>();
				ar.add(RED);
				ar.add(BLUE);
				ar.add(GREEN);
				ar.add(BLACK);
				JFrame jf = new JFrame("Przycisk");
				jf.setLayout(new BorderLayout());
				JPanel jp = new JPanel();
				jp.setLayout(new BorderLayout());
				JButton b = new JButton("Zmien tlo");
				b.setFont(new Font("Arial", Font.BOLD, 20));
				b.setBackground(ar.get(0));
				b.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {

						if (licz < ar.size()) {
							licz++;
							if (licz < ar.size()) {
								b.setBackground(ar.get(licz));
							} else {
								licz = 0;
								b.setBackground(ar.get(0));
							}

						} else {
							licz = 0;
							b.setBackground(ar.get(0));
						}
					}
				});
				b.setBorder(new LineBorder(ORANGE, 5));
				jp.add(b, BorderLayout.CENTER);
				jp.setPreferredSize(new Dimension(200, 100));
				jf.add(jp);
				jf.add(jp, BorderLayout.CENTER);
				jf.setPreferredSize(new Dimension(800, 600));

				jf.pack();
				jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				jf.setVisible(true);
			}
		});
  }
}
