package zad2;

class Teksty {

	  String txt = null;
	  boolean newTxt = false;

	  // Metoda ustalająca tekst - wywołuje Autor
	  synchronized void setTextToWrite(String s) {
	    while (newTxt == true) {
	      try {
	        wait();
	      } catch(InterruptedException exc) {}
	    }
	    txt = s;
	    newTxt = true;
	    notify();
	  }

	  // Metoda pobrania tekstu - wywołuje Writer
	  synchronized String getTextToWrite() {
	    while (newTxt == false) {
	      try {
	        wait();
	      } catch(InterruptedException exc) {}
	    }
	    newTxt = false;
	    notify();
	    return txt;
	  }

	}
