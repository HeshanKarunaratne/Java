package hackerrankquestions;

/**
 * @author Heshan Karunaratne
 */
public class BalancedBrackets {

    public static void main(String[] args) {
        System.out.println(isBalanced("{[]()}}"));
    }

    public static boolean isBalanced(String word) {

        while (true) {
            int wordLength = word.length();
            word = word.replace("[]", "")
                    .replace("()", "")
                    .replace("{}", "");


            int lengthAfter = word.length();
            if (wordLength == lengthAfter) {
                break;
            }
        }

        return word.length() == 0;
    }
}
