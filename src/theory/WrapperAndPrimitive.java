package theory;

/**
 * @author Heshan Karunaratne
 */
public class WrapperAndPrimitive {
    public static void main(String[] args) {
        long timeA = System.currentTimeMillis();
        Long a = calculate();
        long timeB = System.currentTimeMillis();
        System.out.println(a);
        System.out.println(timeB-timeA + "ms");
    }

    private static Long calculate() {
//        Use primitive rather than the wrapper class itself
        long sum = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE; i++) {
            sum += i;
        }
        return sum;
    }
}
