package zad3;

import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Ksiazka {
ImageIcon obrazek;
String author;
String cena;
String tytul;
ArrayList<String> lista=new ArrayList<String>();

public Ksiazka(String au,String obraz,String tyt,String cen) {

author=au;
obrazek=new ImageIcon(obraz); 
System.out.println(obrazek.getIconHeight());
 tytul=tyt;
 cena=cen;
	
}

}
