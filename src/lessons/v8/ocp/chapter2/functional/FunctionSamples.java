package lessons.v8.ocp.chapter2.functional;

import lessons.v8.ocp.chapter2.builder.PersonBuilder;

public class FunctionSamples {

    @FunctionalInterface
    public interface MyFunc<T, U, V, R> {
        R get(T t, U u, V v);
    }

    public static void main(String[] args) {

        MyFunc<String, Integer, Boolean, String> testFunc = (a, b, c) -> a + b + c;
        MyFunc<String, PersonBuilder.Person, PersonBuilder.Person, String> testFunc2 = (a, b, c) -> a + b + c;
        PersonBuilder.Person john = new PersonBuilder().firstName("John")
          .middleName("Laurence").lastName("Yanguas").age(21)
          .gender(PersonBuilder.Gender.MALE).build();
        PersonBuilder.Person jane = new PersonBuilder().firstName("Jane").middleName("B.")
          .lastName("Yanguas").age(22).gender(PersonBuilder.Gender.FEMALE).build();

        System.out.println(testFunc.get("Hello", 123, true));
        System.out.println(testFunc2.get("Ey", john, jane));



    }

}
