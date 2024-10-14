package dsa.oned_dp;

import java.util.Arrays;

/*
300. Longest Increasing Subsequence

Given an integer array nums, return the length of the longest strictly increasing
subsequence

Example 1:
Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.

Example 2:
Input: nums = [0,1,0,3,2,3]
Output: 4

Example 3:
Input: nums = [7,7,7,7,7,7,7]
Output: 1

 */

/**
 * @author Heshan Karunaratne
 */
public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 0, 6, 2, 3};
        int i = lengthOfLIS(nums);
        System.out.println(i);
    }

    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int[] arr = new int[nums.length];
        Arrays.fill(arr, 1);

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && arr[j] + 1 > arr[i]) {
                    arr[i] = arr[j] + 1;
                }
            }
        }

        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (arr[i] > arr[maxIndex]) {
                maxIndex = i;
            }
        }
        return arr[maxIndex];
    }

}

/*
Create an array arr where all the indexes contains 1 as the default value
Need to iterate Twice
i : 1 to nums.length
j : 0 to nums.length

Check below condition and update the whole arr
if (nums[i] > nums[j] && arr[j] + 1 > arr[i]) {
    arr[i] = arr[j] + 1;
}
 */