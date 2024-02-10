package dsa.linked_list;

/**
 * @author Heshan Karunaratne
 */
public class AddTwoNumbers {

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

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode ptr = result;
        int carry = 0;

        while (l1 != null || l2 != null) {

            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;
            sum %= 10;
            ptr.next = new ListNode(sum);
            ptr = ptr.next;

        }
        if (carry != 0) ptr.next = new ListNode(carry);
        return result.next;
    }

    public static void main(String[] args) {

        ListNode l11 = new ListNode(2);
        ListNode l12 = new ListNode(4);
        ListNode l13 = new ListNode(3);
        ListNode l14 = new ListNode(5);
        l11.next = l12;
        l12.next = l13;
        l13.next = l14;

        ListNode l21 = new ListNode(5);
        ListNode l22 = new ListNode(6);
        ListNode l23 = new ListNode(4);
        l21.next = l22;
        l22.next = l23;

        ListNode listNode = addTwoNumbers(l11, l21);
        System.out.println(listNode);
    }
}
