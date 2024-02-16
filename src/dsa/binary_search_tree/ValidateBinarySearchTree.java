package dsa.binary_search_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heshan Karunaratne
 */
public class ValidateBinarySearchTree {
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

    public static boolean isValidBST(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        helper(root, list);
        boolean isBST = true;

        Integer prev = list.get(0);
        for (int i = 1; i < list.size(); i++) {

            if (list.get(i) <= prev) isBST = false;

            prev = list.get(i);
        }

        return isBST;
    }

    private static void helper(TreeNode root, List<Integer> list) {
        if (root == null) return;
        helper(root.left, list);
        list.add(root.val);
        helper(root.right, list);
    }

    public static void main(String[] args) {

        TreeNode root1 = new TreeNode(5);
        TreeNode root2 = new TreeNode(1);
        TreeNode root3 = new TreeNode(4);
        TreeNode root4 = new TreeNode(3);
        TreeNode root5 = new TreeNode(6);

        root1.left = root2;
        root1.right = root3;
        root3.left = root4;
        root3.right = root5;
        boolean validBST = isValidBST(root1);
        System.out.println(validBST);
    }
}
