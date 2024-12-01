package lessons.v8.ocp.chapter4;

import static java.lang.System.out;

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamSample2 {

    public static void main(String[] args) {
        StringBuilder builder = Stream.of("String", "Builder").collect(
                StringBuilder::new, StringBuilder::append,
                StringBuilder::append);
        out.println(builder);

        TreeSet<String> treeSet = Stream
                .of("Tree", "Set", "Tree", "Set", "Tree", "Set")
                .collect(TreeSet::new, TreeSet::add, TreeSet::addAll);
        out.println(treeSet);
        Set<String> set = Stream.of("s", "e", "t", "e", "t", "t", "s")
                .collect(Collectors.toSet());
        out.println(set);
        Stream.of("monkey", "gorilla", "bonobo").filter(x -> x.startsWith("m"))
                .forEach(out::println);
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).skip(3l).forEach(out::print);
    }

}
