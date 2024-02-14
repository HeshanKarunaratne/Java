package dsa.sliding_window;

/**
 * @author Heshan Karunaratne
 */
public class MinimumWindowSubstring {

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }

    public static String minWindow(String s, String t) {

        if (s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length()) return "";

        int[] letterCount = new int[128];
        int count = t.length();

        int left = 0, right = 0, minLen = Integer.MAX_VALUE, startIndex = 0;
        for (char c : t.toCharArray())
            letterCount[c]++;

        for (right = 0; right < s.length(); ) {
            if (letterCount[s.charAt(right)]-- > 0) {
                count--;
            }
            right++;
            while (count == 0) {
                if (right - left < minLen) {
                    startIndex = left;
                    minLen = right - left;
                }
                if (letterCount[s.charAt(left)]++ == 0) {
                    count++;
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + minLen);
    }

}
