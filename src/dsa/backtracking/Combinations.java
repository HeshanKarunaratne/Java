package dsa.backtracking;

import java.util.LinkedList;
import java.util.List;

/*
77. Combinations

Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
You may return the answer in any order.

Example 1:
Input: n = 4, k = 2
Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
Explanation: There are 4 choose 2 = 6 total combinations.
Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.

Example 2:
Input: n = 1, k = 1
Output: [[1]]
Explanation: There is 1 choose 1 = 1 total combination.
 */

/**
 * @author Heshan Karunaratne
 */
public class Combinations {

    public static void main(String[] args) {
        int n = 4, k = 2;
        List<List<Integer>> combine = combine(n, k);
        System.out.println(combine);
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new LinkedList<>();
        if (k == 0) {
            ans.add(new LinkedList<>());
            return ans;
        }
        backTrack(1, new LinkedList<>(), k, n, ans);
        return ans;
    }

    private static void backTrack(int start, LinkedList<Integer> current, int k, int n, List<List<Integer>> ans) {
        if (current.size() == k) {
            ans.add(new LinkedList<>(current));
        }
        for (int i = start; i <= n && current.size() < k; i++) {
            current.add(i);
            backTrack(i + 1, current, k, n, ans);
            current.removeLast();
        }
    }
}

/*
We are using a LinkedList so that we can remove from the end

Base case - If the current size == k then add it to a list and append to the ans
For loop uses below statements
int i = start; i <= n && current.size() < k; i++
since the size of the current is less than k, we can add more inside the for loop
 */