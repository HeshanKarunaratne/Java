package dsa.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Heshan Karunaratne
 */
public class SummaryRanges {


    public static void main(String[] args) {
        int arr[] = {0, 1, 2, 4, 5, 7};
        System.out.println(summaryRanges(arr));
    }

    public static List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) return new ArrayList<>();
        if (nums.length == 1) return List.of(String.valueOf(nums[0]));

        List<String> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int start = nums[i];
            while (i < (nums.length - 1) && nums[i + 1] == nums[i] + 1)
                i++;

            if (start != nums[i]) {
                list.add("" + start + "->" + nums[i]);
            } else {
                list.add("" + start);
            }
        }
        return list;
    }
}
