package lessons.v8.ocp.chapter3.generics;

import java.util.List;
import static java.lang.System.out;

public class GenericWildCardSample {

    public static void main(String[] args) {
        List<String> strList = List.of("Hello","World");
        List<Integer> integerList = List.of(3,4,5,6);
        printWildList(strList);
        printWildList(integerList);
    }

    public static void printWildList(List<?> wildList) {
        out.println(wildList);

    }

}
