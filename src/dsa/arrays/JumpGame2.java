package dsa.arrays;

/**
 * @author Heshan Karunaratne
 */
public class JumpGame2 {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(jump(nums));
    }

    public static int jump(int[] nums) {

        if (nums.length == 1) return 0;

        int totalJumps = 0;
        int destination = nums.length - 1;
        int coverage = 0;
        int lastJumpIdx = 0;

        for (int i = 0; i < nums.length; i++) {
            coverage = Math.max(coverage, i + nums[i]);

            if (i == lastJumpIdx) {
                lastJumpIdx = coverage;
                totalJumps++;

                if (coverage >= destination) {
                    return totalJumps;
                }
            }
        }
        return totalJumps;
    }
}
