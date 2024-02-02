package dsa.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heshan Karunaratne
 */
public class Permutations {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        backTrack(resultList, new ArrayList<>(), nums);
        return resultList;
    }

    private static void backTrack(List<List<Integer>> resultList, ArrayList<Integer> tempList, int[] nums) {

        if (tempList.size() == nums.length) {
            resultList.add(new ArrayList<>(tempList));
            return;
        }

        for (int num : nums) {
            if (tempList.contains(num)) {
                continue;
            }

            tempList.add(num);
            backTrack(resultList, tempList, nums);

            tempList.remove(tempList.size() - 1);
        }

    }

    public static void main(String[] args) {
        int[] arr = {1, 2};
        System.out.println(permute(arr));
    }
}
