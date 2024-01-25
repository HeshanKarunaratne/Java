package dsa.arrays;

/**
 * @author Heshan Karunaratne
 */
public class FindIndexOfFirstOccurrenceInAString {

    public static void main(String[] args) {
        String hayStack = "sadbutsad";
        String needle = "but";

        System.out.println(strStr(hayStack, needle));
    }

    public static int strStr(String haystack, String needle) {
        int index = -1;
        if (!haystack.contains(needle)) {
            return index;
        }

        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                String val = haystack.substring(i, i + needle.length());
                if (val.equals(needle)) {
                    index = i;
                    return index;
                }
            }
        }
        return index;
    }
}
