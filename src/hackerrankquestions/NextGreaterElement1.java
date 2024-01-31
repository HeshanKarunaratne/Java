package hackerrankquestions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author Heshan Karunaratne
 */
public class NextGreaterElement1 {


    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        int[] output = nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(output));
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {

        if (nums2.length == 0 || nums1.length == 0)
            return new int[0];

        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        stack.push(nums2[nums2.length - 1]);
        map.put(nums2[nums2.length - 1], -1);

        for (int i = nums2.length - 2; i >= 0; i--) {

            if (nums2[i] < stack.peek()) {
                map.put(nums2[i], stack.peek());
                stack.push(nums2[i]);
                continue;
            }

            while (!stack.isEmpty() && stack.peek() < nums2[i])
                stack.pop();

            if (stack.isEmpty()) {
                stack.push(nums2[i]);
                map.put(nums2[i], -1);
            } else {
                map.put(nums2[i], stack.peek());
                stack.push(nums2[i]);
            }
        }

        for (int i = 0; i < nums1.length; i++)
            nums1[i] = map.get(nums1[i]);

        return nums1;
    }
}
