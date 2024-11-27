package lessons.v8.oca.chapter2;

public class CompoundOperators {


    public static void main(String [] args){
        long x = 10;
        int y = 5;
        // DOES NOT COMPILE      y = y * x;
        //Compiles, java handles casting
        y*=x;

        System.out.println(y);
        y+=(x=3);
        System.out.println(y);
        System.out.println(x);
    }
}
