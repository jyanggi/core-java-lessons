package lessons.v8.ocp.chapter7;

import java.util.concurrent.*;


public class ConcurrentCollectionsExample {

    public static void main(String[] args) throws InterruptedException {

        // 1. ConcurrentHashMap Example
        ConcurrentHashMap<String, Integer> concurrentMap = new ConcurrentHashMap<>();
        concurrentMap.put("Alice", 10);
        concurrentMap.put("Bob", 20);
        concurrentMap.put("Charlie", 30);

        System.out.println("Initial ConcurrentHashMap: " + concurrentMap);

        concurrentMap.compute("Alice", (key, val) -> val + 5);
        System.out.println("After compute on Alice: " + concurrentMap);

        // Parallel iteration
        System.out.println("Parallel iteration:");
        concurrentMap.forEach(1, (key, value) ->
          System.out.println(Thread.currentThread().getName() + ": " + key + " -> " + value)
        );

        // 2. CopyOnWriteArrayList Example
        CopyOnWriteArrayList<String> copyOnWriteList = new CopyOnWriteArrayList<>();
        copyOnWriteList.add("One");
        copyOnWriteList.add("Two");
        copyOnWriteList.add("Three");

        System.out.println("Initial CopyOnWriteArrayList: " + copyOnWriteList);

        // Iteration doesn't fail when modified
        for (String item : copyOnWriteList) {
            if (item.equals("Two")) {
                copyOnWriteList.add("Four");
            }
            System.out.println(item);
        }
        System.out.println("After modification during iteration: " + copyOnWriteList);

        // 3. ConcurrentLinkedQueue Example
        ConcurrentLinkedQueue<String> concurrentQueue = new ConcurrentLinkedQueue<>();
        concurrentQueue.add("Task1");
        concurrentQueue.add("Task2");
        concurrentQueue.add("Task3");

        System.out.println("Initial ConcurrentLinkedQueue: " + concurrentQueue);

        // Producer-Consumer Example
        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.submit(() -> {
            while (!concurrentQueue.isEmpty()) {
                System.out.println("Consumer: Processed " + concurrentQueue.poll());
            }
        });

        executor.submit(() -> {
            concurrentQueue.add("Task4");
            System.out.println("Producer: Added Task4");
        });

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.SECONDS);

        // 4. BlockingQueue Example
        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(2);

        // Producer thread
        Thread producer = new Thread(() -> {
            try {
                blockingQueue.put(1);
                System.out.println("Producer: Added 1");
                blockingQueue.put(2);
                System.out.println("Producer: Added 2");
                blockingQueue.put(3); // Blocks if the queue is full
                System.out.println("Producer: Added 3");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Consumer thread
        Thread consumer = new Thread(() -> {
            try {
                Thread.sleep(1000); // Simulate delay
                System.out.println("Consumer: Took " + blockingQueue.take());
                System.out.println("Consumer: Took " + blockingQueue.take());
                System.out.println("Consumer: Took " + blockingQueue.take());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();

        // 5. ConcurrentSkipListSet Example
        ConcurrentSkipListSet<Integer> skipListSet = new ConcurrentSkipListSet<>();
        skipListSet.add(10);
        skipListSet.add(20);
        skipListSet.add(30);

        System.out.println("ConcurrentSkipListSet: " + skipListSet);

        // Higher and Lower
        System.out.println("Higher than 15: " + skipListSet.higher(15));
        System.out.println("Lower than 25: " + skipListSet.lower(25));
    }
}
