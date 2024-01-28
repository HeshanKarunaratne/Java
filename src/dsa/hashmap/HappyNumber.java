package dsa.hashmap;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Heshan Karunaratne
 */
public class HappyNumber {

    public static void main(String[] args) {
        int num = 62;
//        int num = 2;
        System.out.println(isHappy(num));
    }

    public static boolean isHappy(int n) {
        if (n <= 0) return false;
        Set<Integer> set = new HashSet<>();
        return isHappy(n, set);
    }

    public static boolean isHappy(int n, Set<Integer> set) {

        if (n == 1) return true;

        int sum = getSum(n);
        if(set.contains(sum)) return false;
        set.add(sum);
        return isHappy(sum,set);
    }

    private static int getSum(int n) {
        String s = String.valueOf(n);
        int length = s.length();
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += Math.pow(Integer.parseInt(String.valueOf(s.charAt(i))), 2);
        }
        return sum;
    }


}
