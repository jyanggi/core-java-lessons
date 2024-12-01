package lessons.v8.ocp.chapter3.generics;

import static java.lang.System.out;

import java.util.Arrays;
import java.util.stream.Stream;

public class GenericInterfaceSample {

    public static void main(String[] args) {
        GenericInterface<Class<?>> myInterface = c -> {
            out.println(c.getSimpleName());
            out.println("Methods---------------");
            Stream.of(c.getMethods()).forEach(out::println);
            out.println("----------------------");
        };
        Arrays.asList(GenericClass.class, String.class, Integer.class,
                Object.class).forEach(myInterface::describe);

    }

}
