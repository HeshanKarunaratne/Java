package hackerrankquestions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Heshan Karunaratne
 */
public class MaximumElement {

    public static List<Integer> getMax(List<String> operations) {

        List<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> maxStack = new Stack<>();
        maxStack.push(Integer.MIN_VALUE);

        for (String operation : operations) {
            if (operation.startsWith("1")) {
                Integer item = Integer.parseInt(operation.split(" ")[1]);
                stack.push(item);
                int maxSoFar = maxStack.peek();
                if (item > maxSoFar) {
                    maxStack.push(item);
                } else {
                    maxStack.push(maxSoFar);
                }
            }
            if (operation.startsWith("2")) {
                stack.pop();
                maxStack.pop();
            }
            if (operation.startsWith("3")) {
                System.out.println(maxStack.peek());
                list.add(maxStack.peek());
            }
        }

        return list;
    }

    public static void main(String[] args) {
        List<String> operations = new ArrayList<>();
        operations.add("1 97");
        operations.add("2");
        operations.add("1 20");
        operations.add("2");
        operations.add("1 26");
        operations.add("1 20");
        operations.add("2");
        operations.add("3");
        operations.add("1 91");
        operations.add("3");
        System.out.println(getMax(operations));
    }
}
