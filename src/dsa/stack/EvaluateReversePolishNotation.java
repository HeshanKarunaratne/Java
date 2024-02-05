package dsa.stack;

import java.util.Stack;

/**
 * @author Heshan Karunaratne
 */
public class EvaluateReversePolishNotation {

    public static void main(String[] args) {
        String tokens[] = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(evalRPN(tokens));
    }

    public static int evalRPN(String[] tokens) {

        if (tokens.length == 0) return 0;

        Stack<String> stack = new Stack<>();
        int val = Integer.parseInt(tokens[0]);
        for (String item : tokens) {
            if (item.equals("+")) {
                val = retrieve(stack, item);
                stack.push(String.valueOf(val));
            } else if (item.equals("*")) {
                val = retrieve(stack, item);
                stack.push(String.valueOf(val));
            } else if (item.equals("/")) {
                val = retrieve(stack, item);
                stack.push(String.valueOf(val));
            } else if (item.equals("-")) {
                val = retrieve(stack, item);
                stack.push(String.valueOf(val));
            } else {
                stack.push(item);
            }
        }
        return val;
    }

    private static int retrieve(Stack<String> stack, String item) {
        if (stack.size() >= 2) {
            int secondVal = Integer.parseInt(stack.pop());
            int firstVal = Integer.parseInt(stack.pop());

            if (item.equals("+")) {
                return firstVal + secondVal;
            } else if (item.equals("-")) {
                return firstVal - secondVal;
            } else if (item.equals("*")) {
                return firstVal * secondVal;
            } else if (item.equals("/")) {
                return firstVal / secondVal;
            }

        }
        return 0;
    }
}
