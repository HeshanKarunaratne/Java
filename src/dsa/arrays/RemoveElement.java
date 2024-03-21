package dsa.arrays;

/**
 * @author Heshan Karunaratne
 */
public class RemoveElement {

    public static void main(String[] args) {
        int[] num = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
//        int[] num = new int[]{3, 2, 2, 3};
        System.out.println(removeElement(num, 2));
    }

    public static int removeElement(int[] nums, int val) {
        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[counter] = nums[i];
                counter++;
            }
        }
        return counter;
    }
}
