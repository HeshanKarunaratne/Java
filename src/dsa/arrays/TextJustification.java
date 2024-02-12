package dsa.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Heshan Karunaratne
 */
public class TextJustification {

    public static void main(String[] args) {

        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        List<String> output = fullJustify(words, maxWidth);
        System.out.println(output);
    }

    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        List<StringBuilder> currentWords = new ArrayList<>();
        int sumOfLengthOfCurrentWords = 0;

        for (String word : words) {
            int newLineLength = sumOfLengthOfCurrentWords + word.length() + currentWords.size();
            if (newLineLength > maxWidth) {

                int extraPadding = maxWidth - (sumOfLengthOfCurrentWords + currentWords.size() - 1);
                int wordsToRoundRobinSpaces = Math.max(currentWords.size() - 1, 1);

                for (int i = 0; i < extraPadding; i++) {
                    int indexForSpace = i % wordsToRoundRobinSpaces;
                    currentWords.get(indexForSpace).append(" ");
                }

                result.add(currentWords.stream().map(StringBuilder::toString).collect(Collectors.joining(" ")));
                currentWords = new ArrayList<>();
                sumOfLengthOfCurrentWords = 0;

            }
            currentWords.add(new StringBuilder(word));
            sumOfLengthOfCurrentWords += word.length();
        }

        int extraSpaces = maxWidth - (sumOfLengthOfCurrentWords + currentWords.size() - 1);
        String spaces = Stream.generate(() -> " ").limit(extraSpaces).collect(Collectors.joining(""));
        result.add(currentWords.stream().map(StringBuilder::toString).collect(Collectors.joining(" ")) + spaces);
        return result;
    }
}
