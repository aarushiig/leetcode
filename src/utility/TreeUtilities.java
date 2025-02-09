package utility;

import model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class TreeUtilities {

    /**
     * Generates a binary tree from a level-order traversal array.
     *
     * @param levelOrderTraversal Integer array where the level-order traversal is represented.
     * @return The root node of the generated binary tree.
     */
    public static TreeNode generateBinaryTreeFromLevelOrderTraversal(Integer[] levelOrderTraversal) {
        if (levelOrderTraversal == null || levelOrderTraversal.length == 0) return null;

        // Create the root node from the first element.
        TreeNode root = new TreeNode(levelOrderTraversal[0]);

        // Create a queue to manage nodes whose children need to be assigned.
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int index = 1;
        while (index < levelOrderTraversal.length) {
            TreeNode current = queue.poll();

            // Assign left child, if exists.
            if (levelOrderTraversal[index] != null) {
                current.left = new TreeNode(levelOrderTraversal[index]);
                queue.offer(current.left);
            }
            index++;

            // Assign right child, if exists.
            if (index < levelOrderTraversal.length && levelOrderTraversal[index] != null) {
                current.right = new TreeNode(levelOrderTraversal[index]);
                queue.offer(current.right);
            }
            index++;
        }

        return root;
    }
}
