package hackerrankquestions;

import java.util.List;

/**
 * @author Heshan Karunaratne
 */
public class BetweenTwoSets {

    public static void main(String[] args) {

        List<Integer> a = List.of(2, 4);
        List<Integer> b = List.of(16, 32, 96);
        System.out.println(getCount(a, b));

    }

    public static int getCount(List<Integer> a, List<Integer> b) {
        int count = 0;

        int lcm = a.get(0);
        for (Integer integer : a) {
            lcm = getLCM(lcm, integer);
        }

        int gcd = b.get(0);
        for (Integer integer : b) {
            gcd = getGCD(gcd, integer);
        }

        int val = lcm;
        while (val <= gcd) {

            if (gcd % val == 0) {
                count++;
            }
            val += lcm;
        }

        return count;
    }

    static int getLCM(int n1, int n2) {
        if (n1 == 0 || n2 == 0)
            return 0;
        else {
            int gcd = getGCD(n1, n2);
            return Math.abs(n1 * n2) / gcd;
        }
    }

    static int getGCD(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }
        int n3 = n1 % n2;
        return getGCD(n2, n3);
    }


}
