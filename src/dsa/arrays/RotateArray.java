package dsa.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
189. Rotate Array

Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

Example 1:
Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]

Example 2:
Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation:
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]

 */

/**
 * @author Heshan Karunaratne
 */
public class RotateArray {

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        int n = arr.length;
        int k = 2;
        k = k % n;

        reverse(arr, 0, n - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, n - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start <= end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}

/*
nums=[1, 2, 3, 4, 5, 6, 7]  k=2
nums=[7, 6, 5, 4, 3, 2, 1]  rotate(0, n-1)
nums=[6, 7, 5, 4, 3, 2, 1]  rotate(0, k-1)
nums=[6, 7, 1, 2, 3, 4, 5]  rotate(k, n-1)
 */