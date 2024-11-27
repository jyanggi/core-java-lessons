package lessons.v8.oca.assessment;

public class Question2 {

    /**
     * How many times is true printed
     *
     * */
    public static void main(String[] args) {
        String s1 = "Java";
        String s2 = "Java";
        String s3 = new String("Java");
        StringBuilder sb1 = new StringBuilder();
        sb1.append("Ja").append("va");
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1.equals(s2));
        System.out.println(sb1.toString() == s1);
        System.out.println(sb1.toString().equals(s1));
    }

}
