package hackerrankquestions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Heshan Karunaratne
 */
public class SimpleTextEditor {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1 abc");
        list.add("3 3");
        list.add("2 3");
        list.add("1 xy");
        list.add("3 2");
        list.add("4");
        list.add("4");
        list.add("3 1");

        test(list);
    }

    public static void test(List<String> list) {
        Stack<String> stack = new Stack<>();
        String str = "";
        stack.push(str);

        for (String element : list) {
            switch (element.charAt(0)) {
                case '1'://append
                    str = str + element.split(" ")[1];
                    stack.push(str);
                    break;

                case '2'://delete(x)
                    final String s = element.split(" ")[1];
                    str = str.substring(0, str.length() - Integer.parseInt(s));
                    stack.push(str);
                    break;

                case '3'://print(x)
                    System.out.println(str.charAt(Integer.parseInt(element.split(" ")[1]) - 1));
                    break;

                case '4'://undo
                    stack.pop();
                    str = stack.peek();
                    break;

                default:
                    break;
            }

        }
    }
}
