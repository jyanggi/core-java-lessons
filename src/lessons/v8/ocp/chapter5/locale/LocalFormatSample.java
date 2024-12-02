package lessons.v8.ocp.chapter5.locale;

import java.text.NumberFormat;
import java.util.Locale;

import static java.lang.System.out;

public class LocalFormatSample {

    public static void main(String[] args) {
        int attendeesPerYear = 3_200_000;
        int attendeesPerMonth = attendeesPerYear / 12;
        double price = 48;
        NumberFormat us = NumberFormat.getInstance(Locale.US);
        out.println(us.format(attendeesPerMonth));
        NumberFormat g = NumberFormat.getInstance(Locale.GERMANY);
        out.println(g.format(attendeesPerMonth));
        NumberFormat ca = NumberFormat.getInstance(Locale.CANADA_FRENCH);
        out.println(ca.format(attendeesPerMonth));
        us = NumberFormat.getCurrencyInstance(Locale.US);
        out.println(us.format(price));
    }

}
