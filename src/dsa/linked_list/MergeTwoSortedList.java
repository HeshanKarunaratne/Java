package dsa.linked_list;

/**
 * @author Heshan Karunaratne
 */
public class MergeTwoSortedList {

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

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null & l2 == null) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode t1 = l1;
        ListNode t2 = l2;
        ListNode head = null;
        ListNode tail = null;

        if (t1.val <= t2.val) {
            head = t1;
            tail = t1;
            t1 = t1.next;
        } else {
            head = t2;
            tail = t2;
            t2 = t2.next;
        }
        while (t1 != null && t2 != null) {
            if (t1.val <= t2.val) {
                tail.next = t1;
                tail = t1;
                t1 = t1.next;
            } else {
                tail.next = t2;
                tail = t2;
                t2 = t2.next;
            }

        }
        if (t1 != null) {
            tail.next = t1;
        } else {
            tail.next = t2;
        }
        return head;
    }

    public static ListNode mergeTwoListsV2(ListNode l1, ListNode l2) {
        ListNode returnNode = new ListNode(Integer.MIN_VALUE);
        ListNode headNode = returnNode;

        while (l1 != null && l2 != null) {

            if (l1.val <= l2.val) {
                returnNode.next = l1;
                l1 = l1.next;
            } else {
                returnNode.next = l2;
                l2 = l2.next;
            }
            returnNode = returnNode.next;
        }

        if (l1 == null) {
            returnNode.next = l2;
        } else if (l2 == null) {
            returnNode.next = l1;
        }

        return headNode.next;
    }
}
