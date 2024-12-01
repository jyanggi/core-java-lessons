package lessons.v8.ocp.chapter4;


import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class FunctionSamples {

    @FunctionalInterface
    interface VarArgFunctionr<T> {
        T apply(T...args);
    }

    public static void main(String[] args) {
        Consumer<Object> printer = System.out::println;
        Predicate<String> isBlank = String::isBlank;
        Predicate<String> startsWithS = s->s.toLowerCase().startsWith("s");
        Predicate<String> checker = isBlank.negate().and(startsWithS);
        printer.accept(checker.test(""));
        printer.accept(checker.test("ABC"));
        printer.accept(checker.test("See"));
        printer.accept(checker.test("sEE"));
        VarArgFunctionr<String> concatMe = vargs-> Arrays.stream(vargs).collect(Collectors.joining());
        printer.accept(concatMe.apply("A","B","Z"));






    }

}
