package dsa.bit_manipulation;

/**
 * @author Heshan Karunaratne
 */
public class NumberOf1Bits {
    public static int hammingWeight(int n) {
        int count = 0;
        int mask = 1;

        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                count++;
            }
            mask <<= 1;
        }
        return count;
    }

    public static int hammingWeight2(int n) {
        int count = 0;

        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 00000000000000000000000000001011;
        int i = hammingWeight(n);
        System.out.println(i);
        int i2 = hammingWeight2(n);
        System.out.println(i2);
    }
}
