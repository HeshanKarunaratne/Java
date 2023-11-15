package hackerrankquestions;

import java.util.Arrays;

/**
 * @author Heshan Karunaratne
 */
public class NumbersSmallerThanCurrentNumber {

    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int buckets[] = new int[102];

        for (int num : nums) {
            buckets[num]++;
        }

        for (int i = 1; i < buckets.length; i++) {
            buckets[i] += buckets[i - 1];
        }

        int result[] = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                result[i] = 0;
            } else {
                result[i] = buckets[nums[i] - 1];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int arr[] = {8, 1, 2, 2, 3};
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(arr)));
    }
}
