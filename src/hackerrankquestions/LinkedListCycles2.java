package hackerrankquestions;

/**
 * @author Heshan Karunaratne
 */
public class LinkedListCycles2 {

    public static ListNode hasCycle(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {

                while (head != slow) {
                    head = head.next;
                    slow = slow.next;
                }

                return slow;
            }
        }
        return null;

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

        final ListNode listNode = hasCycle(root);
        System.out.println(listNode);
    }
}