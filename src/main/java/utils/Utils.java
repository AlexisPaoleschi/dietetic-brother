package utils;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class Utils {

	public static double parseStringWithcomaToDouble(String value){
		double d = 0;
		try {
			String valNum = value;
			if(value.contains("<")){
				valNum = value.substring(2);
			} else if(value.equals("traces") || value.equals("-")) {
				valNum = "0.0";
			}
			
			NumberFormat format = NumberFormat.getInstance(Locale.FRANCE);
			Number number;
			number = format.parse(valNum);
			d = number.doubleValue();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return d;
	}
	
}
