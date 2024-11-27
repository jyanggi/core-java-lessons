package lessons.v8.oca.chapter4.method;

import java.util.Arrays;

public class MethodBasics {

static class MethodSample{

    private  static int MY_INT = 0;
    static void callStatic(int i){
        System.out.println("class method=" + MY_INT);
        MY_INT+=i;
    }

    private void callMethod(){
        System.out.println("instance method");
    }

    protected String returnString(){
        callMethod();
        return "String";
    }

    protected void callVargs(int i, int ...j){
        System.out.println(i);
        System.out.println(Arrays.toString(j));
    }

}

static class MethodChild extends MethodSample{

    public void callProtected(){
        // cannot access since private this.callMethod();
        System.out.println(this.returnString());
    }

    @Override
    protected String returnString(){
        return super.returnString()+ "Override";
    }

    protected String callChecked(int i) throws Exception{
        if(i%2==0){
            throw new Exception("Cannot process even number");
        }
        return "Checked";
    }

}


public static void main(String [] args){
    MethodSample.callStatic(1);
    MethodSample.callStatic(1);
    MethodSample instance = new MethodSample();
    instance.callMethod();
    System.out.println(instance.returnString());
    MethodChild child = new MethodChild();
    child.callProtected();
    try {
        child.callChecked(2);
    } catch (Exception e) {
        System.out.println(e);
    }
    child.callVargs(3,4,5,6,7,8);
    child.callVargs(3,null);

    System.out.println(instance.MY_INT);
    System.out.println(MethodSample.MY_INT);
    instance = null;
    System.out.println(instance.MY_INT);

}

}
