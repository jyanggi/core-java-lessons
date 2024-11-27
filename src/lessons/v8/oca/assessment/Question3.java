package lessons.v8.oca.assessment;

import static java.lang.System.out;
public class Question3 {

    /**
     * What is the output
     *
     * */
    static interface HasTail { int getTailLength(); }



    public static void main(String[] args) {
       Puma p = new Cougar();
        out.println(p.getTailLength());
    }

    static class Cougar extends Puma{
        public int getTailLength() {return 2;}

    }
    static abstract class Puma implements HasTail {
        public int getTailLength() {return 4;}
    }

}
