package theory;

import java.math.BigInteger;

/**
 * @author Heshan Karunaratne
 */
public class BigIntegerDemo {

    public static void main(String[] args) {
        int num = 25;

        BigInteger bigFactorial = bigFactorial(num);
        System.out.println(bigFactorial);
    }

    private static BigInteger bigFactorial(int n) {
        if (n == 0) return BigInteger.valueOf(1);
        return bigFactorial(n - 1).multiply(BigInteger.valueOf(n));
    }
}
