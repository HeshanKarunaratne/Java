package hackerrankquestions;

import java.util.logging.Logger;

/**
 * @author Heshan Karunaratne
 */
public class DeleteNodeInLinkedList {

    private static final Logger LOGGER = Logger.getLogger(DeleteNodeInLinkedList.class.getName());

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

    public static SinglyLinkedListNode deleteNode(SinglyLinkedListNode head, int position) {
        SinglyLinkedListNode current = head;
        if (current == null) {
            return null;
        }
        int nodeCount = findNodeCount(current);

        if (position >= nodeCount) {
            LOGGER.info("no node to be deleted");
            return head;
        }

        LOGGER.info("node can be deleted");
        return deleteNodeFromPosition(head, position);
    }

    private static SinglyLinkedListNode deleteNodeFromPosition(SinglyLinkedListNode head, int position) {
        SinglyLinkedListNode current = head;
        SinglyLinkedListNode previous = null;
        int placeholder = 0;
        if (placeholder == position) {
            head = head.next;
            return head;
        } else {
            while (placeholder != position) {
                previous = current;
                current = current.next;
                placeholder++;
            }
            previous.next = current.next;
            current.next = null;
            return head;
        }
    }

    private static int findNodeCount(SinglyLinkedListNode current) {
        int count = 0;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node) {
        SinglyLinkedListNode temp = node;
        while (temp != null) {
            String data = String.valueOf(temp.data);
            LOGGER.info(data);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {

        int position = 0;
        SinglyLinkedList llist = new SinglyLinkedList();

        llist.insertNode(10);
        llist.insertNode(20);
        llist.insertNode(30);
        llist.insertNode(40);

        printSinglyLinkedList(llist.head);

        deleteNode(llist.head, position);
        LOGGER.info("*****AFTER_DELETING*****");
        printSinglyLinkedList(llist.head);
    }
}
