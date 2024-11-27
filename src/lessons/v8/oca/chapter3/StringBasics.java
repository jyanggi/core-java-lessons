package lessons.v8.oca.chapter3;

import java.util.Locale;

public class StringBasics {

    public static void main(String [] args){
        String s1 = "John";
        String s2 = new String("John");
        String s3 = "John";
        System.out.println(s1==s2);
        System.out.println(s1==s3);
        System.out.println(s1.equals(s2));
        System.out.println("Hello"=="Hello");
        System.out.println("Hello".length());
        System.out.println("Hello".substring(3));
        System.out.println("Hello".substring(2,5));
        System.out.println("Hello".concat(" World"));
        System.out.println("Hello".indexOf('e'));
        System.out.println("Hello".charAt(2));
        System.out.println("Hello".toLowerCase());
        System.out.println("Hello".toUpperCase(Locale.ROOT));
        System.out.println("Hello".codePointAt(1));
        System.out.println((char)101);

    }
}
