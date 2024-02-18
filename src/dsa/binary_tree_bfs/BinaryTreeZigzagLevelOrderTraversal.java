package dsa.binary_tree_bfs;

import java.util.*;

/**
 * @author Heshan Karunaratne
 */
public class BinaryTreeZigzagLevelOrderTraversal {
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

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> zigzag = new ArrayList<>();
        if (root == null) return zigzag;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = false;

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            Stack<Integer> reverseStack = new Stack<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (flag) {
                    reverseStack.push(node.val);
                } else {
                    level.add(node.val);
                }

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            flag = !flag;
            while (!reverseStack.isEmpty()) {
                level.add(reverseStack.pop());
            }

            zigzag.add(level);
        }

        return zigzag;
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

        List<List<Integer>> output = zigzagLevelOrder(root1);
        System.out.println(output);
    }
}
