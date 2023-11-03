package hackerrankquestions;

import java.util.Stack;

/**
 * @author Heshan Karunaratne
 */
class SinglyLinkedListNode {
    public int data;
    public SinglyLinkedListNode next;

    public SinglyLinkedListNode(int nodeData) {
        this.data = nodeData;
        this.next = null;
    }
}

class SinglyLinkedList {
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

class SinglyLinkedListPrintHelper {
    public static void printList(SinglyLinkedListNode node, String sep) {
        while (node != null) {
            System.out.print(node.data);

            node = node.next;

            if (node != null) {
                System.out.print(sep);
            }
        }
    }
}

class PrintInReverse {

    public static void reversePrint(SinglyLinkedListNode llist) {

        Stack<Integer> stack = new Stack<>();

        while (llist != null) {
            stack.push(llist.data);
            llist = llist.next;
        }

        while (!stack.isEmpty())
            System.out.println(stack.pop());

    }

    public static void main(String[] args) {
        SinglyLinkedList llist = new SinglyLinkedList();
        llist.insertNode(10);
        llist.insertNode(15);
        llist.insertNode(20);
        llist.insertNode(30);

        PrintInReverse.reversePrint(llist.head);
    }

}