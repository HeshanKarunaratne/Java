package dsa.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Heshan Karunaratne
 */
public class RotateArray {

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        int n = arr.length;
        int k = 2;
        k = k % n;

//        rotate(arr, 3);
        reverse(arr, 0, n - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, n - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void rotate(int[] nums, int k) {

        int size = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < size; i++) {
            int newIndex = (i + k) % size;
            map.put(newIndex, nums[i]);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            nums[entry.getKey()] = entry.getValue();
        }
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start <= end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
