package hackerrankquestions;

import java.util.Stack;

/**
 * @author Heshan Karunaratne
 */
public class SuperReducedString {

    public static String superReducedString(String s) {

        if (s == null) return null;

        if (s.length() == 1) return s;

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            final char c = s.charAt(i);

            if (stack.isEmpty()) stack.push(c);

            else {
                final Character peek = stack.peek();
                if (peek == c) stack.pop();

                else stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder("");
        for (Character c : stack) {
            sb.append(c);
        }

        if (sb.length() == 0) return "Empty String";

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(superReducedString("ababdbcddc"));
    }
}
