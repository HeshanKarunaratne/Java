package hackerrankquestions;

import java.util.logging.Logger;

/**
 * @author Heshan Karunaratne
 */
public class InsertNodeAtEnd {
    private static final Logger LOGGER = Logger.getLogger(InsertNodeAtEnd.class.getName());

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

        public SinglyLinkedList() {
            this.head = null;
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

    static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
        if (head == null) {
            head = newNode;
            head.next = null;
            return head;
        } else {
            SinglyLinkedListNode current = head;

            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            return head;
        }
    }

    public static void main(String[] args) {

        SinglyLinkedList llist = new SinglyLinkedList();
        llist.head = insertNodeAtTail(llist.head, 10);
        llist.head = insertNodeAtTail(llist.head, 20);
        llist.head = insertNodeAtTail(llist.head, 30);
        llist.head = insertNodeAtTail(llist.head, 35);
        llist.head = insertNodeAtTail(llist.head, 40);

        printSinglyLinkedList(llist.head);
    }
}
