package lessons.v8.ocp.chapter1;

public class NestedClasses {

    static abstract class Abs{

        abstract void printAbs();
    }
   static class A{
        int x = 1;
        class B{
            int x = 2;
            class C{
                int x = 3;

                void printX(){
                    final int x = 5;
                    class Print{
                        int y = 4;
                    void print(){
                        System.out.println(x);
                        System.out.println(y);
                        System.out.println(C.this.x);
                        System.out.println(B.this.x);
                        System.out.println(A.this.x);
                    }
                    }
                    Print p = new Print();
                    p.print();
                    new Abs(){
                        @Override
                        void printAbs() {
                            System.out.println("Abstract");
                        }
                    }.printAbs();
                }
            }
        }
    }



    public static void main(String []args){

        A a = new A();
        A.B b = a.new B();
        A.B.C c = b.new C();
        c.printX();

    }
}
