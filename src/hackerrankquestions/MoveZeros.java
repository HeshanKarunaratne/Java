package hackerrankquestions;

import java.util.Arrays;

/**
 * @author Heshan Karunaratne
 */
public class MoveZeros {
    public static void moveZeroes(int[] nums) {

        int position = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[position] = nums[i];
                position++;
            }
        }

        while (position < nums.length) {
            nums[position++] = 0;
        }

        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        int arr[] = {0, 1, 5, 0, 12, 0, 9};
        moveZeroes(arr);
    }
}
