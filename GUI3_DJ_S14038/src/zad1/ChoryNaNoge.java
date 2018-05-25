package zad1;

public class ChoryNaNoge extends Pacjent{
String imie;
	public ChoryNaNoge(String imie) {
		super(imie);
		this.imie=imie;
		// TODO Auto-generated constructor stub
	}
	@Override
	public String nazwisko() {
		// TODO Auto-generated method stub
		return imie;
	}
	@Override
	public String choroba() {
		// TODO Auto-generated method stub
		return "noga";
	}
	@Override
	public String leczenie() {
		// TODO Auto-generated method stub
		return "gips";
	}
	

}
