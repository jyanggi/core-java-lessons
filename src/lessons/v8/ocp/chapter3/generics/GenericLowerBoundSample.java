package lessons.v8.ocp.chapter3.generics;

import java.util.List;
import static java.lang.System.out;

public class GenericLowerBoundSample {

    public static void main(String[] args) {
        List<Integer> integerList = List.of(3, 4, 5, 6);
        List<Object> objectList = List.of(3.14, 1.16);
        List<Number> numList = List.of(3l, 3.4, 2.5f);
        printWildList(objectList);
        printWildList(integerList);
        printWildList(numList);
    }

    public static void printWildList(List<? super Integer> wildList) {
        out.println(wildList);
    }

}
