package lessons.v8.oca.chapter3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImmutableClass {

   static final class Immutable{

        private final String name;
        private final List<String> myList;

        Immutable(){
            name = "No Name";
            this.myList = List.of();
        }

        Immutable(String name, List<String> myList){
            this.name = name;
            this.myList = Collections.unmodifiableList(new ArrayList<>(myList));
        }

        @Override
       public String  toString(){
            return this.name + myList;
        }

    }


    public static void main(String [] args){
        List<String> modifiableList = new ArrayList<>();
        modifiableList.add("A");
        modifiableList.add("B");
        Immutable immutable = new Immutable("John", modifiableList);
        modifiableList.add("C");
        System.out.println(immutable);
        System.out.println(modifiableList);
        try{
            immutable.myList.clear();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
