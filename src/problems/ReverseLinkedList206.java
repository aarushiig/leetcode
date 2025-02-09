package problems;

import model.ListNode;
import utility.LinkedListUtilities;

// DIFFICULTY   : Easy
// TOPICS       : Linked List, Recursion
public class ReverseLinkedList206 {
    public static void main(String[] args) {
        System.out.printf("REVERED LL: %s%n", LinkedListUtilities.getLinkedListAsString(reverseListInPlace(LinkedListUtilities.generateLinkedListFromArray(new Integer[]{1, 2, 3, 4, 5}))));
        System.out.printf("REVERED LL: %s%n", LinkedListUtilities.getLinkedListAsString(reverseListInPlace(LinkedListUtilities.generateLinkedListFromArray(new Integer[]{1, 2}))));
        System.out.printf("REVERED LL: %s%n", LinkedListUtilities.getLinkedListAsString(reverseListInPlace(LinkedListUtilities.generateLinkedListFromArray(new Integer[]{1}))));
        System.out.printf("REVERED LL: %s%n", LinkedListUtilities.getLinkedListAsString(reverseListInPlace(LinkedListUtilities.generateLinkedListFromArray(new Integer[0]))));
    }

    /* CONSTRAINTS: The number of nodes in the list is the range [0, 5000].
                    -5000 <= Node.val <= 5000 */

    // TIME COMPLEXITY  :O(n)
    // SPACE COMPLEXITY :O(1)
    private static ListNode reverseListInPlace(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode L = head, M = L.next, R = M.next;
        while (M != null) {
            M.next = L;

            L = M;
            M = R;
            if (R != null) R = R.next;
        }

        head.next = null;
        return L;
    }
}
