package hackerrankquestions;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Heshan Karunaratne
 */
public class MaximumNumberOfVowelsInASubstringOfGivenLength {

    public static void main(String[] args) {
        String s = "leetcode";
        int k = 3;
        System.out.println(maxVowels(s, k));
    }

    public static int maxVowels(String s, int k) {

        Set<Character> set = extracted();

        int count = 0;
        for (int start = 0; start < k; start++) {
            if (set.contains(s.charAt(start))) {
                count++;
            }
        }
        int maxCount = count;
        int startIndex = 0;
        int endIndex = k;

        while (endIndex < s.length()) {
            if (set.contains(s.charAt(endIndex++))) {
                count++;
            }
            if (set.contains(s.charAt(startIndex++))) {
                count--;
            }
            maxCount = Math.max(maxCount, count);
            if(maxCount == k) break;
        }
        return maxCount;
    }

    private static Set<Character> extracted() {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        return set;
    }

}
