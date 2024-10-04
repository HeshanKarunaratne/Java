package dsa.backtracking;

import java.util.ArrayList;
import java.util.List;

/*
46. Permutations

Given an array nums of distinct integers, return all the possible
permutations
. You can return the answer in any order.

Example 1:
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

Example 2:
Input: nums = [0,1]
Output: [[0,1],[1,0]]

Example 3:
Input: nums = [1]
Output: [[1]]
 */

/**
 * @author Heshan Karunaratne
 */
public class Permutations {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(permute(arr));
    }

    private static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        backTrack(results, new ArrayList<>(), nums);
        return results;
    }

    private static void backTrack(List<List<Integer>> results, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            results.add(new ArrayList<>(tempList));
        }
        for (int num : nums) {
            if (tempList.contains(num)) {
                continue;
            }
            tempList.add(num);
            backTrack(results, tempList, nums);
            tempList.remove(tempList.size() - 1);
        }
    }
}

/*
Base Case: If the tempList size is equal to the nums.length

inside a loop check If the tempList already contains the same value -> continue
 */