package lessons.v8.oca.chapter5.package1;

public class Parent {

    protected static String PROTECTED_STATIC_STRING= "PROTECTED_STATIC_STRING";

    String defaultAccessString;

    protected String protectedString;

    public Parent(){
        defaultAccessString = "defaultAccessString";
        protectedString = "protectedString";
    }

    public  Parent(String defaultAccessString, String protectedString){
        this.defaultAccessString = defaultAccessString;
        this.protectedString = protectedString;
    }

    public void print(){
        System.out.println(String.format("%s, %s, %s", defaultAccessString, protectedString, PROTECTED_STATIC_STRING));
    }

}
