package dsa.binary_search_tree;

/**
 * @author Heshan Karunaratne
 */
public class MinimumAbsoluteDifferenceInBST {
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

    static int minDifference = Integer.MAX_VALUE;
    static Integer prev = null;

    public static int getMinimumDifference(TreeNode root) {
        if (root == null) return minDifference;

        getMinimumDifference(root.left);
        if (prev != null) {
            minDifference = Math.min(minDifference, root.val - prev);
        }
        if (root != null) {
            prev = root.val;
        }
        getMinimumDifference(root.right);

        return minDifference;
    }


    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(4);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(6);
        TreeNode root4 = new TreeNode(1);
        TreeNode root5 = new TreeNode(3);

        root1.left = root2;
        root1.right = root3;
        root2.left = root4;
        root2.right = root5;

        int minimumDifference = getMinimumDifference(root1);
        System.out.println(minimumDifference);
    }
}
