package HackerRankQuestions;

/**
 * Only works for specific position except head and tail
 * @author Heshan Karunaratne
 */
public class InsertNodeInSpecificPosition {

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

    public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {
        if (head == null) return null;

        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
        SinglyLinkedListNode previous = head;
        SinglyLinkedListNode current = head;
        int count = 0;

        while (current != null) {
            if (count == position) {
                previous.next = newNode;
                newNode.next = current;
                break;
            } else {
                count++;
                previous = current;
                current = current.next;
            }
        }

        return head;
    }

    public static void printDoublyLinkedList(SinglyLinkedListNode node) {
        SinglyLinkedListNode temp = node;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {

        SinglyLinkedList llist = new SinglyLinkedList();

        llist.insertNode(10);
        llist.insertNode(22);
        llist.insertNode(30);

        SinglyLinkedListNode newHead = insertNodeAtPosition(llist.head, 40, 1);
        printDoublyLinkedList(newHead);
    }
}

