package lessons.v8.ocp.chapter3.generics.compare;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

import static java.lang.System.out;

public class ComparableExample implements Comparable<ComparableExample> {

    private String name;

    @Override
    public String toString() {
        return "ComparableExample [name=" + name + ", age=" + age + "]";
    }

    private int age;

    public ComparableExample(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(ComparableExample o) {
        return this.name.compareTo(o.name);
    }

    static class NonCompare {
        int val;

        public NonCompare(int i) {
            val = i;
        }

        @Override
        public String toString() {
            return Integer.toString(val);
        }
    }

    public static void main(String[] args) {

        Comparator<ComparableExample> comparator = (c1, c2) -> Comparator.comparing(ComparableExample::getName)
                .thenComparingInt(ComparableExample::getAge)
                .compare(c1, c2);
        ComparableExample c1 = new ComparableExample("John", 21);
        ComparableExample c2 = new ComparableExample("John", 22);
        ComparableExample c3 = new ComparableExample("John", 21);
        ComparableExample c4 = new ComparableExample("Johnny", 21);
        out.println(comparator.compare(c1, c2));
        out.println(comparator.compare(c1, c3));
        out.println(comparator.compare(c1, c4));
        TreeSet<ComparableExample> compareSet = new TreeSet<>(comparator);
        compareSet.add(c1);
        compareSet.add(c2);
        compareSet.add(c3);
        compareSet.add(c4);
        out.println(compareSet);
        Set<NonCompare> mySet = new TreeSet<>(Comparator.comparingInt(n -> n.val));
        mySet.add(new NonCompare(4));
        mySet.add(new NonCompare(1));
        mySet.add(new NonCompare(-1));
        out.print(mySet);
    }

}
