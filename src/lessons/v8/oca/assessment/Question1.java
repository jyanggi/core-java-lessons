package lessons.v8.oca.assessment;

import static java.lang.System.out;

public class Question1 {
    /**
     * What is the result of the following class?
     * */

    private static int $;
    public static void main(String[] args) {
        String a_b;
        out.print($);
        //Compile error as local variable has not been initialized
// Uncomment to show error  out.print(a_b);
    }
}
