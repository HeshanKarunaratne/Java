package dsa.binary_tree_general;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Heshan Karunaratne
 */
public class MaximumDepthOfABinaryTree {

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

        TreeNode root1 = new TreeNode(3);
        TreeNode root2 = new TreeNode(9);
        TreeNode root3 = new TreeNode(20);
        TreeNode root4 = new TreeNode(15);
        TreeNode root5 = new TreeNode(7);

        root1.left = root2;
        root1.right = root3;
        root3.left = root4;
        root3.right = root5;

        System.out.println(maxDepth(root1));
    }

    public static int maxDepth(TreeNode root) {

        if (root == null) return 0;
        Queue<TreeNode> elementQueue = new LinkedList<>();
        elementQueue.add(root);
        int numberOfLevels = 0;

        while (true) {
            int nodeCountAtLevel = elementQueue.size();
            if (nodeCountAtLevel == 0) return numberOfLevels;

            while (nodeCountAtLevel > 0) {
                TreeNode element = elementQueue.poll();
                if (element.left != null) {
                    elementQueue.add(element.left);
                }
                if (element.right != null) {
                    elementQueue.add(element.right);
                }
                nodeCountAtLevel--;
            }
            numberOfLevels++;
        }
    }
}
