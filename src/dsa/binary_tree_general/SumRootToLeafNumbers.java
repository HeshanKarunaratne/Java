package dsa.binary_tree_general;

import java.util.Stack;

/**
 * @author Heshan Karunaratne
 */
public class SumRootToLeafNumbers {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static int sumNumbers(TreeNode root) {
        int sum = 0;
        if (root == null) return sum;

        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<String> sumStack = new Stack<>();

        nodeStack.push(root);
        sumStack.push(String.valueOf(root.val));

        while (!nodeStack.isEmpty()) {
            TreeNode temp = nodeStack.pop();
            String val = sumStack.pop();

            if (temp.left == null && temp.right == null) {
                sum += Integer.parseInt(val);
            }

            if (temp.left != null) {
                nodeStack.push(temp.left);
                sumStack.push(val + temp.left.val);
            }

            if (temp.right != null) {
                nodeStack.push(temp.right);
                sumStack.push(val + temp.right.val);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(4);
        TreeNode root2 = new TreeNode(9);
        TreeNode root3 = new TreeNode(0);
        TreeNode root4 = new TreeNode(5);
        TreeNode root5 = new TreeNode(1);

        root1.left = root2;
        root1.right = root3;
        root2.left = root4;
        root2.right = root5;
        System.out.println(sumNumbers(root1));
    }
}
