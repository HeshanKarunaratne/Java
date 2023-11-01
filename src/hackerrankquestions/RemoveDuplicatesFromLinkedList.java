package hackerrankquestions;

import java.util.logging.Logger;

/**
 * @author Heshan Karunaratne
 */
public class RemoveDuplicatesFromLinkedList {
    private static final Logger LOGGER = Logger.getLogger(RemoveDuplicatesFromLinkedList.class.getName());

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

    public static void printDoublyLinkedList(SinglyLinkedListNode node) {
        SinglyLinkedListNode temp = node;
        while (temp != null) {
            String data = String.valueOf(temp.data);
            LOGGER.info(data);
            temp = temp.next;
        }
    }

    public static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode head) {
        SinglyLinkedListNode temp = head;

        while (temp.next != null) {
            if (temp.next.data == temp.data) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }

    public static SinglyLinkedListNode removeDuplicates2(SinglyLinkedListNode head) {

        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return head;
        }

        SinglyLinkedListNode current = head;
        while (current.next != null) {

            if (current.data != current.next.data) {
                current = current.next;
            } else {
                current.next = current.next.next;
            }

        }

        return head;
    }

    public static void main(String[] args) {

        SinglyLinkedList llist = new SinglyLinkedList();

        llist.insertNode(10);
        llist.insertNode(10);
        llist.insertNode(20);
        llist.insertNode(20);
        llist.insertNode(30);
        llist.insertNode(30);

        printDoublyLinkedList(llist.head);
        SinglyLinkedListNode newHead = removeDuplicates2(llist.head);
        printDoublyLinkedList(newHead);

    }
}
