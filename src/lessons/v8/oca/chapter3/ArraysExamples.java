package lessons.v8.oca.chapter3;
import java.util.Arrays;

public class ArraysExamples {
    public static void main(String[] args) {
        // 1. One-dimensional array
        System.out.println("1. One-dimensional array:");
        int[] oneDimArray = {10, 20, 30, 40, 50};
        System.out.println("Array: " + Arrays.toString(oneDimArray)); // Printing array
        System.out.println("Element at index 2: " + oneDimArray[2]); // Accessing element at index 2
        oneDimArray[2] = 100; // Modifying an element
        System.out.println("Modified Array: " + Arrays.toString(oneDimArray));

        // 2. Sorting the array
        Arrays.sort(oneDimArray);
        System.out.println("Sorted Array: " + Arrays.toString(oneDimArray));

        // 3. Multi-dimensional array (2D array)
        System.out.println("\n2. Two-dimensional array:");
        int[][] twoDimArray = {
          {1, 2, 3},
          {4, 5, 6},
          {7, 8, 9}
        };
        System.out.println("2D Array:");
        for (int i = 0; i < twoDimArray.length; i++) {
            System.out.println(Arrays.toString(twoDimArray[i])); // Printing each row of 2D array
        }

        // Accessing an element in a 2D array
        System.out.println("Element at row 1, column 2: " + twoDimArray[1][2]);

        // 4. Jagged array (Array of arrays with different lengths)
        System.out.println("\n3. Jagged array (Array of arrays with different lengths):");
        int[][] jaggedArray = {
          {1, 2},
          {3, 4, 5},
          {6, 7, 8, 9}
        };
        System.out.println("Jagged Array:");
        for (int i = 0; i < jaggedArray.length; i++) {
            System.out.println(Arrays.toString(jaggedArray[i])); // Printing each row of jagged array
        }

        // 5. Array of Strings
        System.out.println("\n4. Array of Strings:");
        String[] strArray = {"Java", "Python", "C++", "JavaScript"};
        System.out.println("String Array: " + Arrays.toString(strArray));

        // Searching for an element in the array
        int index = Arrays.binarySearch(strArray, "Java");
        System.out.println("Index of 'Java' in String Array: " + index); // Searching for "Java" in sorted array

        // 6. Multi-dimensional array with different types (Object Array)
        System.out.println("\n5. Object Array (with different types):");
        Object[] mixedArray = {10, "Hello", 3.14, true};
        System.out.println("Mixed Array: " + Arrays.toString(mixedArray));

        // 7. Array copying
        System.out.println("\n6. Array copying:");
        int[] copyArray = Arrays.copyOf(oneDimArray, oneDimArray.length); // Copy of array
        System.out.println("Original Array: " + Arrays.toString(oneDimArray));
        System.out.println("Copied Array: " + Arrays.toString(copyArray));

        // 8. Array initialization using the 'new' keyword
        System.out.println("\n7. Array Initialization using 'new' keyword:");
        int[] newArray = new int[5]; // Declare and initialize an array of size 5
        System.out.println("New Array (initialized with default values): " + Arrays.toString(newArray));

        // 9. Filling an array with a specific value
        System.out.println("\n8. Filling an array with a specific value:");
        Arrays.fill(newArray, 7); // Fill array with the value 7
        System.out.println("New Array after filling with 7: " + Arrays.toString(newArray));

        // 10. Array equality comparison
        System.out.println("\n9. Array equality comparison:");
        int[] anotherArray = {7, 7, 7, 7, 7};
        boolean areEqual = Arrays.equals(newArray, anotherArray);
        System.out.println("Are the arrays equal? " + areEqual);
    }
}
