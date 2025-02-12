package problems;

import model.ListNode;

import static utility.LinkedListUtilities.generateLinkedListFromArray;
import static utility.LinkedListUtilities.getLinkedListAsString;

// DIFFICULTY   : Easy
// TOPICS       : Linked List, Recursion
public class MergeTwoSortedLists21 {
    public static void main(String[] args) {
        System.out.printf("MERGED LISTS: %s%n", getLinkedListAsString(mergeTwoListsByIteration(generateLinkedListFromArray(new Integer[]{1, 2, 4}), generateLinkedListFromArray(new Integer[]{1, 3, 4}))));
        System.out.printf("MERGED LISTS: %s%n%n", getLinkedListAsString(mergeTwoListsByRecursion(generateLinkedListFromArray(new Integer[]{1, 2, 4}), generateLinkedListFromArray(new Integer[]{1, 3, 4}))));

        System.out.printf("MERGED LISTS: %s%n", getLinkedListAsString(mergeTwoListsByIteration(generateLinkedListFromArray(new Integer[]{1, 2, 4, 5, 6, 7, 8}), generateLinkedListFromArray(new Integer[]{1, 3, 4, 9, 9, 15}))));
        System.out.printf("MERGED LISTS: %s%n%n", getLinkedListAsString(mergeTwoListsByRecursion(generateLinkedListFromArray(new Integer[]{1, 2, 4, 5, 6, 7, 8}), generateLinkedListFromArray(new Integer[]{1, 3, 4, 9, 9, 15}))));

        System.out.printf("MERGED LISTS: %s%n", getLinkedListAsString(mergeTwoListsByIteration(generateLinkedListFromArray(new Integer[0]), generateLinkedListFromArray(new Integer[]{0}))));
        System.out.printf("MERGED LISTS: %s%n%n", getLinkedListAsString(mergeTwoListsByRecursion(generateLinkedListFromArray(new Integer[0]), generateLinkedListFromArray(new Integer[]{0}))));

        System.out.printf("MERGED LISTS: %s%n", getLinkedListAsString(mergeTwoListsByIteration(generateLinkedListFromArray(new Integer[]{0}), generateLinkedListFromArray(new Integer[0]))));
        System.out.printf("MERGED LISTS: %s%n%n", getLinkedListAsString(mergeTwoListsByRecursion(generateLinkedListFromArray(new Integer[]{0}), generateLinkedListFromArray(new Integer[0]))));

        System.out.printf("MERGED LISTS: %s%n", getLinkedListAsString(mergeTwoListsByIteration(generateLinkedListFromArray(new Integer[0]), generateLinkedListFromArray(new Integer[0]))));
        System.out.printf("MERGED LISTS: %s%n", getLinkedListAsString(mergeTwoListsByRecursion(generateLinkedListFromArray(new Integer[0]), generateLinkedListFromArray(new Integer[0]))));

    }

    /* CONSTRAINTS: The number of nodes in both lists is in the range [0, 50].
                    -100 <= Node.val <= 100
                     Both list1 and list2 are sorted in non-decreasing order. */

    // TIME COMPLEXITY  : O(m + n)
    // SPACE COMPLEXITY : O(1)
    private static ListNode mergeTwoListsByIteration(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode head;
        if (list1.val <= list2.val) {
            head = list1;
            list1 = list1.next;
        } else {
            head = list2;
            list2 = list2.next;
        }

        ListNode currentNode = head;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                currentNode.next = list1;

                list1 = list1.next;
            } else {
                currentNode.next = list2;

                list2 = list2.next;
            }

            currentNode = currentNode.next;
        }

        currentNode.next = (list1 != null) ? list1 : list2;

        return head;
    }

    // TIME COMPLEXITY  : O(m + n)
    // SPACE COMPLEXITY : O(m + n)
    private static ListNode mergeTwoListsByRecursion(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if (list1.val <= list2.val) {
            list1.next = mergeTwoListsByRecursion(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoListsByRecursion(list1, list2.next);
            return list2;
        }
    }
}
