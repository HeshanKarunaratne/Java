package dsa.binary_tree_bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Heshan Karunaratne
 */
public class BinaryTreeRightSideView {
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

    public static List<Integer> rightSideView(TreeNode root) {

        if (root == null) return new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        while (queue.peek() != null) {
            TreeNode node = null;
            while (queue.peek() != null) {
                node = queue.poll();

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            list.add(node.val);
            queue.add(queue.poll());

        }
        return list;
    }

    public static List<Integer> rightSideViewV2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        rightView(root, result, 0);
        return result;
    }

    private static void rightView(TreeNode curr, List<Integer> result, int currDepth) {
        if (curr == null) return;

        if (currDepth == result.size()) {
            result.add(curr.val);
        }
        rightView(curr.right, result, currDepth + 1);
        rightView(curr.left, result, currDepth + 1);
    }


    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(5);
        TreeNode root5 = new TreeNode(4);

        root1.left = root2;
        root1.right = root3;
        root2.right = root4;
        root3.right = root5;

        List<Integer> output = rightSideViewV2(root1);
        System.out.println(output);
    }
}
