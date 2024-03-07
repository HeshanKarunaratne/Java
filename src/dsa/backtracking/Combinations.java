package dsa.backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Heshan Karunaratne
 */
public class Combinations {

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new LinkedList<>();
        if (k == 0) {
            ans.add(new LinkedList<>());
            return ans;
        }
        backTrack(1, new LinkedList<>(), n, k, ans);
        return ans;
    }

    public static void backTrack(int start, LinkedList<Integer> current, int n, int k, List<List<Integer>> ans) {
        if (current.size() == k) {
            ans.add(new LinkedList<>(current));
        }
        for (int i = start; i <= n && current.size() < k; i++) {
            current.add(i);
            backTrack(i + 1, current, n, k, ans);
            current.removeLast();
        }
    }


    public static void main(String[] args) {
        int n = 4, k = 2;
        List<List<Integer>> combine = combine(n, k);
        System.out.println(combine);
    }
}
