package lessons.v8.oca.chapter2;

public class InstanceOfSample {

    interface MyInterface{
        default void print(){
            System.out.println("MyInterface");
        }
    }

  static  abstract class MyAbstract{

        abstract void callAbstract();
  }


  static class MyClass extends MyAbstract implements  MyInterface{


      @Override
      void callAbstract() {

      }
  }


  static class AnotherClass implements  MyInterface{

  }

    public static void main(String [] args){

        AnotherClass anotherClass = new AnotherClass();
        MyClass myClass = new MyClass();
        System.out.println(myClass instanceof  Object);
        System.out.println(myClass instanceof  MyInterface);
        System.out.println(myClass instanceof  MyAbstract);
        System.out.println(myClass instanceof  MyClass);
        System.out.println((MyInterface) myClass instanceof  AnotherClass);

        System.out.println(anotherClass instanceof  Object);
        System.out.println(anotherClass instanceof  MyInterface);
        System.out.println((MyInterface)anotherClass instanceof  MyAbstract);
        System.out.println(anotherClass instanceof  AnotherClass);
        System.out.println((MyInterface) anotherClass instanceof  MyClass);




    }
}
