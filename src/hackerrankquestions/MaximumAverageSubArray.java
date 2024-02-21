package hackerrankquestions;

/**
 * @author Heshan Karunaratne
 */
public class MaximumAverageSubArray {

    public static void main(String[] args) {
//        int[] arr = {1, 12, -5, -6, 50, 3};
        int[] arr = {5};
        System.out.println(findMaxAverage(arr, 1));
    }

    public static double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int maxSum = sum;

        int startIndex = 0;
        int endIndex = k;

        while (endIndex < nums.length) {

            sum -= nums[startIndex++];
            sum += nums[endIndex++];
            maxSum = Math.max(maxSum, sum);
        }

        return (double) maxSum / k;
    }
}
