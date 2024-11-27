package lessons.v8.oca.chapter3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.lang.System.out;

public class ArrayListSample {

    public static void main(String[] args) {

        List<String> genericTypeList = new ArrayList<>();
        genericTypeList.add("Hello");
        genericTypeList.add("World");
        genericTypeList.add("!");
        genericTypeList.set(2, "WOrld");
        genericTypeList.add(1, "0");
        out.println(genericTypeList.get(1));
        out.println(genericTypeList);
        Collections.sort(genericTypeList);
        out.println(genericTypeList);
        genericTypeList.remove(1);
        out.println(genericTypeList);
        genericTypeList.clear();
        out.println(genericTypeList);
        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5); // fixed size
        out.println(intList);
        try {
            intList.add(0);
        } catch (UnsupportedOperationException e) {
            out.println("Using Arrays.asList creates a fix sixed List");
        }

    }
}
