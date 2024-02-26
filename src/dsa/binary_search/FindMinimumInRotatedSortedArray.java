package dsa.binary_search;

/**
 * @author Heshan Karunaratne
 */
public class FindMinimumInRotatedSortedArray {

    public static int findMin(int[] nums) {
        int minimum = Integer.MAX_VALUE;

        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {

            int mid = (l + r) / 2;

            if (nums[l] <= nums[mid]) {
                minimum = Math.min(minimum, nums[l]);
                l = mid + 1;
            } else {
                minimum = Math.min(minimum, nums[mid]);
                r = mid - 1;
            }
        }
        return minimum;
    }

    public static void main(String[] args) {
        int[] nums = {2, 0};
        int min = findMin(nums);
        System.out.println(min);
    }
}
