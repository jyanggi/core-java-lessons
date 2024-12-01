package lessons.v8.ocp.chapter2.factory;

import java.util.List;
import java.util.Arrays;

public class ObjectFactorySample {

    public static void main(String[] args) {

        List<Class<?>> classList = Arrays.asList(String.class, Integer.class,
                Double.class, Object.class, Byte.class, Float.class,
                Boolean.class, Character.class, Long.class);
        
        classList.stream().map(ObjectFactory::getObject)
                .forEach(ObjectFactorySample::printObject);
    }

    public static void printObject(Object o) {
        System.out.printf("\nValue: %s, Class Name: %s\n-----", o, o.getClass());
    }
}
