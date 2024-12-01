package lessons.v8.ocp.chapter7;

import static java.lang.System.out;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceSample {

    public static void main(String[] args) {

        out.println(Runtime.getRuntime().availableProcessors());
        ScheduledExecutorService service = null;
        try {
            service = Executors.newScheduledThreadPool(5);
            out.println("begin");
            ScheduledFuture<String> future = service.schedule(
                    () -> "delay of 10 seconds", 10, TimeUnit.SECONDS);
            service.scheduleAtFixedRate(() -> {
                out.println("scheduleAtFixedRate");
            }, 1, 2, TimeUnit.SECONDS);
            service.scheduleWithFixedDelay(() -> {
                out.println("scheduleWithFixedDelay");
            }, 5, 1, TimeUnit.SECONDS);
            out.println(future.get());
            out.println("end");

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            if (service != null)
                service.shutdown();
        }

    }

}
