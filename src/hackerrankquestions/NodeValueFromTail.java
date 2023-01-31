package hackerrankquestions;

import java.io.IOException;
import java.util.Stack;

/**
 * @author Heshan Karunaratne
 */
public class NodeValueFromTail {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

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
        Stack<Integer> stack = new Stack<>();
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
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void main(String[] args) throws IOException {

        SinglyLinkedList llist = new SinglyLinkedList();

        llist.insertNode(10);
        llist.insertNode(20);
        llist.insertNode(30);

        printSinglyLinkedList(llist.head);

        System.out.println(getNode(llist.head, 4));

    }
}
