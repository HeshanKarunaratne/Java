package dsa.math;

import java.util.Arrays;

/**
 * @author Heshan Karunaratne
 */
public class PlusOne {


    public static void main(String[] args) {
        int[] arr = {9,8,9};
        int[] output = plusOne(arr);
        System.out.println(Arrays.toString(output));
    }

    public static int[] plusOne(int[] digits) {

        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        int[] newNumber = new int[digits.length + 1];
        newNumber[0] = 1;

        return newNumber;
    }
}
