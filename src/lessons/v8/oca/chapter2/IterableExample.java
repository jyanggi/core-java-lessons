package lessons.v8.oca.chapter2;

import java.util.Arrays;
import java.util.Iterator;

public class IterableExample {


    static class MyGroup<T> implements Iterable<T>{

        T[] vals;
        MyGroup(T...args){
            assert args != null;
            vals = Arrays.copyOf(args, args.length);
        }

        @Override
        public Iterator<T> iterator() {
            return new Iterator<>() {
                int count = 0;
                @Override
                public boolean hasNext() {
                    return count < vals.length;
                }

                @Override
                public T next() {
                    return vals[count++];
                }
            };
        }
    }


    public static void main(String [] args){

        MyGroup<Integer> integers = new MyGroup<>(1,2,3,4,5);

        for(int i : integers){
            System.out.print(i);
        }

        MyGroup objects = new MyGroup("A","B",1,5.0);

        for(Object o : objects){
            System.out.print(o);
        }
    }
}
