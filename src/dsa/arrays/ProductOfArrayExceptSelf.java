package dsa.arrays;

import java.util.Arrays;

/**
 * @author Heshan Karunaratne
 */
public class ProductOfArrayExceptSelf {


    public static void main(String[] args) {

        int arr[] = {-1,1,0,-3,3};
        int[] output = productExceptSelf(arr);
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
}
