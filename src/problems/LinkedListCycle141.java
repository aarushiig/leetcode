package problems;

import model.ListNode;

import java.util.HashSet;
import java.util.Set;

// DIFFICULTY   : Easy
// TOPICS       : Hash Table, Linked List, Two Pointers
public class LinkedListCycle141 {
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode bodyOne = new ListNode(2);
        ListNode bodyTwo = new ListNode(0);
        ListNode tail = new ListNode(-4);

        head.next = bodyOne;
        bodyOne.next = bodyTwo;
        bodyTwo.next = tail;
        tail.next = bodyOne;

        System.out.printf("HAS CYCLE?: %S %s %S%n", hasCycleUsingSet(head), hasCycleInPlaceUsingConstraints(head), hasCycleInPlaceUsingTwoPointers(head));

        ListNode head2 = new ListNode(1);
        ListNode tail2 = new ListNode(2);

        head2.next = tail2;
        tail2.next = head2;

        System.out.printf("HAS CYCLE?: %S %s %S%n", hasCycleUsingSet(head2), hasCycleInPlaceUsingConstraints(head2), hasCycleInPlaceUsingTwoPointers(head2));

        ListNode head3 = new ListNode(1);

        System.out.printf("HAS CYCLE?: %S %s %S%n", hasCycleUsingSet(head3), hasCycleInPlaceUsingConstraints(head3), hasCycleInPlaceUsingTwoPointers(head3));

        System.out.printf("HAS CYCLE?: %S %s %S%n", hasCycleUsingSet(null), hasCycleInPlaceUsingConstraints(null), hasCycleInPlaceUsingTwoPointers(null));
    }

    /* CONSTRAINTS: The number of the nodes in the list is in the range [0, 10^4].
                    -10^5 <= Node.val <= 10^5
                     pos is -1 or a valid index in the linked-list. */

    // TIME COMPLEXITY  : O(n)
    // SPACE COMPLEXITY : O(n)
    private static boolean hasCycleUsingSet(ListNode head) {
        ListNode current = head;

        Set<ListNode> nodes = new HashSet<>();
        while (current != null) {
            if (nodes.contains(current)) return true;

            nodes.add(current);
            current = current.next;
        }

        return false;
    }

    // TIME COMPLEXITY  : O(n)
    // SPACE COMPLEXITY : O(1)
    private static boolean hasCycleInPlaceUsingConstraints(ListNode head) {
        int max = (int) (Math.pow(10, 5) + 1);

        ListNode current = head;
        while (current != null) {
            if (current.val == max) return true;

            current.val = max;
            current = current.next;
        }

        return false;
    }

    // TIME COMPLEXITY  : O(n)
    // SPACE COMPLEXITY : O(1)
    private static boolean hasCycleInPlaceUsingTwoPointers(ListNode head) {
        if (head == null) return false;

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            if (slow == fast) return true;

            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }
}
