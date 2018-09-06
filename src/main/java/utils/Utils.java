package utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class Utils {

    public static double parseStringWithComaToDouble(String value) {
        double d = 0;
        try {
            String valNum = value;
            if (value.contains("<")) {
                valNum = value.substring(2);
            } else if (value.equals("traces") || value.equals("-")) {
                valNum = "0.0";
            }

            NumberFormat format = NumberFormat.getInstance(Locale.FRANCE);
            Number number;
            number = format.parse(valNum);
            d = number.doubleValue();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return d;
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

}
