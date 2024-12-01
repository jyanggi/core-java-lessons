package lessons.v8.ocp.chapter7;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import static java.lang.System.out;

public class CyclicBarrierExample {

    public static void main(String[] args) {
        int numThreads = 5;
        CyclicBarrier cb = new CyclicBarrier(numThreads);
        ExecutorService service = Executors.newFixedThreadPool(numThreads);

        try {

            for (int i = 0; i < numThreads; i++) {
                service.submit(CyclicBarrierExample::prepareToWork);
            }

            for (int i = 0; i < numThreads; i++) {
                service.submit(() -> prepareToWorkCyclic(cb));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (service != null) {
                service.shutdown();
            }
        }
    }

    private static void prepareToWork() {
        wakeUp();
        shower();
        haveBreakfast();
        commute();
    }

    private static void prepareToWorkCyclic(CyclicBarrier cb) {
        try {
            wakeUp();
            cb.await();
            shower();
            cb.await();
            haveBreakfast();
            cb.await();
            commute();
            cb.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }

    }

    private static void commute() {
        out.println("Commuting to work.");

    }

    private static void haveBreakfast() {
        out.println("Having breakfast.");

    }

    private static void shower() {
        out.println("Taking a shower.");

    }

    private static void wakeUp() {
        out.println("Waking up.");

    }
}
