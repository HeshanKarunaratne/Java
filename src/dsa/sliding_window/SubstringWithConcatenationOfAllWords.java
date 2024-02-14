package dsa.sliding_window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Heshan Karunaratne
 */
public class SubstringWithConcatenationOfAllWords {


    public static void main(String[] args) {
        String s = "wordgoodgoodgoodbestword";
        String[] words = {"word", "good", "best", "word"};
        System.out.println(findSubstring(s, words));
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();

        int len = words[0].length();
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i <= s.length() - len * words.length; i++) {
            Map<String, Integer> copyMap = new HashMap<>(map);

            for (int j = 0; j < words.length; j++) {
                String str = s.substring(i + j * len, i + j * len + len);

                if (copyMap.containsKey(str)) {
                    int count = copyMap.get(str);
                    if (count == 1) copyMap.remove(str);
                    else copyMap.put(str, count - 1);
                    if (copyMap.isEmpty()) {
                        ans.add(i);
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        return ans;
    }

}
