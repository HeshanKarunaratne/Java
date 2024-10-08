package dsa.backtracking;

import java.util.ArrayList;
import java.util.List;

/*
39. Combination Sum

Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the
frequency
 of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

Example 1:
Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.

Example 2:
Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]

Example 3:
Input: candidates = [2], target = 1
Output: []
 */

/**
 * @author Heshan Karunaratne
 */
public class CombinationSum {

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> lists = combinationSum(candidates, target);
        System.out.println(lists);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, candidates, target, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int index, int[] candidates, int target, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
        }

        for (int j = index; j < candidates.length; j++) {
            if (candidates[j] > target) continue;

            current.add(candidates[j]);
            backtrack(j, candidates, target - candidates[j], current, result);
            current.remove(current.size() - 1);
        }
    }
}

/*
Base Case - if the target is == 0 then add it to the result

Since the same value can be added over and over check whether if that value is not exceeding target value
If its exceeding can move to next j in iteration
 */