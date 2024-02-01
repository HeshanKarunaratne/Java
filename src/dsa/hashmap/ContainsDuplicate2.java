package dsa.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Heshan Karunaratne
 */
public class ContainsDuplicate2 {


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 2, 3};
        int k = 2;
        System.out.println(containsNearbyDuplicate(nums, k));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            } else {
                Integer pastIndex = map.get(nums[i]);
                if (Math.abs(pastIndex - i) <= k) {
                    return true;
                } else {
                    map.put(nums[i], i);
                }
            }
        }
        return false;
    }
}
