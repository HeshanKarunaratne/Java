package dsa.arrays;

/**
 * @author Heshan Karunaratne
 */
public class RemoveDuplicatesFromSortedArray2 {

    public static void main(String[] args) {
//        int[] arr = {0,0,1,1,1,1,2,3,3};
        int[] arr = {-3, -1, 0, 0, 0, 3, 3};
        System.out.println(removeDuplicates(arr));
    }

    public static int removeDuplicates(int[] nums) {

        int count = 0;

        for (int num : nums) {
            if (count < 2 || num != nums[count - 2]) {
                nums[count++] = num;
            }
        }
        return count;
    }
}
