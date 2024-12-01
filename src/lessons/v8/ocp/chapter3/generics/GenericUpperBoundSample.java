package lessons.v8.ocp.chapter3.generics;

import java.util.List;
import static java.lang.System.out;

public class GenericUpperBoundSample {

    public static void main(String[] args) {
        List<Integer> integerList = List.of(3, 4, 5, 6);
        List<Double> doubleList = List.of(3.14, 1.16);
        List<Number> numList = List.of(3l, 3.4, 2.5f);
        printWildList(doubleList);
        printWildList(integerList);
        printWildList(numList);
    }

    public static void printWildList(List<? extends Number> wildList) {
        out.println(wildList);
    }

}
