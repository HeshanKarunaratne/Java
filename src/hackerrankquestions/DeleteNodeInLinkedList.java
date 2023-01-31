package hackerrankquestions;

import java.util.logging.Logger;

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

class Result {
    private static final Logger LOGGER = Logger.getLogger(Result.class.getName());

    public static SinglyLinkedListNode deleteNode(SinglyLinkedListNode head, int position) {
        SinglyLinkedListNode current = head;
        if (current == null) {
            return null;
        }
        int nodeCount = findNodeCount(current);
        System.out.println("count is: " + nodeCount);

        if (position >= nodeCount) {
            System.out.println("no node to be deleted");
            return head;
        }

        System.out.println("node can be deleted");
        return deleteNodeFromPosition(head, position, nodeCount);
    }

    private static SinglyLinkedListNode deleteNodeFromPosition(SinglyLinkedListNode head, int position, int nodeCount) {
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
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}

public class DeleteNodeInLinkedList {
    public static void main(String[] args) {

        int position = 0;
        SinglyLinkedList llist = new SinglyLinkedList();

        llist.insertNode(10);
        llist.insertNode(20);
        llist.insertNode(30);
        llist.insertNode(40);

        Result.printSinglyLinkedList(llist.head);

        Result.deleteNode(llist.head, position);
        System.out.println("*****AFTER_DELETING*****");
        Result.printSinglyLinkedList(llist.head);
    }
}
