package dsa.binary_tree_general;

import java.util.Stack;

/**
 * @author Heshan Karunaratne
 */
public class BinarySearchTreeIterator {
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

    Stack<TreeNode> stack = new Stack<>();

    public BinarySearchTreeIterator(TreeNode root) {
        pushAll(root);
    }

    public int next() {
        TreeNode temp = stack.pop();
        pushAll(temp.right);
        return temp.val;
    }

    private void pushAll(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public static void main(String[] args) {

        TreeNode root1 = new TreeNode(7);
        TreeNode root2 = new TreeNode(3);
        TreeNode root3 = new TreeNode(15);
        TreeNode root4 = new TreeNode(9);
        TreeNode root5 = new TreeNode(20);

        root1.left = root2;
        root1.right = root3;
        root3.left = root4;
        root3.right = root5;

        BinarySearchTreeIterator obj = new BinarySearchTreeIterator(root1);
        System.out.println(obj.next());
        System.out.println(obj.next());
        System.out.println(obj.next());
        System.out.println(obj.next());
        System.out.println(obj.next());
    }
}
