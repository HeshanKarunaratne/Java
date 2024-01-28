package dsa.two_pointers;

/**
 * @author Heshan Karunaratne
 */
public class ValidPalindrome {

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
//        String s = "race a car";
//        String s = "ab_a";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        if (s.isBlank()) return true;
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                sb.append(Character.toLowerCase(ch));
            }
        }
        String filteredString = sb.toString();
        String reversedString = sb.reverse().toString();
        return filteredString.equals(reversedString);
    }

}
