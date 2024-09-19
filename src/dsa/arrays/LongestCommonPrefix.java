package dsa.arrays;

import java.util.Arrays;

/*
14. Longest Common Prefix

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:
Input: strs = ["flower","flow","flight"]
Output: "fl"

Example 2:
Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.

 */

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
        String[] arr = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(arr));
    }
}

/*
Sort the array and check the characters of the first and the last words in the list. You can identify the common prefix of the words
 */