package dsa.bit_manipulation;

/**
 * @author Heshan Karunaratne
 */
public class ReverseBits {

    public static int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            if ((n & 1) > 0) result++;
            n >>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 00000000000000000000000000001011;
        int i = reverseBits(n);
        System.out.println(i);
    }
}
