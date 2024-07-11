package dsa.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Heshan Karunaratne
 */
public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(arr));
    }

    public static int removeDuplicates(int[] nums) {

        int counter = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.add(nums[i]))
                nums[counter++] = nums[i];
        }
        return counter;
    }
}
