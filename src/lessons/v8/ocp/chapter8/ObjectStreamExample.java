package lessons.v8.ocp.chapter8;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class ObjectStreamExample {

    private static final File FILE = new File("./resources/io/person.txt");

    public static void main(String[] args) {

        new Person();
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person());
        personList.add(new Person(20, "John Yanguas", "Hello World"));

        try (ObjectOutputStream os = new ObjectOutputStream(
                new BufferedOutputStream(new FileOutputStream(FILE)))) {
            personList.forEach(t -> {
                try {
                    os.writeObject(t);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

        } catch (Exception e) {
            e.printStackTrace(out);
        }

        try (ObjectInputStream is = new ObjectInputStream(
                new BufferedInputStream(new FileInputStream(FILE)))) {
            while (true) {
                Object object = is.readObject();
                if (object instanceof Person)
                    out.println(object);
            }

        } catch (EOFException eof) {
        } catch (Exception e) {
            e.printStackTrace(out);
        }
    }

    public static class Person implements Serializable {

        /**
         * 
         */
        private static final long serialVersionUID = 3119908037394098060L;

        private int age;
        private String name;
        private transient String myTransient;

        public Person() {
            age = 1;
            name = "Person";
            myTransient = "Not Saved";
        }

        public Person(int age, String name, String myTransient) {
            this.age = age;
            this.name = name;
            this.myTransient = myTransient;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getMyTransient() {
            return myTransient;
        }

        public void setMyTransient(String myTransient) {
            this.myTransient = myTransient;
        }

        @Override
        public String toString() {
            return "Person [age=" + age + ", name=" + name + ", myTransient="
                    + myTransient + "]";
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + age;
            result = prime * result + ((name == null) ? 0 : name.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Person other = (Person) obj;
            if (age != other.age)
                return false;
            if (name == null) {
                if (other.name != null)
                    return false;
            } else if (!name.equals(other.name))
                return false;
            return true;
        }

    }
}
