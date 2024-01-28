package hackerrankquestions;

import java.util.ArrayDeque;

/**
 * @author Heshan Karunaratne
 */
public class StackSolution {
    public static final String OPEN = "({[";
    public static final String CLOSE = ")}]";

    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(stackCheck(s));
    }

    private static boolean stackCheck(String s) {
        char[] chars = s.toCharArray();
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < chars.length; i++) {
            if (OPEN.contains(String.valueOf(chars[i]))) {
                stack.push(chars[i]);

            } else if (CLOSE.contains(String.valueOf(chars[i]))) {
                if (stack.isEmpty()) return false;

                Character peek = stack.peek();
                if (isCharMatching(peek, chars[i])) {
                    stack.pop();
                } else {
                    stack.push(chars[i]);
                }
            }
        }
        return stack.isEmpty();
    }

    private static boolean isCharMatching(Character peek, Character chars) {
        return chars == ')' && peek == '('
                || chars == '}' && peek == '{'
                || chars == ']' && peek == '[';
    }
}
