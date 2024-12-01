package lessons.v8.ocp.chapter3.generics;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import static java.lang.System.out;

public class GenericClassSample {

    public static void main(String[] args) {

        GenericClass<String> genericString = new GenericClass<>("Hello World");
        GenericClass<List<Integer>> genericList = new GenericClass<>(
                Arrays.asList(1, 2, 3, 4));
        GenericClass<Integer> genericInteger = new GenericClass<>(
                Integer.valueOf(21));
        GenericClass<Boolean> genericBoolean = new GenericClass<>(false);
        List<GenericClass<?>> myList = new ArrayList<>();
        myList.add(genericString);
        myList.add(genericList);
        myList.add(genericInteger);
        myList.add(genericBoolean);
        myList.forEach(g -> out.println(g));
    }

}
