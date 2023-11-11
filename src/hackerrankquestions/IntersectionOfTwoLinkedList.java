package hackerrankquestions;

/**
 * @author Heshan Karunaratne
 */
public class IntersectionOfTwoLinkedList {

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getListLength(headA);
        int lenB = getListLength(headB);

        while (lenA > lenB) {
            lenA--;
            headA = headA.next;
        }

        while (lenB > lenA) {
            lenB--;
            headB = headB.next;
        }

        while (headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    private static int getListLength(ListNode headA) {
        int length = 0;
        ListNode temp = headA;
        while (temp != null) {
            temp = temp.next;
            length++;
        }
        return length;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}