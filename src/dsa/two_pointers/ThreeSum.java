package dsa.two_pointers;

import java.util.*;

/**
 * @author Heshan Karunaratne
 */
public class ThreeSum {

    public static void main(String[] args) {
//        int[] nums = {-1, 0, 1, 2, -1, -4};
        int[] nums = {3, 0, -2, -1, 1, 2};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {

        if (nums == null || nums.length < 3) return new ArrayList<>();

        Arrays.sort(nums);
        Set<List<Integer>> results = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {

            int leftPointer = i + 1;
            int rightPointer = nums.length - 1;

            while (leftPointer < rightPointer) {
                int sum = nums[leftPointer] + nums[rightPointer] + nums[i];
                if (sum == 0) {
                    results.add(Arrays.asList(nums[i], nums[leftPointer], nums[rightPointer]));
                    leftPointer++;
                    rightPointer--;
                } else if (sum < 0) {
                    leftPointer++;
                } else {
                    rightPointer--;
                }
            }
        }
        return new ArrayList<>(results);
    }
}
