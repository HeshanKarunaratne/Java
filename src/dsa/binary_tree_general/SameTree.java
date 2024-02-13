package dsa.binary_tree_general;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Heshan Karunaratne
 */
public class SameTree {
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

    public static void main(String[] args) {

        TreeNode root11 = new TreeNode(1);
        TreeNode root12 = new TreeNode(2);
        TreeNode root13 = new TreeNode(3);

        root11.left = root12;
        root11.right = root13;

        TreeNode root21 = new TreeNode(1);
        TreeNode root22 = new TreeNode(3);
        TreeNode root23 = new TreeNode(2);

        root21.left = root22;
        root21.right = root23;

        System.out.println(isSameTree(root11, root21));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(p);
        queue.add(q);

        while (!queue.isEmpty()) {

            TreeNode first = queue.poll();
            TreeNode second = queue.poll();
            if (first == null && second == null) {
                continue;
            } else if (first == null || second == null || first.val != second.val) {
                return false;
            }

            queue.add(first.left);
            queue.add(second.left);
            queue.add(first.right);
            queue.add(second.right);
        }
        return true;
    }
}
