package lessons.v8.ocp.chapter4;

import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.Optional;

import static java.lang.System.out;

public class StreamSample {

    public static void main(String[] args) {
        out.println(Stream.generate(Math::random).limit(10).filter(d -> d > .5)
                .collect(Collectors.mapping(String::valueOf,
                        Collectors.joining(","))));

        Stream<Integer> oddNumbers = Stream.iterate(1, n -> n + 2).limit(10000);

        Optional<Integer> maximum = oddNumbers.max(Integer::compareTo);

        maximum.ifPresent(out::println);

        Stream.of(1, 3, 4, 5, 6, 7, 10, 200, 99).findAny()
                .ifPresent(out::println);

        Stream.of("First", "Hello", "World").findFirst()
                .ifPresent(out::println);
        out.println(Stream.of("Jest", "Test", "").anyMatch(String::isBlank));
        out.println(Stream.of("Jest", "Test").allMatch(s -> s.endsWith("t")));
        String word = Stream.of("w", "o", "l", "f").reduce("", String::concat);
        System.out.println(word);
        Stream.of("t", "i", "g", "e", "r").reduce(String::concat)
                .ifPresent(out::println);
        out.println(Stream.of(45, 6, 78, -9, 54).reduce(0, Integer::sum,
                Integer::sum));


        OptionalDouble od = IntStream.of(1,2,3).average();
        od.ifPresent(out::println);
        out.println(od.getAsDouble());
        out.println(IntStream.of(1,2,3).summaryStatistics());
    }
}
