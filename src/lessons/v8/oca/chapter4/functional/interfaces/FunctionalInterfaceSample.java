package lessons.v8.oca.chapter4.functional.interfaces;

import java.util.function.Predicate;
import java.util.function.BiPredicate;
import java.util.function.Supplier;
import java.util.function.Function;
import java.util.function.Consumer;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;

import static java.lang.System.out;

import java.time.LocalDate;

public class FunctionalInterfaceSample {

    public static void main(String[] args) {

        Predicate<Integer> isGreaterThan5 = a -> a.compareTo(5) > 0;
        BiPredicate<Integer, Integer> isGreaterThanB = (a,
                b) -> a.compareTo(b) > 0;
        Predicate<String> isStringEmpty = String::isEmpty;
        Supplier<LocalDate> getDate = LocalDate::now;
        Consumer<String> printString = out::println;
        Map<String, String> testMap = new HashMap<>();
        BiConsumer<String, String> putToMap = testMap::put;
        Function<String, String> toUpper = String::toUpperCase;
        BinaryOperator<String> concat = String::concat;
        CustomInterface<String, Integer, Boolean, String> custom = (s, i,
                b) -> String.format("String:%s Integer :%d Boolean:%b\n", s, i,
                        b);
        out.println(isGreaterThan5.test(10));
        out.println(isGreaterThanB.test(10, 12));
        out.println(isStringEmpty.test("Hello"));
        printString.accept("World");
        out.println(isStringEmpty.test(""));
        out.println(getDate.get());
        putToMap.accept("John ", "Yanguas");
        out.println(testMap);
        out.println(concat.apply("John ", "Yanguas"));
        out.println(toUpper.apply("abcdefg"));
        out.println(custom.customize("Testing", 12, false));
        out.println();
    }

    @FunctionalInterface
    interface CustomInterface<T, U, V, R> {
        R customize(T t, U u, V v);
    }

}
