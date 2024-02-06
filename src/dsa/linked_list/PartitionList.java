package dsa.linked_list;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Heshan Karunaratne
 */
public class PartitionList {
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

    public static ListNode partition(ListNode head, int x) {

        if (head == null) return null;
        Queue<Integer> smallQueue = new ArrayDeque<>();
        Queue<Integer> largeQueue = new ArrayDeque<>();

        ListNode temp = head;
        while (temp != null) {

            if (temp.val < x) smallQueue.add(temp.val);
            else largeQueue.add(temp.val);

            temp = temp.next;
        }

        temp = head;
        while (!smallQueue.isEmpty()) {
            temp.val = smallQueue.poll();
            temp = temp.next;
        }

        while (!largeQueue.isEmpty()) {
            temp.val = largeQueue.poll();
            temp = temp.next;
        }

        return head;
    }

    public static void main(String[] args) {

        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(4);
        ListNode head3 = new ListNode(3);
        ListNode head4 = new ListNode(2);
        ListNode head5 = new ListNode(5);
        ListNode head6 = new ListNode(2);

        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head5;
        head5.next = head6;
        head6.next = null;

        ListNode output = partition(head1, 3);
        System.out.println(output);
    }
}
