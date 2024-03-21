package dsa.sliding_window;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Heshan Karunaratne
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {

//        String s = "abcabcbb";
//        String s= "bbbbb";
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {

        int maxLength = 0;
        Set<Character> set = new HashSet<>();

        int a_pointer = 0;
        int b_pointer = 0;

        while (b_pointer < s.length()) {
            if (!set.contains(s.charAt(b_pointer))) {
                set.add(s.charAt(b_pointer));
                b_pointer++;
                maxLength = Math.max(maxLength, set.size());
            } else {
                set.remove(s.charAt(a_pointer));
                a_pointer++;
            }
        }
        return maxLength;
    }
}
