package lessons.v8.ocp.chapter3.collections;

import java.util.*;

public class LargestRectangle {

    public static long largestRectangle(List<Integer> heights) {
        Stack<Integer> stack = new Stack<>();
        long maxArea = 0;
        int n = heights.size();

        for (int i = 0; i <= n; i++) {
            int currentHeight = (i == n) ? 0 : heights.get(i);
            while (!stack.isEmpty() && currentHeight < heights.get(stack.peek())) {
                int height = heights.get(stack.pop());
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, (long) height * width);
            }
            stack.push(i);
        }

        return maxArea;
    }
    public static void main(String [] args){

        List<Integer> nums = List.of(1,2,3,4,5);
        var nums2 =List.of(1 ,3 ,5, 9, 11);
        var nums3 =List.of(11, 11, 10, 10, 10);

        System.out.println(largestRectangle(nums));
        System.out.println(largestRectangle(nums2));
        System.out.println(largestRectangle(nums3));


    }
}
