package dsa.arrays;

import java.util.HashMap;
import java.util.Map;

/*
169. Majority Element

Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

Example 1:
Input: nums = [3,2,3]
Output: 3

Example 2:
Input: nums = [2,2,1,1,1,2,2]
Output: 2
 */

/**
 * @author Heshan Karunaratne
 */
public class MajorityElement {

    public static void main(String[] args) {

        int nums[] = {2, 2, 1, 1, 1, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3};
        System.out.println(majorityElement(nums));
        System.out.println(majorityElementV2(nums));
    }

    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int max = Integer.MIN_VALUE;
        int maxItem = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> item : map.entrySet()) {
            if (item.getValue() > max) {
                max = item.getValue();
                maxItem = item.getKey();
            }
        }
        return maxItem;
    }

    public static int majorityElementV2(int[] nums) {
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if (count == 0) candidate = num;
            if (num == candidate) count++;
            else count--;
        }
        return candidate;
    }
}

/*
Moore Voting Algorithm

Initialize two variables: count and candidate. Set count to 0 and candidate to an arbitrary value.
Iterate through the array nums:
a. If count is 0, assign the current element as the new candidate and increment count by 1.
b. If the current element is the same as the candidate, increment count by 1.
c. If the current element is different from the candidate, decrement count by 1.
After the iteration, the candidate variable will hold the majority element.
 */