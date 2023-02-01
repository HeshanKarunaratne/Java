package hackerrankquestions;

import java.util.ArrayDeque;
import java.util.logging.Logger;

/**
 * @author Heshan Karunaratne
 */
public class ReverseDoublyLinkedList {

    private static final Logger LOGGER = Logger.getLogger(ReverseDoublyLinkedList.class.getName());

    static class DoublyLinkedListNode {
        private int data;
        private DoublyLinkedListNode next;
        private DoublyLinkedListNode prev;

        public DoublyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
            this.prev = null;
        }
    }

    static class DoublyLinkedList {
        private DoublyLinkedListNode head;
        private DoublyLinkedListNode tail;

        public DoublyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
                node.prev = this.tail;
            }

            this.tail = node;
        }
    }

    public static void printDoublyLinkedList(DoublyLinkedListNode node) {
        DoublyLinkedListNode temp = node;
        while (temp != null) {
            String data = String.valueOf(temp.data);
            LOGGER.info(data);
            temp = temp.next;
        }
    }

    public static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {
        DoublyLinkedListNode current = head;

        if (current == null)
            return null;

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        while (current != null) {
            stack.push(current.data);
            if (current.next == null) {
                break;
            }
            current = current.next;
        }

        current = head;

        while (current != null) {
            current.data = stack.pop();
            if (current.next == null) {
                break;
            }
            current = current.next;
        }

        while (current != null) {
            if (current.prev == null) {
                break;
            }
            current = current.prev;
        }
        return current;
    }

    public static void main(String[] args) {
        
        DoublyLinkedList llist = new DoublyLinkedList();
        llist.insertNode(10);
        llist.insertNode(20);
        llist.insertNode(30);

        printDoublyLinkedList(llist.head);
        DoublyLinkedListNode reverseHead = reverse(llist.head);
        printDoublyLinkedList(reverseHead);

    }
}
