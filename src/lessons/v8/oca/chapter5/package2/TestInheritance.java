package lessons.v8.oca.chapter5.package2;

import lessons.v8.oca.chapter5.package1.Parent;

public class TestInheritance {


    public static void main(String [] args){
        Parent p = new Parent();
        p.print();
        Child child1 = new Child();
        child1.print();
        Parent child2 = new Child("A", "B", "C");
        child2.print();
        child1.print2();
    }
}
