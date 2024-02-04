package dsa.math;

/**
 * @author Heshan Karunaratne
 */
public class FactorialTrailingZeroes {

    public static void main(String[] args) {
        System.out.println(trailingZeroes(10));
    }

    public static int trailingZeroes(int n) {
        int count = 0;
        while (n > 0) {
            n /= 5;
            count += n;
        }
        return count;
    }

}
