package dsa.binary_tree_general;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Heshan Karunaratne
 */
public class CountCompleteTreeNodes {
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

    public static int countNodes(TreeNode root) {
        int count = 0;
        if (root == null) return count;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        count++;

        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();

            if (temp.left != null) {
                queue.add(temp.left);
                count++;
            }
            if (temp.right != null) {
                queue.add(temp.right);
                count++;
            }
        }
        return count;
    }

    public static int countNodesV2(TreeNode root) {
        if (root == null) return 0;
        int lh = leftHeight(root);
        int rh = rightHeight(root);

        if (lh == rh) return (int) Math.pow(2, lh) - 1;

        return countNodesV2(root.left) + countNodesV2(root.right) + 1;
    }

    private static int leftHeight(TreeNode root) {
        if (root == null) return 0;
        return leftHeight(root.left) + 1;
    }

    private static int rightHeight(TreeNode root) {
        if (root == null) return 0;
        return rightHeight(root.right) + 1;
    }

    public static void main(String[] args) {

        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(4);

        root1.left = root2;
        root2.left = root3;
        root1.right = root4;
        System.out.println(countNodes(root1));
        System.out.println(countNodesV2(root1));
    }
}
