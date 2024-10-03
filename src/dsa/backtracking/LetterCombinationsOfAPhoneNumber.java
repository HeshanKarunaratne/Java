package dsa.backtracking;

import java.util.ArrayList;
import java.util.List;

/*
17. Letter Combinations of a Phone Number

Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Example 1:
Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

Example 2:
Input: digits = ""
Output: []

Example 3:
Input: digits = "2"
Output: ["a","b","c"]
 */

/**
 * @author Heshan Karunaratne
 */
public class LetterCombinationsOfAPhoneNumber {
    static List<String> result = null;
    static String[] mapping = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static void main(String[] args) {
        List<String> output = letterCombinations("23");
        System.out.println(output);
    }

    private static List<String> letterCombinations(String digits) {
        result = new ArrayList<>();
        if (digits.length() == 0) return result;
        dfs(0, digits, new StringBuilder());
        return result;
    }

    private static void dfs(int length, String digits, StringBuilder temp) {
        if (length == digits.length()) {
            result.add(temp.toString());
            return;
        }
        char ch = digits.charAt(length);
        String s = mapping[ch - '0'];
        for (char c : s.toCharArray()) {
            temp.append(c);
            dfs(length + 1, digits, temp);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}

/*
Base Case - length should equal to the length of the digits
 */