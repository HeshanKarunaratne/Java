package dsa.divide_and_conquer;

/**
 * @author Heshan Karunaratne
 */
public class SortList {
    static class ListNode {
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

    public static ListNode sortList(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode temp = head;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        temp.next = null;

        ListNode leftSide = sortList(head);
        ListNode rightSide = sortList(slow);

        return mergeList(leftSide, rightSide);
    }

    private static ListNode mergeList(ListNode l1, ListNode l2) {
        ListNode sortedTemp = new ListNode(0);
        ListNode currentNode = sortedTemp;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                currentNode.next = l1;
                l1 = l1.next;
            } else {
                currentNode.next = l2;
                l2 = l2.next;
            }
            currentNode = currentNode.next;
        }

        if (l1 != null) {
            currentNode.next = l1;
            l1 = l1.next;
        }

        if (l2 != null) {
            currentNode.next = l2;
            l2 = l2.next;
        }

        return sortedTemp.next;
    }

    public static void main(String[] args) {

        ListNode head1 = new ListNode(-1);
        ListNode head2 = new ListNode(5);
        ListNode head3 = new ListNode(3);
        ListNode head4 = new ListNode(4);
        ListNode head5 = new ListNode(0);

        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head5;
        head5.next = null;

        ListNode output = sortList(head1);
        System.out.println(output);
    }
}
