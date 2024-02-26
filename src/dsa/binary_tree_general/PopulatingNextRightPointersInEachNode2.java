package dsa.binary_tree_general;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Heshan Karunaratne
 */
public class PopulatingNextRightPointersInEachNode2 {

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public static void main(String[] args) {

        Node root1 = new Node(1);
        Node root2 = new Node(2);
        Node root3 = new Node(3);
        Node root4 = new Node(4);
        Node root5 = new Node(5);
        Node root6 = new Node(7);

        root1.left = root2;
        root1.right = root3;
        root2.left = root4;
        root2.right = root5;
        root3.right = root6;
        Node output = connectV2(root1);
        System.out.println(output);
    }

    public static Node connect(Node root) {
        if (root == null) return null;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            Node dummy = new Node(0);
            while (size-- > 0) {

                Node node = queue.remove();
                dummy.next = node;
                dummy = dummy.next;

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return root;
    }

    public static Node connectV2(Node root) {
        if (root == null) return null;

        Node head = root;
        while (head != null) {
            Node dummy = new Node();
            Node temp = dummy;

            while (head != null) {
                if (head.left != null) {
                    temp.next = head.left;
                    temp = temp.next;
                }
                if (head.right != null) {
                    temp.next = head.right;
                    temp = temp.next;
                }
                head = head.next;
            }
            head = dummy.next;
        }
        return root;
    }
}
