package dsa.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author Heshan Karunaratne
 */
public class WordPattern {

    public static void main(String[] args) {

        String pattern = "abba";
        String s = "dog cat cat dghd";

        System.out.println(wordPattern(pattern, s));
    }

    public static boolean wordPattern(String pattern, String s) {
        String[] matchingArr = s.split(" ");
        if (pattern.length() != matchingArr.length) return false;
        Map<Character, String> map = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            if (!map.containsKey(pattern.charAt(i))) {
                if (!map.containsValue(matchingArr[i])) {
                    map.put(pattern.charAt(i), matchingArr[i]);
                } else return false;
            } else {
                String storedVal = map.get(pattern.charAt(i));
                if (!storedVal.equals(matchingArr[i])) return false;
            }
        }
        return true;
    }
}
