package Theory;

import java.util.BitSet;

/**
 * @author Heshan Karunaratne
 */
public class BitSetTest {

    public static void main(String[] args) {
        BitSet b1 = new BitSet(3);
        BitSet b2 = new BitSet(3);

        b1.set(0, true);
        b1.set(1, false);
        b1.set(2, true);

        b2.set(0, true);
        b2.set(1, true);
        b2.set(2, false);

        System.out.println("B1 => " + b1);
        System.out.println("B2 => " + b2);
        System.out.println("************");

        b1.and(b2);
        System.out.println("B1 => " + b1);

        b1.or(b2);
        System.out.println("B1 => " + b1);

        b1.xor(b2);
        System.out.println("B1 => " + b1);

        b1.flip(0);
        b1.and(b2);
        System.out.println("B1 => " + b1);
    }
}
