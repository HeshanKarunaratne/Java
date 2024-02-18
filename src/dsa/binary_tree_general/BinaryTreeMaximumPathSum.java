package dsa.binary_tree_general;

/**
 * @author Heshan Karunaratne
 */
public class BinaryTreeMaximumPathSum {
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

    public static int maxPathSum(TreeNode root) {
        int maxValue[] = new int[1];
        maxValue[0] = Integer.MIN_VALUE;
        maxSum(root, maxValue);
        return maxValue[0];
    }

    public static int maxSum(TreeNode root, int maxValue[]) {

        if (root == null) return 0;

        int leftSum = Math.max(0, maxSum(root.left, maxValue));
        int rightSum = Math.max(0, maxSum(root.right, maxValue));
        maxValue[0] = Math.max(maxValue[0], leftSum + rightSum + root.val);
        return Math.max(leftSum, rightSum) + root.val;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(-10);
        TreeNode root2 = new TreeNode(9);
        TreeNode root3 = new TreeNode(20);
        TreeNode root4 = new TreeNode(15);
        TreeNode root5 = new TreeNode(7);

        root1.left = root2;
        root1.right = root3;
        root3.left = root4;
        root3.right = root5;

        int sum = maxPathSum(root1);
        System.out.println(sum);
    }

}
