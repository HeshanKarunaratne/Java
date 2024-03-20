package dsa.oned_dp;

/**
 * @author Heshan Karunaratne
 */
public class HouseRobber {

    public static int rob(int[] nums) {
        if (nums.length < 2) return nums[0];

        int totalLoot[] = new int[nums.length];
        totalLoot[0] = nums[0];
        totalLoot[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            totalLoot[i] = Math.max(totalLoot[i - 2] + nums[i], totalLoot[i - 1]);
        }
        return totalLoot[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 3, 1, 4, 2, 1, 8};
        int rob = rob(nums);
        System.out.println(rob);
    }
}
