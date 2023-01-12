package HackerRankQuestions;

import java.util.Stack;

/**
 * @author Heshan Karunaratne
 */
public class ReverseLinkedList {

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

    public static void printSinglyLinkedList(SinglyLinkedListNode node) {
        SinglyLinkedListNode temp = node;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }


    public static SinglyLinkedListNode reverse(SinglyLinkedListNode llist) {
        SinglyLinkedListNode temp = llist;
        Stack<Integer> stack = new Stack<>();

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

        System.out.println("******BEFORE*******");
        printSinglyLinkedList(llist.head);
        System.out.println("******BEFORE*******");
        SinglyLinkedListNode newHead = reverse(llist.head);
        System.out.println("******AFTER*******");
        printSinglyLinkedList(newHead);
        System.out.println("******AFTER*******");
    }
}