package zad1;

public class ChoryNaDyspepsje extends Pacjent{
String imie;
	public ChoryNaDyspepsje(String imie) {
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
		return "dyspepsja";
	}

	@Override
	public String leczenie() {
		// TODO Auto-generated method stub
		return "wegiel";
	}

}
