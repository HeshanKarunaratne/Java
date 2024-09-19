package dsa.arrays;

/*
28. Find the Index of the First Occurrence in a String

Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:
Input: haystack = "sadbutsad", needle = "sad"
Output: 0
Explanation: "sad" occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.

Example 2:
Input: haystack = "leetcode", needle = "leeto"
Output: -1
Explanation: "leeto" did not occur in "leetcode", so we return -1.
 */

/**
 * @author Heshan Karunaratne
 */
public class FindIndexOfFirstOccurrenceInAString {

    public static void main(String[] args) {
        String hayStack = "sadbutsad";
        String needle = "but";
        System.out.println(strStr(hayStack, needle));
    }

    public static int strStr(String haystack, String needle) {
        int index = -1;
        if (!haystack.contains(needle)) return index;

        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                String val = haystack.substring(i, i + needle.length());
                if (val.equals(needle)) {
                    index = i;
                    return index;
                }
            }
        }
        return index;
    }
}

/*
i should only go from 0 till as mentioned below
int i = 0; i < haystack.length() - needle.length() + 1; i++

if there is a possible match with chars then need to substring the word with the correct length and need to check whether it matches the original needle value
 */