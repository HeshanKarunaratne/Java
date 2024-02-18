package dsa.binary_tree_general;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Heshan Karunaratne
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    static public class TreeNode {
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

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode treeNode = buildTree(preorder, inorder);
        System.out.println(treeNode);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {

        Map<Integer, Integer> inOrderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            inOrderIndexMap.put(inorder[i], i);

        return splitTree(preorder, inOrderIndexMap, 0, 0, inorder.length - 1);
    }

    private static TreeNode splitTree(int[] preorder, Map<Integer, Integer> inOrderIndexMap, int rootIndex, int left, int right) {

        TreeNode root = new TreeNode(preorder[rootIndex]);

        Integer mid = inOrderIndexMap.get(preorder[rootIndex]);
        if (mid > left) root.left = splitTree(preorder, inOrderIndexMap, rootIndex + 1, left, mid - 1);

        if (mid < right) root.right = splitTree(preorder, inOrderIndexMap, rootIndex + mid - left + 1, mid + 1, right);

        return root;
    }

}
