package hackerrankquestions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heshan Karunaratne
 */
public class Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        backTrack(resultList, new ArrayList<>(), nums, 0);
        return resultList;
    }

    private static void backTrack(List<List<Integer>> resultList, List<Integer> tempSet, int[] nums, int start) {
        resultList.add(new ArrayList<>(tempSet));
        for (int i = start; i < nums.length; i++) {
            tempSet.add(nums[i]);
            backTrack(resultList, tempSet, nums, i + 1);
            tempSet.remove(tempSet.size() - 1);
        }

    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums));
    }
}
