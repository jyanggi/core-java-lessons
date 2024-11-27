package lessons.v8.oca.assessment;

import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;

/**
 * what can we do to avoid compile error for Otter
 * */
public class Question8 {
    public interface Animal { public default String getName() { return null; } }
    interface Mammal { public default String getName() { return null; } }

//    abstract class Otter implements Mammal, Animal { }


/**
 *
 * Which ones will print april 1, 2015?
 * */

    public static void main(String... args){
        System.out.println(LocalDate.of(2015, Calendar.APRIL, 1));
        System.out.println(LocalDate.of(2015, Month.APRIL, 1));
        System.out.println(LocalDate.of(2015, 3, 1));
        System.out.println(LocalDate.of(2015, 4, 1));
//        System.out.println(new LocalDate(2015, 3, 1));
  //       System.out.println(new LocalDate(2015, 4, 1));
    }


}
