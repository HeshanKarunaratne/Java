package theory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Heshan Karunaratne
 */
public class TimeInWords {

    public static String timeInWords(int h, int m) {
        List<String> words = new ArrayList<>(
                Arrays.asList("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve",
                        "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty"));

        if (m == 0) {
            return words.get(h - 1) + " o' clock";
        } else if (m == 1) {
            return "one minute past " + words.get(h - 1);
        } else if (m > 1 && m <= 20) {
            if (m == 15) {
                return "quarter past " + words.get(h - 1);
            } else {
                return words.get(m - 1) + " minutes past " + words.get(h - 1);
            }
        } else if (m > 20 && m < 30) {
            return "twenty " + words.get(m % 20 - 1) + " minutes past " + words.get(h - 1);
        } else if (m == 30) {
            return "half past " + words.get(h - 1);
        } else {
            if (m == 45) {
                return "quarter to " + words.get(h);
            } else {
                int minutesLeft = 60 - m;

                if (minutesLeft > 20 && minutesLeft <= 29) {
                    return "twenty " + words.get(minutesLeft % 20 - 1) + " minutes to " + words.get(h);
                } else if (minutesLeft == 1) {
                    return words.get(minutesLeft - 1) + " minute to " + words.get(h);
                } else {
                    return words.get(minutesLeft - 1) + " minutes to " + words.get(h);
                }
            }
        }
    }

    public static String timeInWordsV2(int h, int m) {
        List<String> words = new ArrayList<>(
                Arrays.asList("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve",
                        "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty"));

        if (m == 0) return words.get(h - 1) + " o' clock";
        if (m == 1) return "one minute past " + words.get(h - 1);
        if (m >= 2 && m <= 14) return words.get(m - 1) + " minutes past " + words.get(h - 1);
        if (m == 15) return "quarter past " + words.get(h - 1);
        if (m >= 16 && m <= 20) return words.get(m - 1) + " minutes past " + words.get(h - 1);
        if (m >= 21 && m <= 29) return "twenty " + words.get((m % 20) - 1) + " minutes past " + words.get(h - 1);
        if (m == 30) return "half past " + words.get(h - 1);

        int pastValue = 60 - m;
        if (pastValue == 15) return "quarter to " + words.get(h);
        if(pastValue > 20) return  "twenty " + words.get((pastValue % 20) - 1) + " minutes to " + words.get(h);
        return words.get((pastValue % 20) - 1) + " minutes to " + words.get(h);
    }

    public static void main(String[] args) {
        System.out.println(timeInWordsV2(5, 47));
    }
}
