package dsa.linked_list;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Heshan Karunaratne
 */
public class RemoveDuplicatesFromSortedList2 {
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

    public static ListNode deleteDuplicates(ListNode head) {

        if (head == null) return null;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode temp = head;
        Map<Integer, Integer> map = new LinkedHashMap<>();
        while (temp != null) {
            if (!map.containsKey(temp.val)) {
                map.put(temp.val, 1);
            } else {
                map.put(temp.val, map.get(temp.val) + 1);
            }
            temp = temp.next;
        }
        temp = dummy;
        boolean isChecked = false;
        for (Map.Entry<Integer, Integer> item : map.entrySet()) {
            if (item.getValue() == 1) {
                isChecked = true;
                ListNode newNode = new ListNode(item.getKey());
                temp.next = newNode;
                temp = temp.next;
            }
        }
        if (!isChecked) return null;

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(1);
        ListNode head3 = new ListNode(1);
        ListNode head4 = new ListNode(2);
        ListNode head5 = new ListNode(3);


        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head5;
        head5.next = null;
        ListNode output = deleteDuplicates(head1);
        System.out.println(output);
    }
}
