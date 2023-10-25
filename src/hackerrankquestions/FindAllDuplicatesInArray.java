package hackerrankquestions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heshan Karunaratne
 */
public class FindAllDuplicatesInArray {

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 7, 8, 2, 3, 1};
        final List<Integer> duplicates = findDuplicates(arr);
        System.out.println(duplicates);
    }

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            int index = Math.abs(nums[i]);
            int indexToCheck = index - 1;

            if (nums[indexToCheck] > 0) {
                nums[indexToCheck] = nums[indexToCheck] * -1;
            } else {
                list.add(indexToCheck + 1);
            }

        }
        return list;

    }
}
