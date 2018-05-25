package zad2;

import java.math.BigDecimal;
import java.math.MathContext;


public class Mnozenie extends Operacje {

	public Mnozenie(BigDecimal val,BigDecimal val2) {
    super(val,val2);

	}
@Override
	public String wynik() {
	
		 BigDecimal bg3;
		 bg3=p.multiply(q);
		return bg3.toString();
	}

}
