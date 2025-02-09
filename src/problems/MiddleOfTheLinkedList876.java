package problems;

import model.ListNode;
import utility.LinkedListUtilities;

// DIFFICULTY   : Easy
// TOPICS       : Linked List, Two Pointers
public class MiddleOfTheLinkedList876 {
    public static void main(String[] args) {
        System.out.printf("MIDDLE OF LL: %s%n", LinkedListUtilities.getLinkedListAsString(middleNode(LinkedListUtilities.generateLinkedListFromArray(new Integer[]{1, 2, 3, 4, 5}))));
        System.out.printf("MIDDLE OF LL: %s%n", LinkedListUtilities.getLinkedListAsString(middleNode(LinkedListUtilities.generateLinkedListFromArray(new Integer[]{1, 2, 3, 4, 5, 6}))));
    }

    /* CONSTRAINTS: The number of nodes in the list is in the range [1, 100].
     *              1 <= node.val <= 100 */

    // TIME COMPLEXITY  : O(n)
    // SPACE COMPLEXITY : O(1)
    private static ListNode middleNode(ListNode head) {
        ListNode slowPointer = head;
        ListNode fastPointer = head;

        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        return slowPointer;
    }
}
