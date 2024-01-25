package dsa.arrays;

import java.util.Arrays;

/**
 * @author Heshan Karunaratne
 */
public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        StringBuilder prefix = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {

            if (strs[0].charAt(i) == strs[strs.length - 1].charAt(i)) {
                prefix = prefix.append(strs[0].charAt(i));
            } else {
                return prefix.toString();
            }
        }
        return prefix.toString();
    }

    public static void main(String[] args) {
//        String[] arr = {"dog", "racecar", "car"};
        String[] arr = {"flower","flow","flight"};
//        String[] arr = {"dog", "racecar", "car"};
        System.out.println(longestCommonPrefix(arr));
    }
}
