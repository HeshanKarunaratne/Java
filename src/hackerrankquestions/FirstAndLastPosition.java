package hackerrankquestions;

/**
 * @author Heshan Karunaratne
 */
public class FirstAndLastPosition {

    public static int[] searchRange(int[] nums, int target) {
        int leftPosition = searchLeft(nums, target);
        int rightPosition = searchRight(nums, target);
        return new int[]{leftPosition, rightPosition};
    }

    public static int searchLeft(int[] nums, int target) {
        int index = -1, low = 0, high = nums.length - 1;
        while (low <= high) {

            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                index = mid;
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return index;
    }

    public static int searchRight(int[] nums, int target) {
        int index = -1, low = 0, high = nums.length - 1;
        while (low <= high) {

            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                index = mid;
                low = mid + 1;
            } else if (target < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return index;

    }

    public static void main(String[] args) {
        int nums[] = {5, 7, 7, 9, 9, 10};
        int target = 8;
        final int[] result = searchRange(nums, target);
        System.out.println(result[0] + " " + result[1]);
    }
}
