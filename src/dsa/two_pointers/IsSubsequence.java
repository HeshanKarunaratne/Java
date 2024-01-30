package dsa.two_pointers;

/**
 * @author Heshan Karunaratne
 */
public class IsSubsequence {
    public static boolean isSubsequence(String s, String t) {

        if (s.length() > t.length()) return false;

        int sPointer = 0;
        int tPointer = 0;

        while (true) {

            if (sPointer == s.length()) return true;
            if (tPointer == t.length()) return false;

            if (s.charAt(sPointer) == t.charAt(tPointer)) {
                sPointer++;
            }
            tPointer++;
        }
    }

    public static void main(String[] args) {
        String s = "axc";
        String t = "ahbgdc";
        System.out.println(isSubsequence(s, t));
    }

}
