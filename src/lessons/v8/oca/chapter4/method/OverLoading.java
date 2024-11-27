package lessons.v8.oca.chapter4.method;

import java.util.Arrays;

public class OverLoading {
    int add(int a, int b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }

    public double add(double a, double b) {
        return a + b;
    }

    protected int add(int...i){
        return Arrays.stream(i).reduce((x,y)-> x+y).orElse(0);
    }

    public static void main(String[] args) {
        OverLoading calc = new OverLoading();

        // Call the method with two integers
        System.out.println("Sum of 2 integers: " + calc.add(5, 10)); // Output: 15

        // Call the method with three integers
        System.out.println("Sum of 3 integers: " + calc.add(5, 10, 20)); // Output: 35

        // Call the method with two doubles
        System.out.println("Sum of 2 doubles: " + calc.add(5.5, 10.5)); // Output: 16.0
        // Call the method with two doubles
        System.out.println("Sum of no int: " + calc.add()); // Output: 0
        System.out.println("Sum of vargs int: " + calc.add(1,2,3,4,5,6,7,8,9,10)); // Output: 55

    }
}
