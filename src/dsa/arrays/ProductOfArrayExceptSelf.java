package dsa.arrays;

import java.util.Arrays;

/*
238. Product of Array Except Self

Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
You must write an algorithm that runs in O(n) time and without using the division operation.

Example 1:
Input: nums = [1,2,3,4]
Output: [24,12,8,6]

Example 2:
Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]

 */

/**
 * @author Heshan Karunaratne
 */
public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4};
        int[] output = productExceptSelfV2(arr);
        System.out.println(Arrays.toString(output));
    }

    public static int[] productExceptSelf(int[] nums) {

        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        left[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        right[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = left[i] * right[i];
        }
        return nums;
    }

    public static int[] productExceptSelfV2(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        Arrays.fill(ans, 1);
        int curr = 1;
        for (int i = 0; i < n; i++) {
            ans[i] *= curr;
            curr *= nums[i];
        }
        curr = 1;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] *= curr;
            curr *= nums[i];
        }
        return ans;
    }
}

/*

Left     = [ 1,  1, 2, 6]
                 -------> left[i] = left[i-1] * nums[i-1]
Right    = [24, 12, 4, 1]
            <-------- right[i] = right[i+1] * nums[i+1]
Multiply = [24, 12, 8, 6]

*/