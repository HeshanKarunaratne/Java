package hackerrankquestions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Heshan Karunaratne
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 7, 3};
        final int[] brr = twoSum(arr, 10);
        Arrays.toString(brr);
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("Invalid arguments");

    }
}
