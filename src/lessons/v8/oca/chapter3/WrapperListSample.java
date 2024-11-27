package lessons.v8.oca.chapter3;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class WrapperListSample {

    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>();
        intList.add(1);// autoboxes int to Integer
        out.println(intList);
        intList.add(Integer.valueOf(4)); // new Integer()
        intList.add(Integer.valueOf(5)); // new Integer()
        out.println(intList);
        intList.remove(1); // removes elem on index 1
        out.println(intList);
        intList.remove(Integer.valueOf(5));//removes the obj that should be removed
        out.println(intList);
        int num = intList.get(0); //unboxes from Integer to primitive int
        out.println(num);

        intList.add(null);
        try{
            // added null but cannot auto unbox, need to use wrapper version
            int nullInt = intList.get(intList.size()-1);
        }catch (NullPointerException e){
            out.println(e);
        }
        Integer nullInt = intList.get(intList.size()-1);
        out.println(nullInt);
    }

}
