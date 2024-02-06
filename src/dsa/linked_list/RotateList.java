package dsa.linked_list;

/**
 * @author Heshan Karunaratne
 */
public class RotateList {
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

    public static ListNode rotateRight(ListNode head, int k) {

        if (head == null) return null;

        ListNode dummy = head;
        int n = 1;
        while (dummy.next != null) {
            dummy = dummy.next;
            n++;
        }

        dummy.next = head;
        dummy = head;

        k = k % n;
        for (int i = 0; i < n - k - 1; i++) {
            dummy = dummy.next;
        }
        head = dummy.next;
        dummy.next = null;
        return head;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(0);
        ListNode head2 = new ListNode(1);
        ListNode head3 = new ListNode(2);

        head1.next = head2;
        head2.next = head3;
        head3.next = null;

        ListNode output = rotateRight(head1, 1);
        System.out.println(output);
    }
}
