package dsa.oned_dp;

/*
139. Word Break

Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

Example 1:
Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".

Example 2:
Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.

Example 3:
Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false
 */

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Heshan Karunaratne
 */
public class WordBreak {
    static Map<String, Boolean> map = new HashMap<>();

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = List.of("leet", "code");
        System.out.println(wordBreak(s, wordDict));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        if (s.isBlank() || wordDict.isEmpty()) return false;
        if (wordDict.contains(s)) return true;

        if (map.containsKey(s)) return map.get(s);

        for (int i = 1; i < s.length(); i++) {
            String left = s.substring(0, i);
            if (wordDict.contains(left) && wordBreak(s.substring(i), wordDict)) {
                map.put(s, true);
                return true;
            }
        }
        map.put(s, false);
        return false;
    }
}

/*
You need to check whether the given string s is contained inside the wordDict dictionary
If the whole word is in the dictionary we can return true
else we need to split from the beginning and check whether the left part and the right part is inside the dictionary

We can introduce a map to keep track of the previously checked values to optimize the result
If any part is inside the wordDict we can add that part to the map with true, else false

 */