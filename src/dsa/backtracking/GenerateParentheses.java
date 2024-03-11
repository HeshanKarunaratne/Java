package dsa.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heshan Karunaratne
 */
public class GenerateParentheses {
    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();

        if (n < 1) return list;
        backTrack(n, 0, 0, list, "");
        return list;
    }

    private static void backTrack(int n, int open, int close, List<String> list, String s) {
        if (s.length() == 2 * n) {
            list.add(s);
        }

        if (open < n) {
            backTrack(n, open + 1, close, list, s + "(");
        }

        if (close < open) {
            backTrack(n, open, close + 1, list, s + ")");
        }
    }

    public static void main(String[] args) {
        List<String> output = generateParenthesis(3);
        System.out.println(output);
    }
}
