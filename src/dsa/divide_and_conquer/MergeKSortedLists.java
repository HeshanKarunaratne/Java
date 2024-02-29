package dsa.divide_and_conquer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Heshan Karunaratne
 */
public class MergeKSortedLists {
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

    public static ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x.val));

        ListNode res = new ListNode(0);
        ListNode temp = res;


        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null)
                pq.add(lists[i]);
        }

        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            if (node.next != null) {
                pq.add(node.next);
            }

            temp.next = node;
            temp = temp.next;
        }

        return res.next;
    }
}
