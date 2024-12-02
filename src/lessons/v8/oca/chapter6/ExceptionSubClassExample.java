package lessons.v8.oca.chapter6;

import static java.lang.System.out;

public class ExceptionSubClassExample {

    public static void main(String[] args) {

        try {
            throw new SubClassUncheckedException();
        } catch (SubClassUncheckedException e) {
            e.printStackTrace();
            out.println(e.getMessage());
        }

        try {
            throw new SubClassUncheckedException(new RuntimeException("TEST"));
        } catch (SubClassUncheckedException e) {
            e.printStackTrace();
        }

        try {
            throw new SubClassUncheckedException("Message");
        } catch (SubClassUncheckedException e) {
            e.printStackTrace();
        }

    }
}