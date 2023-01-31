package hackerrankquestions;

/**
 * @author Heshan Karunaratne
 */
public class RemoveDuplicatesFromLinkedList {

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

    public static void printDoublyLinkedList(SinglyLinkedListNode node) {
        SinglyLinkedListNode temp = node;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode head) {
        SinglyLinkedListNode temp = head;

        while (temp.next != null) {
            if (temp.next.data == temp.data) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {

        SinglyLinkedList llist = new SinglyLinkedList();

        llist.insertNode(10);
        llist.insertNode(10);
        llist.insertNode(20);
        llist.insertNode(20);
        llist.insertNode(30);
        llist.insertNode(30);

        printDoublyLinkedList(llist.head);
        SinglyLinkedListNode newHead = removeDuplicates(llist.head);
        System.out.println("*****************");
        printDoublyLinkedList(newHead);

    }
}
