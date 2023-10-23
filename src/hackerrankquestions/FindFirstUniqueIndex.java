package hackerrankquestions;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Heshan Karunaratne
 */
public class FindFirstUniqueIndex {

    public static void main(String[] args) {
        System.out.println(findIndex("heshan"));
    }

    public static int findIndex(String word) {
        int index = -1;

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {

            final char c = word.charAt(i);

            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        for (int i = 0; i < word.length(); i++) {
            if (map.get(word.charAt(i)) == 1) {
                index = i;
                return index;
            }
        }


        return index;
    }
}
