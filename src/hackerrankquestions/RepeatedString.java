package hackerrankquestions;

/**
 * @author Heshan Karunaratne
 */
public class RepeatedString {

    public static long repeatedString(String s, long n) {
        long count = 0;
        char searchable = 'a';
        int size = s.length();
        long times = n / size;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == searchable) {
                count++;
            }
        }

        long left = n % size;
        int extra = 0;
        for (int i = 0; i < left; i++) {
            if (s.charAt(i) == searchable) {
                extra++;
            }
        }

        return ((count * times) + extra);
    }

    public static void main(String[] args) {
        System.out.println(repeatedString("abcac", 122));
    }
}
