package lessons.v8.ocp.chapter7;

import static java.lang.System.out;

public class ThreadSample {

    private static int counter = 0;

    public static void main(String[] args) throws InterruptedException{

        new Thread(new MyRunnable()).start();
        new MyThread().start();
        new Thread(() -> out.println("FunctionalInterface Runnable.run()"))
                .start();

        new Thread(()->{
            for (int i = 0; i < 100; i++){
                ThreadSample.counter+=1;
            }
            System.out.println("Thread  finished: "+ counter);
        }).start();

        while(ThreadSample.counter < 100){
            System.out.println("Thread not finished: "+ counter);
            Thread.sleep(1000L);
        }



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
