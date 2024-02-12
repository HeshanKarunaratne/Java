package dsa.sliding_window;

/**
 * @author Heshan Karunaratne
 */
public class MinimumSizeSubArraySum {

    public static void main(String[] args) {

        int target = 7;
        int nums[] = {2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen(target, nums));
    }

    public static int minSubArrayLen(int target, int[] nums) {

        int window = Integer.MAX_VALUE;
        int left = 0;
        int currSum = 0;

        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            while (currSum >= target) {
                window = Math.min(window, i + 1 - left);
                currSum -= nums[left];
                left++;
            }
        }
        return window == Integer.MAX_VALUE ? 0 : window;
    }
}
