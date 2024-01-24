package dsa.arrays;

import java.util.Arrays;

/**
 * @author Heshan Karunaratne
 */
public class MergeSortedArray {

    public static void main(String[] args) {
//        int[] nums1 = new int[]{1, 2, 0, 0};
//        int[] nums2 = new int[]{2, 3};
//        int m = 2;
//        int n = 2;

//        int[] nums1 = new int[]{0};
//        int[] nums2 = new int[]{4};
//        int m = 0;
//        int n = 1;

//        int[] nums1 = new int[]{1, 0};
//        int[] nums2 = new int[]{2};
//        int m = 1;
//        int n = 1;

        int[] nums1 = new int[]{1};
        int[] nums2 = new int[]{};
        int m = 1;
        int n = 0;

        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int j = 0, i = m; j < n; j++) {
            nums1[i] = nums2[j];
            i++;
        }
        Arrays.sort(nums1);
    }
}
