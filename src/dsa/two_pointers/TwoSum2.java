package dsa.two_pointers;

/*
167. Two Sum II - Input Array Is Sorted

Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.

Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
The tests are generated such that there is exactly one solution. You may not use the same element twice.
Your solution must use only constant extra space.

Example 1:
Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].

Example 2:
Input: numbers = [2,3,4], target = 6
Output: [1,3]
Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].

Example 3:
Input: numbers = [-1,0], target = -1
Output: [1,2]
Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Heshan Karunaratne
 */
public class TwoSum2 {

    public static void main(String[] args) {
        int[] arr = {2, 3, 4};
        System.out.println(Arrays.toString(twoSum(arr, 6)));
        System.out.println(Arrays.toString(twoSumV2(arr, 6)));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i + 1};
            }
            map.put(nums[i], i + 1);
        }
        return new int[]{};
    }

    public static int[] twoSumV2(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{};

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int sum = nums[start] + nums[end];

            if (sum == target) {
                return new int[]{start + 1, end + 1};
            } else if (sum > target) {
                end--;
            } else {
                start++;
            }
        }
        return new int[]{};
    }
}

/*
Keep two pointers to the start and the end
If the sum of those pointers matches the target you found the indexes
Otherwise move the pointers to the left and right till the sum matches the target

 */