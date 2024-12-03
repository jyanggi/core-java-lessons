package lessons.v8.ocp.chapter3.collections;

import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class QueueSample {


    static class MyQueue<T>{
        private final Stack<T> stack1 = new Stack<>();
        private final Stack<T> stack2 = new Stack<>();


        private void transferIfNeeded(){
            if(stack2.isEmpty()){
                while(!stack1.isEmpty()){
                    stack2.push(stack1.pop());
                }
            }
        }

        public void enqueue(T item){
            transferIfNeeded();
            stack1.push(item);
        }

        public T dequeue(){
            transferIfNeeded();
            if(!stack2.isEmpty()){
                return stack2.pop();
            }
            return null;
        }

        public T peek(){
            transferIfNeeded();
            if(!stack2.isEmpty()){
                return stack2.peek();
            }
            return null;
        }

        private String collectReverse(Stack<T> stack) {
           return IntStream.range(0, stack.size())
              .mapToObj(i -> stack.get(stack.size() - 1 - i))
              .map(String::valueOf).collect(Collectors.joining(","));
        }
        @Override
        public String toString(){
            String stack2Vals = stack2.isEmpty() ? "": "Stack2: "+ collectReverse(stack2)+",";
            String stack1Vals = stack1.isEmpty() ? "": "Stack1: "+stack1.stream().map(String::valueOf).collect(Collectors.joining(","));

            return "["+ stack2Vals   + stack1Vals  +"]";
        }
    }

    public static void main(String[]args){

        int count =1;
        MyQueue<Integer> myQueue = new MyQueue<>();
        System.out.println(myQueue);
        enqueueAndPrint(myQueue, count++);
        enqueueAndPrint(myQueue, count++);
        peekAndPrint(myQueue);
        dequeueAndPrint(myQueue);
        enqueueAndPrint(myQueue, count++);
        enqueueAndPrint(myQueue, count++);
        enqueueAndPrint(myQueue, count++);
        peekAndPrint(myQueue);
        dequeueAndPrint(myQueue);
        dequeueAndPrint(myQueue);
        enqueueAndPrint(myQueue, count++);
        dequeueAndPrint(myQueue);
        enqueueAndPrint(myQueue, count++);
        enqueueAndPrint(myQueue, count++);
        enqueueAndPrint(myQueue, count);
        dequeueAndPrint(myQueue);
        dequeueAndPrint(myQueue);

    }



    static void dequeueAndPrint(MyQueue myQueue){
        System.out.println("Dequeued: "+myQueue.dequeue());
        System.out.println(myQueue);
    }
    static <E> void enqueueAndPrint(MyQueue<E> myQueue, E item){
        System.out.println("Enqueued: "+item);
        myQueue.enqueue(item);
        System.out.println(myQueue);
    }

    static void peekAndPrint(MyQueue myQueue){
        System.out.println("Peek First: "+myQueue.peek());
        System.out.println(myQueue);
    }


}
