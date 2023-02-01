package hackerrankquestions;

import java.util.ArrayDeque;
import java.util.logging.Logger;

/**
 * @author Heshan Karunaratne
 */
public class ReverseLinkedList {

    private static final Logger LOGGER = Logger.getLogger(ReverseLinkedList.class.getName());

    static class SinglyLinkedListNode {
        private int data;
        private SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        private SinglyLinkedListNode head;
        private SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node) {
        SinglyLinkedListNode temp = node;
        while (temp != null) {
            String data = String.valueOf(temp.data);
            LOGGER.info(data);
            temp = temp.next;
        }
    }


    public static SinglyLinkedListNode reverse(SinglyLinkedListNode llist) {
        SinglyLinkedListNode temp = llist;
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        while (temp != null) {
            stack.push(temp.data);
            temp = temp.next;
        }

        SinglyLinkedList llist2 = new SinglyLinkedList();
        while (!stack.isEmpty()) {
            llist2.insertNode(stack.pop());
        }

        return llist2.head;
    }

    public static void main(String[] args) {
        SinglyLinkedList llist = new SinglyLinkedList();
        llist.insertNode(10);
        llist.insertNode(20);
        llist.insertNode(30);

        printSinglyLinkedList(llist.head);
        SinglyLinkedListNode newHead = reverse(llist.head);
        printSinglyLinkedList(newHead);

    }
}