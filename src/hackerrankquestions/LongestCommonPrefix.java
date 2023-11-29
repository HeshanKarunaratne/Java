package hackerrankquestions;

import java.util.Arrays;

/**
 * @author Heshan Karunaratne
 */
public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String prefix = "";
        for (int i = 0; i < strs[0].length(); i++) {

            if (strs[0].charAt(i) == strs[strs.length - 1].charAt(i)) {
                prefix = prefix + strs[0].charAt(i);
            } else {
                return prefix;
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        String[] arr = {"c"};
        System.out.println(longestCommonPrefix(arr));
    }
}
