package lessons.v8.ocp.chapter3.collections;

import java.util.*;

public class CollectionsSample {




    public static void main(String[]args){

        List<? super Number> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2.10F);
        numbers.add(0b11);
        numbers.add(010);
        numbers.add(0xFF);
        System.out.println(numbers);
        numbers.replaceAll(n->((Number)n).doubleValue()*2);
        System.out.println(numbers);
        Set<? extends Number> numbers2 = new TreeSet<>(Set.of(1,23,4,5,2));
        System.out.println(numbers2);
        Queue<String> queue = new LinkedList<>();
        queue.offer("A");
        queue.offer("B");
        queue.offer("C");
        System.out.println(queue);
        queue.remove();
        System.out.println(queue);


    }
}
