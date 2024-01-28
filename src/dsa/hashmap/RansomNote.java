package dsa.hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Heshan Karunaratne
 */
public class RansomNote {

    public static void main(String[] args) {
//        String ransomNote = "a";
//        String magazine = "b";

//        String ransomNote = "aa";
//        String magazine = "ab";
//
        String ransomNote = "aa";
        String magazine = "aab";
        System.out.println(canConstruct(ransomNote, magazine));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;

        int[] counter = new int[26];

        for (char c : magazine.toCharArray()) {
            counter[c - 'a']++;
        }

        for (char c : ransomNote.toCharArray()) {
            if (counter[c - 'a'] == 0) return false;
            counter[c - 'a']--;
        }
        return true;
    }
}
