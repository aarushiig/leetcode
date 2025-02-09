package problems;

import model.TreeNode;
import utility.TreeUtilities;

// DIFFICULTY   : Easy
// TOPICS       : Tree, Binary Tree
public class RootEqualsSumOfChildren2236 {
    public static void main(String[] args) {
        System.out.printf("CHECK: %s%n", checkTree(TreeUtilities.generateBinaryTreeFromLevelOrderTraversal(new Integer[]{10, 4, 6})));
        System.out.printf("CHECK: %s%n", checkTree(TreeUtilities.generateBinaryTreeFromLevelOrderTraversal(new Integer[]{5, 3, 1})));
    }

    /* CONSTRAINTS: -100 <= val <=
     *              The tree consists only of the root, its left child, and its right child. */

    // TIME COMPLEXITY  : O(n)
    // SPACE COMPLEXITY : O(1)
    private static boolean checkTree(TreeNode root) {
        return root.val == root.left.val + root.right.val;
    }
}
