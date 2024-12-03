package lessons.v8.ocp.chapter7;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class RecursiveTaskExample {


    static class MyTask extends RecursiveTask<Integer>{

        private int start;

        private int end;

        private static final int LIMIT = 10;

        int [] intsToProcess;


        public MyTask(int start, int end, int [] intsToProcess){

            this.start=start;
            this.end = end;
            this.intsToProcess = intsToProcess;
        }

        @Override
        protected Integer compute() {
            if(end - start <=LIMIT){
                int sum = 0;

                for(int i = start; i < end;i++){
                    intsToProcess[i] = i;
                    System.out.println("int processed: "+ intsToProcess[i]);
                    sum+=intsToProcess[i];
                }
                return sum;
            }else{
                int middle = start+ ((end-start)/2);
                System.out.println("[start=" + start + ",middle=" + middle
                  + ",end=" + end + "]");
                MyTask task1 = new MyTask(start, middle, intsToProcess);
                task1.fork();
                return new MyTask(middle, end, intsToProcess).compute() + task1.join();
            }
        }
    }

    public static void main(String [] args){

        int[] ints = new int[1000];
        ForkJoinTask<Integer> task = new MyTask(0, ints.length, ints);
        ForkJoinPool myPool = new ForkJoinPool();
        int sum = myPool.invoke(task);
        System.out.println("Sum: " + sum);
        System.out.println("Processed: " + Arrays.toString(ints));
        System.out.println("Processed Sum: " + Arrays.stream(ints).sum());


    }
}
