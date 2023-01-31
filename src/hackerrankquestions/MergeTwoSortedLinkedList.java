package hackerrankquestions;

/**
 * @author Heshan Karunaratne
 */
public class MergeTwoSortedLinkedList {

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

    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        if (head1 == null && head2 == null) return null;

        if (head1 == null && head2 != null) return head2;

        if (head1 != null && head2 == null) return head1;

        SinglyLinkedListNode head = null, tail = null;
        if (head1.data <= head2.data) {
            head = tail = head1;
            head1 = head1.next;
        } else {
            head = tail = head2;
            head2 = head2.next;
        }

        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                tail.next = head1;
                tail = head1;
                head1 = head1.next;
            } else {
                tail.next = head2;
                tail = head2;
                head2 = head2.next;
            }
        }

        if (head1 != null) {
            tail.next = head1;
        } else {
            tail.next = head2;
        }
        return head;
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node) {
        SinglyLinkedListNode temp = node;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {

        SinglyLinkedList list1 = new SinglyLinkedList();

        list1.insertNode(10);
        list1.insertNode(20);
        list1.insertNode(30);
        list1.insertNode(40);

        SinglyLinkedList list2 = new SinglyLinkedList();

        list2.insertNode(10);
        list2.insertNode(40);

        SinglyLinkedListNode newHead = mergeLists(list1.head, list2.head);
        printSinglyLinkedList(newHead);

    }
}
