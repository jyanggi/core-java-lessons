package lessons.v8.oca.chapter1;

public class OrderOfInitialization {



    static class Chick{
        private static final String STATIC = "HELLO";

        static{
            System.out.println("Static initializer class level " + Chick.STATIC);

        }
        private String name;
        {
            name = "Fluffy";
            System.out.println("Setting the field "+ this.name);
        }

        Chick(){
            name = "Tiny";
            System.out.println("Setting the field in constructor "+ this.name);
        }



    }



    public static void main(String[] args){
        int i;
        // need to initialize all local method vars System.out.println(i);
    new Chick();
    }
}
