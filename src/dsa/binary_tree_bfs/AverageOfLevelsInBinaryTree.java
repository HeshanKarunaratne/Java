package dsa.binary_tree_bfs;

import java.util.*;

/**
 * @author Heshan Karunaratne
 */
public class AverageOfLevelsInBinaryTree {
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

    public static List<Double> averageOfLevels(TreeNode root) {

        if (root == null) return new ArrayList<>();
        List<Double> avgList = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        while (queue.peek() != null) {
            double sum = 0;
            int count = 0;

            while (queue.peek() != null) {
                TreeNode node = queue.poll();
                sum += node.val;
                count++;
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }

            queue.add(queue.poll());
            avgList.add(sum / count);
        }
        return avgList;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(3);
        TreeNode root2 = new TreeNode(9);
        TreeNode root3 = new TreeNode(20);
        TreeNode root4 = new TreeNode(15);
        TreeNode root5 = new TreeNode(7);

        root1.left = root2;
        root1.right = root3;
        root2.left = root4;
        root2.right = root5;

        List<Double> output = averageOfLevels(root1);
        System.out.println(output);
    }
}
