package lessons.v8.oca.chapter1;

import java.util.Date;

public class ReferenceTypes {


    public static void changeDate(Date date) {
        date.setTime(date.getTime() + 86_400_000L);

    }


    public static void main(String[] args) {
        String s;
        Date today = new Date();
        System.out.println(today);
        changeDate(today);
        System.out.println(today);
        today = new Date();
        System.out.println(today);
// local instance vars need to be initialized before use        System.out.println(s);

    }
}
