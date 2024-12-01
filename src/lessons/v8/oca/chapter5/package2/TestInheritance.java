package lessons.v8.oca.chapter5.package2;

import lessons.v8.oca.chapter5.MyInterface;
import lessons.v8.oca.chapter5.MyInterface2;
import lessons.v8.oca.chapter5.package1.Parent;

public class TestInheritance {


    public static void main(String [] args) {
        Parent p = new Parent();
        p.print();
        Child child1 = new Child();
        child1.print();
        Parent child2 = new Child("A", "B", "C");
        child2.print();
        child1.print2();
        try {
            p.callThrow();
        } catch (Throwable e) {
            System.out.println(e);
        }
        System.out.println(child1.callThrow());

        MyInterface inter1 = p;

        inter1.callMyMethod();

        MyInterface inter2 = child2;
        inter2.callMyMethod();

        MyInterface2 inter3 = child1;
        inter3.callMyDefault();
        inter3.callMyMethod();
        System.out.println(inter1.MY_INT);
        System.out.println(MyInterface2.MY_INT);
        System.out.println(p.MY_INT);
        MyInterface2.callStatic();
    }
}
