package hackerrankquestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Heshan Karunaratne
 */
public class Subsets2 {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> resultList = new ArrayList<>();
        backTrack(resultList, new ArrayList<>(), nums, 0);
        return resultList;
    }

    private static void backTrack(List<List<Integer>> resultList, List<Integer> tempSet, int[] nums, int start) {
        if(!resultList.contains(tempSet)){
            resultList.add(new ArrayList<>(tempSet));
        }
        for (int i = start; i < nums.length; i++) {
            tempSet.add(nums[i]);
            backTrack(resultList, tempSet, nums, i + 1);
            tempSet.remove(tempSet.size() - 1);
        }

    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        System.out.println(subsetsWithDup(nums));
    }
}
