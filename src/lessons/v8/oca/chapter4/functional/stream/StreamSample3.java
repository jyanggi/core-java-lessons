package lessons.v8.oca.chapter4.functional.stream;

import static java.lang.System.out;

import java.util.Arrays;

import static java.util.stream.Collectors.*;

import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

public class StreamSample3 {

    public static void main(String[] args) {
        Pattern p = Pattern.compile("([a-zA-Z])(\\1)",
                Pattern.DOTALL | Pattern.CASE_INSENSITIVE);

        String res = "";
/*
        while(p.matcher("aaabccddd").find()){
            out.println("Matched");
            res = p.matcher("aaabccddd").replaceAll("");
        }*/
        out.println(res);
        out.println("aaabccddd".replaceAll("([a-zA-Z])(\\1)",""));

        Stream.of("Hello", "World", "!!!").map(String::length)
                .forEach(out::print);
        out.println();

        out.println(Stream
                .of(Arrays.asList("h", "i", "j"), Arrays.asList("e", "f", "g"),
                        Arrays.asList("a", "b", "c"))
                .peek(out::println).flatMap(List::stream)
                .map(String::toUpperCase).sorted().collect(toList()));

        ToIntFunction<Integer> mapToIntFunction = Integer::valueOf;
        IntStream sumInt = Stream.of(1, 3, 5, 7).mapToInt(mapToIntFunction);
        int answer = sumInt.sum();
        out.println(answer);

        IntStream.rangeClosed(1, 20).average().ifPresent(out::println);

        out.println(IntStream.range(1, 11).sum());

        out.println(Stream.of("Tiger", "Lion", "Dragon", "Cat", "Owl")
                .collect(toMap(String::toUpperCase, String::length)));

        out.println(Stream.of("Tiger", "Lion", "Dragon", "Cat", "Owl")
                .collect(toMap(String::length, String::toUpperCase, (s1, s2) -> String.format("%s, %s ", s1, s2))
        ));

 /*               .collect(toMap(String::length,
                        String::toUpperCase,
                        (s1, s2) -> String.format("%s , %s ", s1, s2),
                        TreeMap::new)));
*/
        out.println(Stream.of("Tiger", "Lion", "Dragon", "Cat", "Owl")
                .collect(groupingBy(String::length)));

        out.println(Stream.of("Tiger", "Lion", "Dragon", "Cat", "Owl")
                .collect(groupingBy(String::length, counting())));

        out.println(Stream.of("A", "A", "B", "C", "C")
                .collect(groupingBy(Function.identity(), counting())));

        out.println(Stream.of("Tiger", "Lion", "Dragon", "Cat", "Owl")
                .collect(partitioningBy(s -> s.contains("i"))));
/*
        out.println(Stream.of("Tiger", "Lion", "Dragon", "Cat", "Owlllll")
                .collect(groupingBy(String::length, mapping(s -> s.charAt(0),
                        minBy(Comparator.naturalOrder())))));*/

        Stream<String> str = Stream.empty();
        out.println(str.collect(groupingBy(s -> s.length() > 1)));

    }

}
