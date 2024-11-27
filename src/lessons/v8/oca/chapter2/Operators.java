package lessons.v8.oca.chapter2;

public class Operators {

    public static void main(String [] args){
        int i = 0;

        System.out.println(String.format("%d+=2 is %d",i, (i+=2)));
        System.out.println(String.format("%d/=2 is %d",i, (i/=2)));
        System.out.println(String.format("%d*=3 is %d",i, (i*=3)));

        System.out.println(String.format("%d<<=2 is %d",i, (i<<=2)));

        System.out.println(String.format("%s<<=2 is %s",Integer.toBinaryString(3), Integer.toBinaryString(3<<2)));

        System.out.println(String.format("%d>>=1 is %d",i, (i>>=1)));
        System.out.println(String.format("%s>>=1 is %s",Integer.toBinaryString(12), Integer.toBinaryString(12>>1)));

        System.out.println(String.format("%d*-1>>>1 is %d",i, (i*-1>>>1)));
        System.out.println(String.format("%s*-1>>>1 is %s",Integer.toBinaryString(-6), Integer.toBinaryString(-6>>>1)));

        System.out.println(String.format("~%d* is %d",i, ~i));
        System.out.println(String.format("%d%%=3 is %d",i, i%=3));
        i = 3;
        System.out.println(String.format("%d&1 is %d",i, i&1));
        System.out.println(String.format("%d|1 is %d",i, i|1));
        System.out.println(String.format("%d^1 is %d",i, i^ 1));


        int x = 3;
        int y = ++x * 5 / x-- + --x;
        System.out.println("x is " + x);
        System.out.println("y is " + y);


    }
}
