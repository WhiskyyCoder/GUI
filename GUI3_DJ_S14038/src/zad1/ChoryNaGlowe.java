package zad1;

public class ChoryNaGlowe extends Pacjent {
String imie;
	public ChoryNaGlowe(String imie) {
		super(imie);
		this.imie=imie;
	}

	@Override
	public String nazwisko() {
		// TODO Auto-generated method stub
		return imie;
	
	}

	@Override
	public String choroba() {
		// TODO Auto-generated method stub
		return "glowa";
	}

	@Override
	public String leczenie() {
		// TODO Auto-generated method stub
		return "aspiryna";
	}

}
