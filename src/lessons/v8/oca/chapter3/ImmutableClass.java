package lessons.v8.oca.chapter3;

public class ImmutableClass {

   static final class Immutable{

        private final String name;

        Immutable(){
            name = "No Name";
        }

        Immutable(String name){
            this.name = name;
        }

        @Override
       public String  toString(){
            return this.name;
        }

    }


    public static void main(String [] args){
        Immutable immutable = new Immutable("John");
        System.out.println(immutable);
    }

}
