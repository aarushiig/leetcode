package utility;

import model.ListNode;

public class LinkedListUtilities {

    /**
     * Generates a linked list from an array.
     *
     * @param array Integer array where the linked list's traversal is represented.
     * @return The head node of the generated linked list.
     */
    public static ListNode generateLinkedListFromArray(Integer[] array) {
        if (array == null || array.length == 0) return null;

        ListNode head = new ListNode(array[0]);

        ListNode current = head;
        for (int i = 1; i < array.length; i++) {
            ListNode node = new ListNode(array[i]);

            current.next = node;
            current = node;
        }

        return head;
    }

    /**
     * Generates a string from a linked list.
     *
     * @param node The head node of the linked list.
     * @return String representation of linked list.
     */
    public static String getLinkedListAsString(ListNode node) {
        if (node == null) return "[]";

        StringBuilder sb = new StringBuilder();

        sb.append("[");
        while (node.next != null) {
            sb.append(node.val).append(", ");
            node = node.next;
        }
        sb.append(node.val);
        sb.append("]");

        return sb.toString();
    }
}
