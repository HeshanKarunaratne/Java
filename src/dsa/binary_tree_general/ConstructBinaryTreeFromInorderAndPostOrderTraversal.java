package dsa.binary_tree_general;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Heshan Karunaratne
 */
public class ConstructBinaryTreeFromInorderAndPostOrderTraversal {
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

    public static TreeNode buildTree(int[] inorder, int[] postorder) {

        Map<Integer, Integer> inOrderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            inOrderIndexMap.put(inorder[i], i);

        return splitTree(postorder, inOrderIndexMap, postorder.length - 1, 0, inorder.length - 1);
    }

    private static TreeNode splitTree(int[] postorder, Map<Integer, Integer> inOrderIndexMap, int rootIndex, int left, int right) {

        TreeNode root = new TreeNode(postorder[rootIndex]);

        Integer mid = inOrderIndexMap.get(postorder[rootIndex]);
        if (left < mid) root.left = splitTree(postorder, inOrderIndexMap, rootIndex - 1 + mid - right, left, mid - 1);

        if (mid < right) root.right = splitTree(postorder, inOrderIndexMap, rootIndex - 1, mid + 1, right);

        return root;
    }

    public static void main(String[] args) {
        int[] postorder = {9, 15, 7, 20, 3};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode treeNode = buildTree(inorder, postorder);
        System.out.println(treeNode);
    }
}
