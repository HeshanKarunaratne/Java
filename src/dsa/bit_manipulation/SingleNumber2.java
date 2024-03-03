package dsa.bit_manipulation;

/**
 * @author Heshan Karunaratne
 */
public class SingleNumber2 {

    public static int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for (int num : nums) {
            ones = (ones ^ num) & (~twos);
            twos = (twos ^ num) & (~ones);
        }
        return ones;
    }

    public static void main(String[] args) {
//        int[] nums = {0, 1, 0, 1, 0, 1, 99};
        int[] nums = {1, 1, 1,99};
        int i = singleNumber(nums);
        System.out.println(i);
    }
}
