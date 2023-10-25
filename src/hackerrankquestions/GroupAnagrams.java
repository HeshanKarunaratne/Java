package hackerrankquestions;

import java.util.*;

/**
 * @author Heshan Karunaratne
 */
public class GroupAnagrams {

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
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(val, list);
            } else {
                final List<String> strings = map.get(val);
                strings.add(str);
                map.put(val, strings);
            }
        }
        return new ArrayList<>(map.values());
    }
}
