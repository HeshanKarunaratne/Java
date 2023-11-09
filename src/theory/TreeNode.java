package theory;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Heshan Karunaratne
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}

class Test {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);

        root.left = new TreeNode(2);
        root.right = new TreeNode(8);

        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;

        leftNode.left = new TreeNode(1);
        rightNode.left = new TreeNode(6);
        rightNode.right = new TreeNode(10);

        System.out.println("InOrder");
        inOrderTraversal(root);

        System.out.println("");
        System.out.println("PreOrder");
        preOrderTraversal(root);

        System.out.println("");
        System.out.println("PostOrder");
        postOrderTraversal(root);

        System.out.println("");
        System.out.println("LevelOrder");
        levelOrderTraversal(root);
    }

    public static void inOrderTraversal(TreeNode node) {

        if (node == null) {
            return;
        }

        inOrderTraversal(node.left);
        System.out.print(node.val + "->");
        inOrderTraversal(node.right);
    }

    public static void preOrderTraversal(TreeNode node) {

        if (node == null) {
            return;
        }

        System.out.print(node.val + "->");
        inOrderTraversal(node.left);
        inOrderTraversal(node.right);
    }

    public static void postOrderTraversal(TreeNode node) {

        if (node == null) {
            return;
        }

        inOrderTraversal(node.left);
        inOrderTraversal(node.right);
        System.out.print(node.val + "->");
    }

    public static void levelOrderTraversal(TreeNode node) {
        Deque<TreeNode> queue = new ArrayDeque<>();

        if (node != null) {
            queue.add(node);
        }

        while (!queue.isEmpty()) {

            final TreeNode poll = queue.poll();
            System.out.print(poll.val + "->");

            if (poll.left != null) {
                queue.add(poll.left);
            }
            if (poll.right != null) {
                queue.add(poll.right);
            }
        }


    }
}


