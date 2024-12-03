package lessons.v8.ocp.chapter7;

import java.util.*;
import java.util.stream.*;
import java.util.concurrent.*;
import java.util.function.Function;

public class ParallelStreamsExample {
    public static void main(String[] args) {

        // 1. Example: Parallel Stream for Collection
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "Dave", "Eve");

        System.out.println("Processing with Parallel Stream:");
        names.parallelStream()
          .map(String::toUpperCase)
          .forEach(name ->
            System.out.println(Thread.currentThread().getName() + " processed " + name)
          );

        System.out.println("\nProcessing Sequential Stream:");
        names.stream()
          .map(String::toUpperCase)
          .forEach(name ->
            System.out.println(Thread.currentThread().getName() + " processed " + name)
          );

        // 2. Example: Reducing a List with Parallel Streams
        List<Integer> numbers = IntStream.rangeClosed(1, 1000).boxed().collect(Collectors.toList());

        int sum = numbers.parallelStream()
          .reduce(0, Integer::sum); // Sum all numbers

        System.out.println("\nSum of 1 to 1000 using Parallel Stream: " + sum);

        // 3. Parallel vs Sequential Performance (Large Dataset)
        List<Long> bigList = LongStream.rangeClosed(1, 100_000_000).boxed().collect(Collectors.toList());

        long sequentialStart = System.currentTimeMillis();
        bigList.stream().mapToLong(i -> i * 2).sum();
        long sequentialEnd = System.currentTimeMillis();

        long parallelStart = System.currentTimeMillis();
        bigList.parallelStream().mapToLong(i -> i * 2).sum();
        long parallelEnd = System.currentTimeMillis();

        System.out.println("\nSequential Stream Time: " + (sequentialEnd - sequentialStart) + "ms");
        System.out.println("Parallel Stream Time: " + (parallelEnd - parallelStart) + "ms");

        // 4. Handling Thread-Safety with Parallel Streams
        ConcurrentMap<String, Long> wordCount = new ConcurrentHashMap<>();
        List<String> words = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");

        words.parallelStream()
          .forEach(word ->
            wordCount.merge(word, 1L, Long::sum) // Thread-safe counting
          );

        System.out.println("\nWord Counts: " + wordCount);

        // 5. Ordered Parallel Streams
        System.out.println("\nProcessing with Ordered Parallel Stream:");
        names.parallelStream()
          .map(String::toUpperCase)
          .forEachOrdered(name -> // Maintains order even in parallel
            System.out.println(Thread.currentThread().getName() + " processed " + name)
          );

        // 6. Custom Thread Pool for Parallel Streams
        ForkJoinPool customThreadPool = new ForkJoinPool(4); // Limit to 4 threads
        try {
            customThreadPool.submit(() -> {
                System.out.println("\nProcessing with Custom Thread Pool:");
                names.parallelStream()
                  .map(String::toUpperCase)
                  .forEach(name ->
                    System.out.println(Thread.currentThread().getName() + " processed " + name)
                  );
            }).get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            customThreadPool.shutdown();
        }
    }
}
