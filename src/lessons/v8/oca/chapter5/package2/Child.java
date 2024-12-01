package lessons.v8.oca.chapter5.package2;

import lessons.v8.oca.chapter5.MyInterface2;
import lessons.v8.oca.chapter5.package1.Parent;

import java.io.IOException;

class Child extends Parent implements MyInterface2 {

    String childString;

    public Child(){
        super();
        childString = "childString";
        Child.PROTECTED_STATIC_STRING = "CHILD_PROTECTED_STATIC_STRING";
    }

    public Child(String defaultAccessString, String protectedString, String childString){
        super(defaultAccessString,protectedString);
        this.childString = childString;
        Child.PROTECTED_STATIC_STRING = "CHILD_PROTECTED_STATIC_STRING";
    }

    public Child(String childString){
        super();
        this.childString = childString;
        Child.PROTECTED_STATIC_STRING = "CHILD_PROTECTED_STATIC_STRING";
    }

    @Override
    public String callThrow() {
        return "S";
    }

    @Override
    public  void print(){
        super.print();
        System.out.println(this.childString);
    }



    public  void print2(){
        PROTECTED_STATIC_STRING = "PRINT_2";
        super.print();
        System.out.println(this.childString);
        System.out.println("+++++++++++++");

    }

    @Override
    public void callMyMethod() {
        System.out.println("Child callMyMethod");
    }
}
