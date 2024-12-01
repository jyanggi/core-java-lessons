package lessons.v8.ocp.chapter7;

import static java.lang.System.out;

public class ThreadSample {

    public static void main(String[] args) {

        new Thread(new MyRunnable()).start();
        new MyThread().start();
        new Thread(() -> out.println("FunctionalInterface Runnable.run()"))
                .start();

    }

    static class MyRunnable implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
                out.println("MyRunnable.run() sleep 1000ms");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(500);
                out.println("MyThread.run() sleep 500ms");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
