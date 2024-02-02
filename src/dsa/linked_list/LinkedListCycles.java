package dsa.linked_list;

/**
 * @author Heshan Karunaratne
 */
public class LinkedListCycles {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) return true;
        }
        return false;

    }

    public static void main(String[] args) {
        ListNode root = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(4);

        root.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;

        System.out.println(hasCycle(root));
    }
}