package dsa.arrays;

import java.util.Arrays;

/**
 * @author Heshan Karunaratne
 */
public class MergeSortedArray {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1};
        int[] nums2 = new int[]{};
        int m = 1;
        int n = 0;

        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
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
