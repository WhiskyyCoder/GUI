package zad2;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Obrazki extends JPanel {
	int font;
	String directory;
	int time;
	JFrame g = null;
	static int licz = 0;
	ArrayList<Image> img = new ArrayList<>();

	public Obrazki(String directory, int timeoutInSecond, int font) {
		this.font = font;
		this.directory = directory;
		this.time = timeoutInSecond;
try{
		File folder = new File(directory);
		File[] pliki = folder.listFiles();

		for (int i = 0; i < pliki.length; i++) {

			if (pliki[i].getName().matches(".+\\.(jpe?g|png|gif)")) {

				img.add(new ImageIcon(directory + pliki[i].getName())
						.getImage());
			}

		}
		if (img.size() != 0) {
			setPreferredSize(new Dimension(this.img.get(0).getWidth(null),
					this.img.get(0).getHeight(null)));
		} else {
			setPreferredSize(new Dimension(800, 600));
		}
}catch(Exception ex){
	setPreferredSize(new Dimension(800, 600));
}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (licz < img.size()) {
			try {
				g.drawImage(this.img.get(licz), 0, 0, null);
			} catch (Exception ex) {
				setPreferredSize(new Dimension(800, 600));
				Font myFont = new Font("Courier New", 1, font);

				g.setFont(myFont);

				FontMetrics fm = g.getFontMetrics();
				int x = (800 - fm.stringWidth("Brak obrazka")) / 2;
				int y = (600 - (fm.getAscent() + fm.getDescent())) / 2;

				g.drawString("Brak obrazka", x, y);
			}

		} else {
			if (img.size() != 0) {
				Font myFont = new Font("Courier New", 1, font);

				g.setFont(myFont);

				FontMetrics fm = g.getFontMetrics();
				int x = (800 - fm.stringWidth("Koniec prezentacji")) / 2;
				int y = (600 - (fm.getAscent() + fm.getDescent())) / 2;

				g.drawString("Koniec prezentacji", x, y);
			} else {
				Font myFont = new Font("Courier New", 1, font);

				g.setFont(myFont);

				FontMetrics fm = g.getFontMetrics();
				int x = (800 - fm.stringWidth("Brak obrazka")) / 2;
				int y = (600 - (fm.getAscent() + fm.getDescent())) / 2;

				g.drawString("Brak obrazka", x, y);
			}
		}

	}

	void set(JFrame jf) {
		g = jf;

	}

	void startuj() {
		for (int i = 0; i < img.size(); i++) {

			try {
				Thread.sleep(time * 1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			licz++;
			if (i + 1 < img.size()) {
				setPreferredSize(new Dimension(this.img.get(i + 1).getWidth(
						null), this.img.get(i + 1).getHeight(null)));
				g.pack();
				repaint();
			} else {
				setPreferredSize(new Dimension(800, 600));
				g.pack();
				repaint();
			}
		}

	}

}
