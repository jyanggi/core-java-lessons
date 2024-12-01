package lessons.v8.oca.chapter5;

public interface MyInterface2 extends  MyInterface {

    int MY_INT = 3;


    static void callStatic(){
        System.out.println("Calling static");
    }

    default void callMyDefault(){
        System.out.println("callMyDefault");
    }
}
