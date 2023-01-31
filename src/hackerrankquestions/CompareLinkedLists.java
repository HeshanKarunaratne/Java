package hackerrankquestions;

import java.io.BufferedWriter;
import java.io.IOException;

/**
 * @author Heshan Karunaratne
 */
public class CompareLinkedLists {

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

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }

    static boolean compareLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {

        if (checkCount(head1, head2)) {
            while (head1 != null && head2 != null) {

                if (head1.data != head2.data) {
                    return false;
                }
                head1 = head1.next;
                head2 = head2.next;
            }
            return true;
        }
        return false;

    }

    private static boolean checkCount(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        int count1 = 0;
        int count2 = 0;

        while (head1 != null) {
            count1++;
            head1 = head1.next;
        }

        while (head2 != null) {
            count2++;
            head2 = head2.next;
        }
        return count1 == count2;
    }

    public static void main(String[] args) {

        SinglyLinkedList llist1 = new SinglyLinkedList();

        llist1.insertNode(10);
        llist1.insertNode(20);
        llist1.insertNode(30);

        SinglyLinkedList llist2 = new SinglyLinkedList();

        llist2.insertNode(10);
        llist2.insertNode(20);
        llist2.insertNode(40);
        llist2.insertNode(30);

        compareLists(llist1.head, llist2.head);

    }
}
