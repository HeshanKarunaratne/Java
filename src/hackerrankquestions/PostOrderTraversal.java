package hackerrankquestions;

import java.util.logging.Logger;

/**
 * @author Heshan Karunaratne
 */
public class PostOrderTraversal {
    private static final Logger LOGGER = Logger.getLogger(PostOrderTraversal.class.getName());

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

    public static void postOrder(Node root) {
        if (root == null)
            return;

        postOrder(root.left);
        postOrder(root.right);
        String value = root.data + " ";
        LOGGER.info(value);
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

        postOrder(root);
    }
}