package hackerrankquestions;

/**
 * @author Heshan Karunaratne
 */
public class RotatedSortedArray {

    public static void main(String[] args) {
        int target = 1;
        int[] arr = {8, 9, 10, 11, 0, 1, 2, 3, 4, 5, 6, 7};
        System.out.println(search(arr, target));
    }

    public static int search(int[] nums, int target) {
        int index = modifiedBinarySearch(nums, target, 0, nums.length - 1);
        return index;
    }

    public static int modifiedBinarySearch(int[] nums, int target, int left, int right) {

        /**
         *  8, 9, 10, 11, 0, 1, 2, 3, 4, 5, 6, 7
         *  0                5                 11
         */

        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;

        if (nums[mid] == target) {
            return mid;
        }

        if (nums[mid] >= nums[left]) {
            //left half is sorted
            if (nums[left] <= target && target <= nums[mid])
                return modifiedBinarySearch(nums, target, left, mid - 1);
            else
                return modifiedBinarySearch(nums, target, mid + 1, right);


        } else {
            //right half is sorted
            if (nums[mid] <= target && target <= nums[right])
                return modifiedBinarySearch(nums, target, mid + 1, right);
            else
                return modifiedBinarySearch(nums, target, left, mid - 1);
        }

    }
}
