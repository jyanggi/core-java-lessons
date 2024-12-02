package lessons.v8.ocp.chapter7;

import static java.lang.System.out;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ExecutorServiceSample {

    public static void main(String[] args) throws InterruptedException{

        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            out.println("begin");
            Future<String> future = service.submit(() -> "Hello");
            out.println(future.get(20, TimeUnit.MILLISECONDS));
            service.execute(() -> out.println("Printing i"));
            service.execute(() -> {
                for (int i = 0; i < 3; i++)
                    out.println("Printing: " + i);
            });
            service.execute(() -> out.println("Printing i"));
            out.println("end");
           List<Future<String>> results = service.invokeAll(List.of(()-> "A",()-> "B",()-> "C"));
            for (Future<String> result : results) {
                String s = result.get(20, TimeUnit.MILLISECONDS);
                out.println(s);
            }

        } catch (InterruptedException | ExecutionException
                | TimeoutException e) {
            e.printStackTrace();
        } finally {
            if (service != null){
                service.shutdown();
                service.awaitTermination(1,TimeUnit.MINUTES);
                out.println(service.isTerminated());
            }
        }

    }

}
