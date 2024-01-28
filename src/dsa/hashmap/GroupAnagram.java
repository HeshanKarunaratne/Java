package dsa.hashmap;

import java.util.*;

/**
 * @author Heshan Karunaratne
 */
public class GroupAnagram {

    public static void main(String[] args) {
        String[] arr = {"eat", "tea", "tan", "ate", "nat", "bat"};
        final List<List<String>> lists = groupAnagrams(arr);
        System.out.println(lists);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {

            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            final String val = String.valueOf(charArray);

            if (!map.containsKey(val)) {
                map.put(val, new ArrayList<>());
            }
            map.get(val).add(str);

        }
        return new ArrayList<>(map.values());
    }
}
