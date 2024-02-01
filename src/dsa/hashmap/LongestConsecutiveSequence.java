package dsa.hashmap;

import java.util.*;

/**
 * @author Heshan Karunaratne
 */
public class LongestConsecutiveSequence {


    public static void main(String[] args) {
//        int nums[] = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
//        int nums[] = {100, 4, 200, 1, 3, 2};
        int nums[] = {1, 2, 0, 1};
        System.out.println(longestConsecutive(nums));
        System.out.println(longestConsecutiveV2(nums));
    }

    public static int longestConsecutiveV2(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return 1;

        Arrays.sort(nums);

        int maxCount = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {

            if (list.isEmpty()) {
                list.add(nums[i]);
            } else {

                Integer integer = list.get(list.size() - 1);
                if (nums[i] == integer + 1) {
                    list.add(nums[i]);
                    maxCount = getMaxCount(maxCount, list);
                } else {
                    maxCount = getMaxCount(maxCount, list);
                    list.clear();
                    list.add(nums[i]);
                }
            }
        }
        return maxCount;
    }

    private static int getMaxCount(int maxCount, List<Integer> list) {
        if (list.size() > maxCount) {
            maxCount = list.size();
        }
        return maxCount;
    }

    public static int longestConsecutive(int[] nums) {
        int longestLength = 0;
        Map<Integer, Boolean> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, false);
        }

        for (int num : nums) {
            int currentLength = 1;
            int nextNum = num + 1;

            while (map.containsKey(nextNum) && map.get(nextNum) == false) {
                currentLength++;
                map.put(nextNum, true);
                nextNum++;
            }

            int prevNum = num - 1;
            while (map.containsKey(prevNum) && !map.get(prevNum)) {
                currentLength++;
                map.put(prevNum, true);
                prevNum--;
            }

            longestLength = Math.max(longestLength, currentLength);
        }

        return longestLength;
    }
}
