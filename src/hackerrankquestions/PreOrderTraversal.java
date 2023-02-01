package hackerrankquestions;

import java.util.logging.Logger;

/**
 * @author Heshan Karunaratne
 */
public class PreOrderTraversal {
    private static final Logger LOGGER = Logger.getLogger(PreOrderTraversal.class.getName());

    static class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static void preOrder(Node root) {
        if (root == null)
            return;

        String value = root.data + " ";
        LOGGER.info(value);
        preOrder(root.left);
        preOrder(root.right);
    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {

        Node root = null;
        root = insert(root, 1);
        insert(root, 2);
        insert(root, 5);
        insert(root, 3);
        insert(root, 6);
        insert(root, 4);

        preOrder(root);
    }
}