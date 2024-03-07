package dsa.bit_manipulation;

/**
 * @author Heshan Karunaratne
 */
public class BitwiseAndOfNumbersRange {

    public static int rangeBitwiseAnd(int left, int right) {
        int count = 0;

        while (left != right) {
            left >>= 1;
            right >>= 1;
            count++;
        }
        left <<= count;
        return left;
    }

    public static void main(String[] args) {
        int left = 5, right = 7;
        int i = rangeBitwiseAnd(left, right);
        System.out.println(i);
    }
}
