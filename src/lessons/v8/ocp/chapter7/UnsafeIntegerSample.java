package lessons.v8.ocp.chapter7;

import static java.lang.System.out;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class UnsafeIntegerSample {

    static Integer integer = 0;

    public static void main(String[] args) {

        out.println("begin");
        out.println(integer);

        ExecutorService service = Executors.newFixedThreadPool(5);
        IntStream.range(100, 110).forEach(val -> {
            service.submit(() -> {
                try {
                    Thread.sleep(val);
                    out.println(++integer);
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
