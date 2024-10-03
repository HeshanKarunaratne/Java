package dsa.backtracking;

import java.util.ArrayList;
import java.util.List;

/*
22. Generate Parentheses

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

Example 1:
Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]

Example 2:
Input: n = 1
Output: ["()"]
 */

/**
 * @author Heshan Karunaratne
 */
public class GenerateParentheses {

    public static void main(String[] args) {
        List<String> output = generateParenthesis(3);
        System.out.println(output);
    }

    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        if (n < 1) return list;
        backTrack(n, 0, 0, list, "");
        return list;
    }

    private static void backTrack(int n, int open, int close, List<String> list, String current) {
        if (current.length() == 2 * n) {
            list.add(current);
        }
        if (open < n) {
            backTrack(n, open + 1, close, list, current + "(");
        }
        if (close < open) {
            backTrack(n, open, close + 1, list, current + ")");
        }
    }
}

/*
Base Case - The resulting string should have twice the characters, and if it equals then adding to the result list

Need to have two separate variables to take the count of open and closed brackets.
And conditions to check
1. (open < n) - add "(" to current
2. (close < n) - add ")" to current
 */