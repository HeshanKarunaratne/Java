package dsa.kadanes_algorithm;

/**
 * @author Heshan Karunaratne
 */
public class MaximumSumCircularSubArray {

    public static int maxSubArraySumCircular(int[] nums) {

        int maxSum = nums[0], minSum = nums[0], curMax = 0, curMin = 0;
        int totalSum = 0;
        for (int num : nums) {
            curMax = Math.max(curMax + num, num);
            maxSum = Math.max(maxSum, curMax);
            curMin = Math.min(curMin + num, num);
            minSum = Math.min(minSum, curMin);
            totalSum += num;
        }
        return maxSum > 0 ? Math.max(maxSum, totalSum - minSum) : maxSum;
    }

    public static void main(String[] args) {
        int[] num = {5, -3, 5};
        int i = maxSubArraySumCircular(num);
        System.out.println(i);
    }
}
