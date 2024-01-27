package dsa.arrays;

import java.util.Stack;

/**
 * @author Heshan Karunaratne
 */
public class ReverseWordInAString {

    public static void main(String[] args) {
//        String s = "the sky is blue";
//        String s = "  hello world  ";
        String s = "a good   example";
        System.out.println(reverseWords(s));
    }

    public static String reverseWords(String s) {

        if (s.isEmpty()) return "";

        String[] words = s.split("\\s+");
        StringBuilder word = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            word.append(words[i]).append(" ");
        }

        return word.toString().trim();
    }
}
