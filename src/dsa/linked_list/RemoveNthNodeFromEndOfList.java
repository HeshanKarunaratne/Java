package dsa.linked_list;

/**
 * @author Heshan Karunaratne
 */
public class RemoveNthNodeFromEndOfList {

    static public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        if (head == null) return null;
        if (n == 0) return head;

        int count = 1;

        ListNode temp = head;
        while (temp.next != null) {
            count++;
            temp = temp.next;
        }

        if (count == 1 && n == 1) return null;

        ListNode dummy = new ListNode();
        dummy.next = head;
        temp = dummy;
        ListNode current = head;
        for (int i = 0; i < count - n; i++) {
            temp = temp.next;
            current = current.next;
        }

        temp.next = current.next;
        return dummy.next;
    }

    public static void main(String[] args) {

        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        ListNode head4 = new ListNode(4);
        ListNode head5 = new ListNode(5);

        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head5;
        head5.next = null;

        ListNode output = removeNthFromEnd(head1, 2);
        System.out.println(output);
    }
}
