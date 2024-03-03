package dsa.bit_manipulation;

/**
 * @author Heshan Karunaratne
 */
public class SingleNumber {

    public static int singleNumber(int[] nums) {
        int XOR = 0;
        for (int i = 0; i < nums.length; i++) {
            XOR = XOR ^ nums[i];
        }
        return XOR;
    }
}
