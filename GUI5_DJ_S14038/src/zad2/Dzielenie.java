package zad2;

import java.math.BigDecimal;
import java.math.MathContext;


public class Dzielenie extends Operacje {

	public Dzielenie(BigDecimal val,BigDecimal val2) {
    super(val,val2);

	}
@Override
	public String wynik() {
		MathContext mc = new MathContext(7);
		 BigDecimal bg3;
		 bg3=p.divide(q,mc);
		return bg3.toString();
	}

}
