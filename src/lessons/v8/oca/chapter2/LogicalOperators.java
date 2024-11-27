package lessons.v8.oca.chapter2;

public class LogicalOperators {


    public static void main(String [] args){
        int x = 6;
        boolean y = (x >= 6) || (++x <= 7);
        System.out.println(x);
        y = (x >= 6) && (++x <= 7);
        System.out.println(x);

        boolean a = false;
        boolean b = (a = true);
        System.out.println(b);

    }
}
