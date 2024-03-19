package dsa.linked_list;

/**
 * @author Heshan Karunaratne
 */
public class RemoveNodesInKGroup {

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

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head.next == null) return head;
        if (k == 1) return head;

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;

        while (cur != null) {
            boolean space = checkHasSpace(k, cur);
            if (space) {
                pre = reverse(pre, cur, k);
                cur = pre.next;
            } else {
                break;
            }
        }
        return dummy.next;
    }

    private static ListNode reverse(ListNode pre, ListNode cur, int k) {
        for (int i = 0; i < k - 1; i++) {
            ListNode nex = cur.next;
            cur.next = nex.next;
            nex.next = pre.next;
            pre.next = nex;
        }
        return cur;
    }

    private static boolean checkHasSpace(int k, ListNode cur) {
        for (int i = 1; i <= k; i++) {
            if (cur == null) return false;
            cur = cur.next;
        }
        return true;
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

        ListNode output = reverseKGroup(head1, 3);
        System.out.println(output);
    }
}
