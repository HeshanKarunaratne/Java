package hackerrankquestions;

import java.util.Stack;

/**
 * @author Heshan Karunaratne
 */
public class QueueUsingTwoStacks {

    private static Stack<Integer> inputStack = new Stack<>();
    private static Stack<Integer> outputStack = new Stack<>();

    public static void main(String[] args) {
        enqueue(10);
        enqueue(20);
        dequeue();
        peek();
        enqueue(30);
        enqueue(40);
        peek();
        dequeue();
    }

    public static void enqueue(Integer a) {
        inputStack.push(a);
    }

    public static int dequeue() {
        peek();
        return outputStack.pop();
    }

    public static int peek() {
        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }
        return outputStack.peek();
    }

    public boolean isEmpty() {
        return inputStack.isEmpty() && outputStack.isEmpty();
    }
}
