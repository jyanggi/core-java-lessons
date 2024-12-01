package lessons.v8.ocp.chapter2.builder;

import static lessons.v8.ocp.chapter2.builder.PersonBuilder.Gender;
import static lessons.v8.ocp.chapter2.builder.PersonBuilder.Person;

public class PersonBuilderSample {

    public static void main(String[] args) {
        Person john = new PersonBuilder().firstName("John")
                .middleName("Laurence").lastName("Yanguas").age(21)
                .gender(Gender.MALE).build();
        Person jane = new PersonBuilder().firstName("Jane").middleName("B.")
                .lastName("Yanguas").age(22).gender(Gender.FEMALE).build();
        System.out.println(john);
        System.out.println(jane);

    }

}
