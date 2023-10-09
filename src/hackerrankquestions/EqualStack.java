package hackerrankquestions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Heshan Karunaratne
 */
public class EqualStack {

    public static void main(String[] args) {

        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(1);
        list1.add(1);
        list1.add(2);
        list1.add(3);

        List<Integer> list2 = new ArrayList<>();
        list2.add(2);
        list2.add(3);
        list2.add(4);

        List<Integer> list3 = new ArrayList<>();
        list3.add(1);
        list3.add(4);
        list3.add(1);
        list3.add(1);

        System.out.println(equalStacks(list1, list2, list3));
    }

    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {

        Stack<Integer> stack1 = new Stack<>();
        int stack1Height = 0;
        for (Integer i : h1) {
            stack1Height += i;
            stack1.push(stack1Height);
        }

        Stack<Integer> stack2 = new Stack<>();
        int stack2Height = 0;
        for (Integer i : h2) {
            stack2Height += i;
            stack2.push(stack2Height);
        }

        Stack<Integer> stack3 = new Stack<>();
        int stack3Height = 0;
        for (Integer i : h3) {
            stack3Height += i;
            stack3.push(stack3Height);
        }

        while (true){

            if(stack1.isEmpty() || stack2.isEmpty() || stack3.isEmpty()){
                return 0;
            }

            stack1Height = stack1.peek();
            stack2Height = stack2.peek();
            stack3Height = stack3.peek();

            if(stack1Height == stack2Height && stack2Height == stack3Height){
                return stack1Height;
            }

            if(stack1Height >= stack2Height && stack1Height >= stack3Height){
                stack1.pop();
            }
            if(stack2Height >= stack3Height && stack2Height >= stack1Height){
                stack2.pop();
            }
            if(stack3Height >= stack1Height && stack3Height >= stack2Height){
                stack3.pop();
            }
        }
    }


}
