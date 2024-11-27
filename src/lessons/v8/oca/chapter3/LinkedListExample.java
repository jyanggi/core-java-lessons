package lessons.v8.oca.chapter3;

import java.util.LinkedList;

public class LinkedListExample {




    public static void main(String [] args){

        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("A");
        linkedList.add("B");
        System.out.println(linkedList.get(1));

        System.out.println(linkedList.getFirst());
        System.out.println(linkedList);
    }
}
