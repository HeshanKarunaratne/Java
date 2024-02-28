package dsa.bit_manipulation;

/**
 * @author Heshan Karunaratne
 */
public class AddBinary {
    public static String addBinary(String a, String b) {
        StringBuilder finalStr = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0) {
            int sum = carry;

            if (i >= 0) sum += a.charAt(i) - '0';
            if (j >= 0) sum += b.charAt(j) - '0';
            finalStr.append(sum % 2);
            carry = sum / 2;

            i--;
            j--;
        }

        if (carry != 0) finalStr.append(carry);
        return finalStr.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary("11", "1"));
    }

}
