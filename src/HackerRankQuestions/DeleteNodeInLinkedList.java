package HackerRankQuestions;

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
    public static SinglyLinkedListNode deleteNode(SinglyLinkedListNode head, int position) {
        SinglyLinkedListNode current = head;
        if (current == null) {
            return null;
        }
        int count = findNodeCount(current);
        System.out.println("count is: " + count);

        if(position >= count) {
            System.out.println("no node to be deleted");
            return head;
        }

        System.out.println("node can be deleted");

        return null;
    }

    private static int findNodeCount(SinglyLinkedListNode current) {
        int count = 0;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
}

public class DeleteNodeInLinkedList {
    public static void main(String[] args) {

        int position = 3;
        SinglyLinkedList llist = new SinglyLinkedList();

        llist.insertNode(10);
        llist.insertNode(20);
        llist.insertNode(30);
        llist.insertNode(40);

        Result.deleteNode(llist.head, position);

    }
}
