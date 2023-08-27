package theory;

/**
 * @author Heshan Karunaratne
 */
public class BitwiseShift {

    public static void main(String[] args) {

        /**
         * Bitwise Operators
         * AND Operator: &
         * OR Operator: |
         * XOR Operator: ^
         * NOT Operator: ~
         * Left Shift Operator: <<
         * Right Shift Operator: >>
         *
         * r: read, w: write, e: execute
         * 7 - 111 (rwe)
         * 6 - 110 (rw)
         * 4 - 100 (r)
         */

        int a = 60; // 111100
        System.out.println(Integer.toBinaryString(a));
        System.out.println();

        int c = a << 2; // 11110000 : added 2 0's to the end
        System.out.println(c);
        System.out.println(Integer.toBinaryString(c));
        System.out.println();

        int d = a >> 2; // 1111 : removed 2 0's from the end
        System.out.println(d);
        System.out.println(Integer.toBinaryString(d));
        System.out.println();

        int e = a >>> 2;
        System.out.println(e);
        System.out.println(Integer.toBinaryString(e));
        System.out.println();
    }
}
