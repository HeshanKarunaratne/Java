package dsa.arrays;


/**
 * @author Heshan Karunaratne
 */
public class JumpGame {

    public static void main(String[] args) {
//        int[] nums = {2, 3, 1, 1, 4};
        int[] nums = {3, 2, 1, 0, 4};
        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {
        int pointer = nums.length - 1;

        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= pointer) {
                pointer = i;
            }
        }
        return pointer == 0;
    }
}
