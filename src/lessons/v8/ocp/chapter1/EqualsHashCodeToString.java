package lessons.v8.ocp.chapter1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class EqualsHashCodeToString {
    public static abstract class Defaults {

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }

            if (!obj.getClass().equals(this.getClass())){
                return false;
            }
            try {
                for (var field : this.getClass().getDeclaredFields()) {
                    field.setAccessible(true); // Ensure access to private fields
                    Object thisValue = field.get(this);
                    Object objValue = field.get(obj);
                    if (!Objects.equals(thisValue, objValue)) {
                        return false;
                    }
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Unable to access fields for comparison", e);
            }
            return true;
        }

        @Override
        public int hashCode(){
            return this.toString().hashCode();
        }

        @Override
        public String toString() {
            if (this == null) {
                return null;
            }
            return String.format("%s[%s]", this.getClass().getSimpleName(),
              Arrays.stream(this.getClass().getDeclaredFields()).map(f -> {
                    try {
                        f.setAccessible(true);
                        return String.format("%s=%s", f.getName(), f.get(this));
                    } catch (IllegalAccessException e) {
                        return String.format("%s=null", f.getName());
                    }
                }
              ).collect(Collectors.joining(","))
            );

        }
    }


    static class Test extends Defaults {
        String name = "John";
        transient int transInt = 1;
        volatile double volatileDouble = 2.0;
    }


    public static void main(String[] args) {
        Test test1 = new Test();
        Test test2 = new Test();
        Test test3 = new Test();
        System.out.println(new Test());
        System.out.println(test1.equals(1));
        System.out.println(test1.equals(test2));
        System.out.println(test2.equals(test1));
        test2.name = "New Name";
        System.out.println(test2.equals(test1));


        //Test hashcode
        System.out.println(test1.hashCode());
        System.out.println(test2.hashCode());
        System.out.println(test3.hashCode());


        Map<Test,String> testMap = new HashMap<>();

        testMap.put(test1, "test1");
        System.out.println(testMap);
        testMap.put(test2, "test2");
        System.out.println(testMap);
        testMap.put(test3, "test3");
        System.out.println(testMap);

    }
}
