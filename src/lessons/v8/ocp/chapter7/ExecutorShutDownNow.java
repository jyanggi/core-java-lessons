package lessons.v8.ocp.chapter7;

import java.util.concurrent.*;

import static java.lang.System.out;

public class ExecutorShutDownNow {



    public static void main(String[] args) throws InterruptedException {

        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            out.println("begin");
            Future<String> future = service.submit(() -> "Hello");
            out.println(future.get(20, TimeUnit.MILLISECONDS));
            service.execute(() -> out.println("Printing i"));
            service.execute(() -> {
                for (int i = 0; i < 3; i++) {
                    out.println("Printing: " + i);
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                        out.println(e);
                    }

                }
            });
            service.execute(() -> out.println("Printing i"));
            out.println("end");
            out.println(service.shutdownNow());
            out.println(service.isShutdown());
            out.println(service.isTerminated());

        } catch (InterruptedException | ExecutionException
                 | TimeoutException e) {
            e.printStackTrace();
        } finally {
            if (service != null) {
                service.shutdown();
                service.awaitTermination(1, TimeUnit.MINUTES);
                out.println(service.isTerminated());
            }

        }
    }
}
