package lessons.v8.oca.chapter2;

public class NumericPromotion {


    public static String getType(Object obj) {
        return obj.getClass().getSimpleName();
    }

    public static void main(String[] args) {
        System.out.println(getType(12 / 2));
        System.out.println(getType(12L / 2));
        System.out.println(getType(12L / 2F));
        System.out.println(getType(12L / 2.0));
        System.out.println(getType(12L + 1));
        //Why Interger below
        // java promotes smaller types to int during mathematical operations
        System.out.println(getType(((short)12) + ((byte)1)));
        // unless explicitly adding type to the result
        short sh = 12 + ((byte)1);
        System.out.println(getType(sh));

    }
}
