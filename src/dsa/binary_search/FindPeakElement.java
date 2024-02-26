package dsa.binary_search;

/**
 * @author Heshan Karunaratne
 */
public class FindPeakElement {

    public static int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;

        while (l < r) {
            int midIndex = (l + r) / 2;
            if (nums[midIndex] > nums[midIndex + 1]) r = midIndex;
            else l = midIndex + 1;
        }
        return l;
    }

    public static void main(String[] args) {
//        int[] nums = {1, 2, 3, 1};
        int[] nums = {1, 2, 1, 3, 5, 6, 4};
        int peakElement = findPeakElement(nums);
        System.out.println(peakElement);
    }
}
