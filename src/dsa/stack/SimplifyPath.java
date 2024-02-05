package dsa.stack;

import java.util.Stack;

/**
 * @author Heshan Karunaratne
 */
public class SimplifyPath {


    public static void main(String[] args) {
//        String path = "/home/";
//        String path = "/../";
        String path = "/home//foo/";
        System.out.println(simplifyPath(path));
    }

    public static String simplifyPath(String path) {

        if (path == null) return "";

        StringBuilder canonicalPath = new StringBuilder();
        String[] arr = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String item : arr) {

            if (item.equals(".") || item.equals("")) {
            } else if (item.equals("..")) {
                if (!stack.isEmpty())
                    stack.pop();
            } else {
                stack.push(item);
            }
        }
        for (int i = 0; i < stack.size(); i++) {
            canonicalPath.append("/").append(stack.get(i));
        }
        return canonicalPath.toString().equals("") ? "/" : canonicalPath.toString();
    }
}
