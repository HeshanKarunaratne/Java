package dsa.binary_tree_general;

import java.util.Stack;

/**
 * @author Heshan Karunaratne
 */
public class PathSum {

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

    public static boolean hasPathSum(TreeNode root, int targetSum) {

        if (root == null) return false;

        Stack<TreeNode> pathStack = new Stack<>();
        Stack<Integer> sumStack = new Stack<>();
        pathStack.push(root);
        sumStack.push(root.val);

        while (!pathStack.isEmpty()) {
            TreeNode tempNode = pathStack.pop();
            Integer val = sumStack.pop();

            if (val == targetSum && tempNode.left == null && tempNode.right == null) return true;
            if (tempNode.left != null) {
                pathStack.push(tempNode.left);
                sumStack.push(val + tempNode.left.val);
            }
            if (tempNode.right != null) {
                pathStack.push(tempNode.right);
                sumStack.push(val + tempNode.right.val);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(5);
        TreeNode root2 = new TreeNode(4);
        TreeNode root3 = new TreeNode(11);
        TreeNode root4 = new TreeNode(7);
        TreeNode root5 = new TreeNode(2);

        root1.left = root2;
        root2.left = root3;
        root3.left = root4;
        root3.right = root5;

        System.out.println(hasPathSum(root1, 21));
    }
}
