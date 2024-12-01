package lessons.v8.ocp.chapter7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import static java.lang.System.out;

public class AtomicExample {

    public static void main(String[] args) {

        AtomicInteger integer = new AtomicInteger();
        out.println("begin");
        out.println(integer);

        ExecutorService service = Executors.newFixedThreadPool(10);

        IntStream.range(100, 110).forEach(val -> {
            service.submit(() -> {
                try {
                    Thread.sleep(val);
                    out.println(integer.addAndGet(1));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

        });

        if (service != null) {
            service.shutdown();
            try {
                service.awaitTermination(50, TimeUnit.SECONDS);
                out.println("end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
