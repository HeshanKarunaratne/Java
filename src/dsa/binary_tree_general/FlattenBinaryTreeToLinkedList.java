package dsa.binary_tree_general;

/**
 * @author Heshan Karunaratne
 */
public class FlattenBinaryTreeToLinkedList {
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

    public static void flatten(TreeNode root) {
        if (root == null) return;

        TreeNode leftTemp = root.left;
        TreeNode rightTemp = root.right;

        root.left = null;

        flatten(leftTemp);
        flatten(rightTemp);

        root.right = leftTemp;

        TreeNode current = root;
        while (current.right != null) current = current.right;

        current.right = rightTemp;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(5);

        root1.left = root2;
        root1.right = root3;

        flatten(root1);
        System.out.println(root1);
    }
}
