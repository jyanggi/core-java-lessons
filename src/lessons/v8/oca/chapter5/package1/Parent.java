package lessons.v8.oca.chapter5.package1;

import lessons.v8.oca.chapter5.MyInterface;

import java.io.IOException;

public class Parent implements MyInterface {

    protected static String PROTECTED_STATIC_STRING= "PROTECTED_STATIC_STRING";

    String defaultAccessString;

    protected String protectedString;

    public Parent(){
        defaultAccessString = "defaultAccessString";
        protectedString = "protectedString";
    }


    public Object callThrow() throws Throwable{
        throw new IOException("IO");
    }

    public  Parent(String defaultAccessString, String protectedString){
        this.defaultAccessString = defaultAccessString;
        this.protectedString = protectedString;
    }

    public void print(){
        System.out.println(String.format("%s, %s, %s", defaultAccessString, protectedString, PROTECTED_STATIC_STRING));
    }

    @Override
    public void callMyMethod() {
        System.out.println("Parent callMyMethod");
    }
}
