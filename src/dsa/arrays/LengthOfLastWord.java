package dsa.arrays;

/**
 * @author Heshan Karunaratne
 */
public class LengthOfLastWord {

    public static void main(String[] args) {
//        String word = "Hello World";
//        String word = "   fly me   to   the moon  ";
        String word = "luffy is still joyboy";
        System.out.println(lengthOfLastWord(word));
    }

    public static int lengthOfLastWord(String s) {

        if (s.isEmpty()) return 0;

        String[] s1 = s.split(" ");
        if (s1.length > 0) {
            return s1[s1.length - 1].length();
        }
        return 0;
    }
}
