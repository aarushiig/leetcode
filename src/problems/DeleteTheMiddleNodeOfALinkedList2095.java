package problems;

import model.ListNode;
import utility.LinkedListUtilities;

// DIFFICULTY   : Medium
// TOPICS       : Linked List, Two Pointers
public class DeleteTheMiddleNodeOfALinkedList2095 {
    public static void main(String[] args) {
        System.out.printf("LL WITH MIDDLE NODE DELETED: %s%n", LinkedListUtilities.getLinkedListAsString(deleteMiddle(LinkedListUtilities.generateLinkedListFromArray(new Integer[]{1, 3, 4, 7, 1, 2, 6}))));
        System.out.printf("LL WITH MIDDLE NODE DELETED: %s%n", LinkedListUtilities.getLinkedListAsString(deleteMiddle(LinkedListUtilities.generateLinkedListFromArray(new Integer[]{1, 2, 3, 4}))));
        System.out.printf("LL WITH MIDDLE NODE DELETED: %s%n", LinkedListUtilities.getLinkedListAsString(deleteMiddle(LinkedListUtilities.generateLinkedListFromArray(new Integer[]{2, 1}))));
        System.out.printf("LL WITH MIDDLE NODE DELETED: %s%n", LinkedListUtilities.getLinkedListAsString(deleteMiddle(LinkedListUtilities.generateLinkedListFromArray(new Integer[]{1}))));
    }

    /* CONSTRAINTS: The number of nodes in the list is in the range [1, 10^5].
     *              1 <= node.val <= 10^5 */

    // TIME COMPLEXITY  : O(n)
    // SPACE COMPLEXITY : O(1)
    private static ListNode deleteMiddle(ListNode head) {
        ListNode previous = new ListNode();
        previous.next = head;

        ListNode middle = previous, tail = head;

        while (tail != null && tail.next != null) {
            middle = middle.next;
            tail = tail.next.next;
        }

        assert middle.next != null;
        middle.next = middle.next.next;

        return previous.next;
    }

    // TIME COMPLEXITY  : O(n)
    // SPACE COMPLEXITY : O(1)
    public ListNode deleteMiddleINITIAL(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode middle = head, previous = head, tail = head;

        while (tail != null && tail.next != null) {
            previous = middle;
            middle = middle.next;
            tail = tail.next.next;
        }

        previous.next = middle.next;

        return head;
    }
}
