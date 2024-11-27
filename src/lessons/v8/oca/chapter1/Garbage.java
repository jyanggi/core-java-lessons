package lessons.v8.oca.chapter1;

public class Garbage {


    static class Finalizer{


        protected void finalize(){
            System.out.println("Finalize called");
        }

        void printMethod(){
            System.out.println("printMethod");
        }
    }


    public static void main(String [] args){
        {
            Finalizer finalizer = new Finalizer();
            finalizer.printMethod();
            finalizer = null;
            System.gc();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Finalizer finalizer1 = new Finalizer();
        finalizer1.printMethod();
        System.out.println("Program ended.");

    }
}
