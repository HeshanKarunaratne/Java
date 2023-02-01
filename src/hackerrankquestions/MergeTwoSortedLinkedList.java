package hackerrankquestions;

import java.util.logging.Logger;

/**
 * @author Heshan Karunaratne
 */
public class MergeTwoSortedLinkedList {
    private static final Logger LOGGER = Logger.getLogger(MergeTwoSortedLinkedList.class.getName());

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

    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {

        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        SinglyLinkedListNode t1 = head1;
        SinglyLinkedListNode t2 = head2;
        SinglyLinkedListNode head = null;
        SinglyLinkedListNode tail = null;
        if (t1.data <= t2.data) {
            head = t1;
            tail = t1;
            t1 = t1.next;
        } else {
            head = t2;
            tail = t2;
            t2 = t2.next;
        }
        while (t1 != null && t2 != null) {
            if (t1.data <= t2.data) {
                tail.next = t1;
                tail = t1;
                t1 = t1.next;
            } else {
                tail.next = t2;
                tail = t2;
                t2 = t2.next;
            }

        }
        if (t1 != null) {
            tail.next = t1;
        } else {
            tail.next = t2;
        }
        return head;
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

        SinglyLinkedList list1 = new SinglyLinkedList();

        list1.insertNode(10);
        list1.insertNode(20);
        list1.insertNode(30);
        list1.insertNode(40);

        SinglyLinkedList list2 = new SinglyLinkedList();

        list2.insertNode(10);
        list2.insertNode(40);

        SinglyLinkedListNode newHead = mergeLists(list1.head, list2.head);
        printSinglyLinkedList(newHead);

    }
}
