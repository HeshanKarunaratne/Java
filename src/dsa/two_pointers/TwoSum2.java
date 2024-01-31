package dsa.two_pointers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Heshan Karunaratne
 */
public class TwoSum2 {

    public static void main(String[] args) {
        int[] arr = {-1,0};
        int[] output = twoSum(arr, -1);
        System.out.println(Arrays.toString(output));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i + 1};
            }
            map.put(nums[i] , i + 1);
        }
        return new int[]{};
    }
}
