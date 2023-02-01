package hackerrankquestions;

import java.util.ArrayDeque;
import java.util.logging.Logger;

/**
 * @author Heshan Karunaratne
 */
public class NodeValueFromTail {
    private static final Logger LOGGER = Logger.getLogger(NodeValueFromTail.class.getName());

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

    public static int getNode(SinglyLinkedListNode llist, int positionFromTail) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        SinglyLinkedListNode current = llist;
        while (current != null) {
            stack.push(current.data);
            current = current.next;
        }

        int pointer = 0;
        int lastVal = 0;
        while (!stack.isEmpty()) {
            lastVal = stack.peek();
            if (pointer == positionFromTail) {
                return lastVal;
            }
            pointer++;
            stack.pop();
        }
        return lastVal;

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

        SinglyLinkedList llist = new SinglyLinkedList();

        llist.insertNode(10);
        llist.insertNode(20);
        llist.insertNode(30);

        printSinglyLinkedList(llist.head);
        getNode(llist.head, 4);

    }
}
