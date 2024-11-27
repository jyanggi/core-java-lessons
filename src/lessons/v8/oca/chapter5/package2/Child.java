package lessons.v8.oca.chapter5.package2;

import lessons.v8.oca.chapter5.package1.Parent;

class Child extends Parent {

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

}
