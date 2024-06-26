package dsa.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Heshan Karunaratne
 */
public class MajorityElement {

    public static void main(String[] args) {

        int nums[] = {2, 2, 1, 1, 1, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3};
//        int nums[] = {3, 2, 3};
        System.out.println(majorityElement(nums));
        System.out.println(majorityElementV2(nums));
    }

    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int val = map.get(nums[i]);
                map.put(nums[i], val + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        int max = Integer.MIN_VALUE;
        int maxItem = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> item : map.entrySet()) {
            if (item.getValue() > max) {
                max = item.getValue();
                maxItem = item.getKey();
            }
        }
        return maxItem;
    }

    public static int majorityElementV2(int[] nums) {

        int count = 1;
        int candidate = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == candidate) count++;
            else count--;

            if (count == 0) candidate = nums[i];
        }
        return candidate;
    }
}
