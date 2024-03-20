package dsa.oned_dp;

import java.util.Arrays;

/**
 * @author Heshan Karunaratne
 */
public class LongestIncreasingSubsequence {
    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int[] T = new int[nums.length];
        Arrays.fill(T, 1);

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && T[j] + 1 > T[i]) {
                    T[i] += 1;
                }
            }
        }
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (T[i] > T[maxIndex]) {
                maxIndex = i;
            }
        }
        return T[maxIndex];
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 0, 6, 2, 3};
        int i = lengthOfLIS(nums);
        System.out.println(i);
    }

}
