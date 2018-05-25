/**
 *
 *  @author Domański Jan S14038
 *
 */

package zad4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.geom.Ellipse2D;
import java.beans.PropertyChangeListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu.Separator;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

import sun.awt.IconInfo;

public class Main {
	static String mainpath = "";
	static int licz = 10;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame jf = new JFrame("Prosty Edytor - bez tytulu ");
				jf.getContentPane().setLayout(new BorderLayout());
				JTextArea text = new JTextArea(40, 60);
				text.setWrapStyleWord(true);
				JScrollPane jp = new JScrollPane(text);

				jf.add(jp, BorderLayout.CENTER);

				JMenuBar mb = new JMenuBar();

				// File
				JMenu file = new JMenu("File");
				file.setMnemonic(KeyEvent.VK_F);
				// /////////////////////Open
				JMenuItem open = new JMenuItem("Open");
				open.setMnemonic(KeyEvent.VK_O);
				open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,
						ActionEvent.CTRL_MASK));
				open.addActionListener((a) -> Operations.open(jf, text,
						mainpath));
				file.add(open);
				file.addSeparator();
				// //////////////////////////
				// /////////////////////////Save
				JMenuItem save = new JMenuItem("Save");
				save.setMnemonic(KeyEvent.VK_S);
				save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
						ActionEvent.CTRL_MASK));
				save.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						if (!mainpath.isEmpty()) {
							File f = new File(mainpath);
							try {
								FileWriter fw = new FileWriter(f, false);
								fw.write(text.getText());
								fw.flush();
								fw.close();

							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							JOptionPane.showMessageDialog(jf, "Saved");
						} else {
							Operations.save_as(jf, text);

						}

					}

				});
				file.add(save);
				file.addSeparator();
				// //////////////////////////
				// //////////////////////////Save as
				JMenuItem saveas = new JMenuItem("Save As");
				saveas.setMnemonic(KeyEvent.VK_A);
				saveas.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,
						ActionEvent.CTRL_MASK));
				saveas.addActionListener(e -> Operations.save_as(jf, text));
				file.add(saveas);
				file.addSeparator();
				// //////////////////////////
				// //////////////////////////Exit
				JSeparator js = new JSeparator();
				js.setSize(100, 100);
				js.setForeground(Color.RED);
				// js.setBorder(new LineBorder(Color.RED,2));
				JMenuItem sep = new JMenuItem();
				sep.add(js);
				file.add(sep);
				file.addSeparator();
				JMenuItem exit = new JMenuItem("Exit");
				exit.setMnemonic(KeyEvent.VK_X);
				exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,
						ActionEvent.CTRL_MASK));
				exit.addActionListener((a) -> System.exit(0));
				file.add(exit);

				// Edit
				JMenu edit = new JMenu("Edit");
				edit.setMnemonic(KeyEvent.VK_E);
				JMenu adres = new JMenu("Adresy");
				adres.setMnemonic(KeyEvent.VK_A);

				edit.add(adres);
				JMenuItem dom = new JMenuItem("Dom");
				dom.setMnemonic(KeyEvent.VK_D);
				dom.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,
						ActionEvent.CTRL_MASK | ActionEvent.SHIFT_MASK));
				dom.addActionListener(ee -> text.insert(
						"Jan Kowalski,ulica Konopnickiej 12 ,33-221 Krakow",
						text.getCaretPosition()));
				adres.add(dom);
				adres.addSeparator();
				JMenuItem szkola = new JMenuItem("Szkola");
				szkola.setMnemonic(KeyEvent.VK_S);
				szkola.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
						ActionEvent.CTRL_MASK | ActionEvent.SHIFT_MASK));
				szkola.addActionListener(p -> text
						.insert("Szkola Podstawowa nr 2 w Warszawie,ulica Konopnickiej 12 ,00-221 Warszawa",
								text.getCaretPosition()));
				adres.add(szkola);
				adres.addSeparator();
				JMenuItem firma = new JMenuItem("Firma");
				firma.setMnemonic(KeyEvent.VK_F);
				firma.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F,
						ActionEvent.CTRL_MASK | ActionEvent.SHIFT_MASK));
				firma.addActionListener(p -> text
						.insert("ForceSystems Sp.z.o.o ,ulica Batorego 12 ,00-221 Warszawa",
								text.getCaretPosition()));
				adres.add(firma);
				// Options
				JMenu opt = new JMenu("Options");
				opt.setMnemonic(KeyEvent.VK_O);
				JMenu fore = new JMenu("Foreground");
				fore.setMnemonic(KeyEvent.VK_F);
				JMenu back = new JMenu("Background");
				back.setMnemonic(KeyEvent.VK_B);
				JMenu font = new JMenu("Font size");
				back.setMnemonic(KeyEvent.VK_S);

				// Foreground list
				JMenuItem color;
				color = new JMenuItem("      RED");
				color.setIcon(new ColorIcon(Color.RED, 12));
				color.setMnemonic(KeyEvent.VK_R);
				color.addActionListener(e -> text.setForeground(Color.red));
				fore.add(color);
				color = new JMenuItem("      YELLOW");
				color.setIcon(new ColorIcon(Color.YELLOW, 12));
				color.setMnemonic(KeyEvent.VK_Y);
				color.addActionListener(e -> text.setForeground(Color.yellow));
				fore.add(color);
				color = new JMenuItem("      GREEN");
				color.setIcon(new ColorIcon(Color.GREEN, 12));
				color.setMnemonic(KeyEvent.VK_G);
				color.addActionListener(e -> text.setForeground(Color.green));
				fore.add(color);
				color = new JMenuItem("      BLUE");
				color.setIcon(new ColorIcon(Color.BLUE, 12));
				color.setMnemonic(KeyEvent.VK_B);
				color.addActionListener(e -> text.setForeground(Color.blue));
				fore.add(color);
				color = new JMenuItem("      ORANGE");
				color.setIcon(new ColorIcon(Color.ORANGE, 12));
				color.setMnemonic(KeyEvent.VK_B);
				color.addActionListener(e -> text.setForeground(Color.orange));
				fore.add(color);
				color = new JMenuItem("      BLACK");
				color.setIcon(new ColorIcon(Color.BLACK, 12));
				color.setMnemonic(KeyEvent.VK_B);
				color.addActionListener(e -> text.setForeground(Color.BLACK));
				fore.add(color);
				// Background list
				color = new JMenuItem("      RED");
				color.setIcon(new ColorIcon(Color.RED, 12));
				color.setMnemonic(KeyEvent.VK_R);
				color.addActionListener(e -> text.setBackground(Color.red));
				back.add(color);
				color = new JMenuItem("      YELLOW");
				color.setIcon(new ColorIcon(Color.YELLOW, 12));
				color.setMnemonic(KeyEvent.VK_Y);
				color.addActionListener(e -> text.setBackground(Color.yellow));
				back.add(color);
				color = new JMenuItem("      GREEN");
				color.setIcon(new ColorIcon(Color.GREEN, 12));
				color.setMnemonic(KeyEvent.VK_G);
				color.addActionListener(e -> text.setBackground(Color.GREEN));
				back.add(color);
				color = new JMenuItem("      BLUE");
				color.setIcon(new ColorIcon(Color.BLUE, 12));
				color.setMnemonic(KeyEvent.VK_B);
				color.addActionListener(e -> text.setBackground(Color.blue));
				back.add(color);
				color = new JMenuItem("      ORANGE");
				color.setIcon(new ColorIcon(Color.ORANGE, 12));
				color.setMnemonic(KeyEvent.VK_B);
				color.addActionListener(e -> text.setBackground(Color.ORANGE));
				back.add(color);
				color = new JMenuItem("      BLACK");
				color.setIcon(new ColorIcon(Color.BLACK, 12));
				color.setMnemonic(KeyEvent.VK_B);
				color.addActionListener(e -> text.setBackground(Color.BLACK));
				back.add(color);
				// Font list
				JMenuItem fontl = new JMenuItem("8 pts");
				fontl.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						text.setFont(new Font("Arial", Font.PLAIN, 8));
					}

				});

				font.add(fontl);
				for (int x = licz; x <= 24; x = x + 2) {

					fontl = new JMenuItem(x + " pts");
					fontl.addActionListener(e -> text.setFont(new Font("Arial",
							Font.PLAIN, licz)));

					font.add(fontl);
					licz += 2;
				}

				opt.add(back);
				opt.add(fore);
				opt.add(font);
				mb.add(file);
				mb.add(edit);
				mb.add(opt);
				jf.add(mb, BorderLayout.PAGE_START);
				jf.pack();
				jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				jf.setVisible(true);
			}
		});
	}
}
