package dsa.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Heshan Karunaratne
 */
public class IsomorphicStrings {

    public static void main(String[] args) {
        String s = "badc";
        String t = "baba";
        System.out.println(isIsomorphic(s, t));
    }

    public static boolean isIsomorphic(String s, String t) {

        if (s.length() != t.length()) return false;

        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {

            if (!map.containsKey(s.charAt(i))) {
                if (!map.containsValue(t.charAt(i))) {
                    map.put(s.charAt(i), t.charAt(i));
                } else return false;
            } else {
                char matchingTChar = map.get(s.charAt(i));
                if (matchingTChar != t.charAt(i)) return false;
            }
        }
        return true;
    }
}
