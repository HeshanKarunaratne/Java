package dsa.binary_search_tree;

/**
 * @author Heshan Karunaratne
 */
public class KthSmallestElementInABST {
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

    private static int number = 0;
    private static int count = 0;

    public static int kthSmallest(TreeNode root, int k) {
        helper(root, k);
        return number;
    }

    public static void helper(TreeNode n, int k) {
        if (n.left != null) helper(n.left, k);
        count++;
        if (count == k) {
            number = n.val;
            return;
        }
        if (n.right != null) helper(n.right, k);
    }


    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(10);
        TreeNode root2 = new TreeNode(5);
        TreeNode root3 = new TreeNode(20);
        TreeNode root4 = new TreeNode(1);
        TreeNode root5 = new TreeNode(6);

        root1.left = root2;
        root1.right = root3;
        root2.left = root4;
        root2.right = root5;
        System.out.println(kthSmallest(root1, 5));
    }
}
