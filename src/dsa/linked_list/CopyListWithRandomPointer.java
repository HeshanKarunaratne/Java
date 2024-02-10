package dsa.linked_list;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Heshan Karunaratne
 */
public class CopyListWithRandomPointer {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        public Node(int val, Node next, Node random) {
            this.val = val;
            this.next = next;
            this.random = random;
        }
    }

    public static Node copyRandomList(Node head) {

        if (head == null) return null;
        Map<Node, Node> map = new HashMap<>();
        Node curr = head;

        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        for (Node key : map.keySet()) {
            Node newNode = map.get(key);
            newNode.next = map.get(key.next);
            newNode.random = map.get(key.random);
        }
        return map.get(head);
    }

    public static Node copyRandomListV2(Node head) {

        if (head == null) return null;

        Node temp = head;
        while (temp != null) {
            Node next = temp.next;
            Node random = temp.random;

            temp.next = new Node(temp.val + 100, next, random);
            temp = temp.next.next;
        }

        Node newHead = head.next;
        temp = head;

        while (temp != null) {
            Node next = temp.next;
            if (next.random != null) next.random = next.random.next;
            temp = next.next;
        }

        temp = head;
        while (temp != null) {
            Node copy = temp.next;
            temp.next = copy.next;
            if (copy.next != null) copy.next = temp.next.next;
            temp = temp.next;
        }

        return newHead;
    }

    public static void main(String[] args) {
//        [[7,null],[13,0],[11,4],[10,2],[1,0]]
        Node node0 = new Node(7);
        Node node1 = new Node(13);
        Node node2 = new Node(11);
        Node node3 = new Node(10);
        Node node4 = new Node(1);

        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;

        node0.random = null;
        node1.random = node0;
        node2.random = node4;
        node3.random = node2;
        node4.random = node0;

//        Node output = copyRandomList(node0);
//        System.out.println(output);

        Node output = copyRandomListV2(node0);
        System.out.println(output);
    }
}
