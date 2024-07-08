package dsa.arrays;

import java.util.Arrays;

/*
88. Merge Sorted Array

You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

Example 1:
Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.

Example 2:
Input: nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]
Explanation: The arrays we are merging are [1] and [].
The result of the merge is [1].

Example 3:
Input: nums1 = [0], m = 0, nums2 = [1], n = 1
Output: [1]
Explanation: The arrays we are merging are [] and [1].
The result of the merge is [1].
Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
 */

/**
 * @author Heshan Karunaratne
 */
public class MergeSortedArray {

    public static void main(String[] args) {
        //arrays are already sorted in non-decreasing manner
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        int m = 3;
        int n = 3;

        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        //p1: reference to last index of sorted positions in nums1(not including 0s)
        //p2: reference to last index of nums2
        int p1 = m - 1, p2 = n - 1, i = m + n - 1;
        while (p2 >= 0) {
            if (p1 >= 0 && nums1[p1] < nums2[p2]) {
                nums1[i--] = nums2[p2--];
            } else {
                nums1[i--] = nums1[p1--];
            }
        }
    }
}

/*
nums1=[1, 2, 3, 0, 0, 0]  p1=2  p2=2  i=5
nums1=[1, 2, 3, 0, 0, 6]  p1=2  p2=1  i=4
nums1=[1, 2, 3, 0, 5, 6]  p1=2  p2=0  i=3
nums1=[1, 2, 3, 3, 5, 6]  p1=1  p2=0  i=2
nums1=[1, 2, 2, 3, 5, 6]  p1=0  p2=0  i=1
nums1=[1, 2, 2, 3, 5, 6]  p1=0  p2=-1  i=0
 */