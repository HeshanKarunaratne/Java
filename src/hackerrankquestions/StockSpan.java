package hackerrankquestions;

import java.util.Stack;

/**
 * @author Heshan Karunaratne
 */
public class StockSpan {

    public static void main(String[] args) {
        int prices[] = {100, 80, 60, 70, 60, 75, 85};
        final int[] result = stockSpan(prices);

        System.out.println(result);
    }

    public static int[] stockSpan(int[] prices) {
        if (prices.length == 0) {
            return new int[0];
        }

        int result[] = new int[prices.length];
        result[0] = 1;

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (int i = 1; i < prices.length; i++) {

            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) stack.pop();

            if (stack.isEmpty()) result[i] = i + 1;
            else result[i] = i - stack.peek();

            stack.push(i);
        }

        return result;
    }
}
