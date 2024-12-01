package lessons.v8.ocp.chapter2.builder;

import static lessons.v8.ocp.chapter1.EqualsHashCodeToString.Defaults;

public class PersonBuilder {

    public  enum Gender {
        MALE, FEMALE
    };

    private String firstName;
    private String middleName;
    private String lastName;
    private int age;
    private Gender gender;

    public PersonBuilder firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public PersonBuilder middleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public PersonBuilder lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public PersonBuilder age(int age) {
        this.age = age;
        return this;
    }

    public PersonBuilder gender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public Person build() {
        return new Person(firstName, middleName, lastName, age, gender);
    }

    public static class Person  extends Defaults {

        private final String firstName;
        private final String middleName;
        private final String lastName;
        private final int age;
        private final Gender gender;

        private Person(String firstName, String middleName, String lastName,
                int age, Gender gender) {
            this.firstName = firstName;
            this.middleName = middleName;
            this.lastName = lastName;
            this.age = age;
            this.gender = gender;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getMiddleName() {
            return middleName;
        }

        public String getLastName() {
            return lastName;
        }

        public int getAge() {
            return age;
        }

        public Gender getGender() {
            return gender;
        }

    }
}
