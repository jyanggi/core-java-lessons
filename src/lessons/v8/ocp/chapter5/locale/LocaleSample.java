package lessons.v8.ocp.chapter5.locale;

import static java.lang.System.out;

import java.util.Locale;
import java.util.ResourceBundle;

public class LocaleSample {

    public static void main(String[] args) {
        out.println(Locale.getDefault());
        out.println(Locale.GERMANY);
        out.println(new Locale("en", "PH"));
        ResourceBundle rb = ResourceBundle.getBundle("Greet");
        out.println(rb.getString("greet"));
        Locale localeFR = new Locale.Builder().setLanguage("fr").setRegion("FR")
                .build();
        Locale.setDefault(localeFR);
        out.println(Locale.getDefault());

        rb = ResourceBundle.getBundle("Greet", Locale.FRENCH);
        out.println(rb.getString("greet"));
        rb = ResourceBundle.getBundle("Greet", Locale.US);
        out.println(rb.getString("greet"));

    }

}
