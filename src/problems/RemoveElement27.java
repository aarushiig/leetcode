package problems;

import java.util.Arrays;

// DIFFICULTY   : Easy
// TOPICS       : Array, Two Pointers
public class RemoveElement27 {
    public static void main(String[] args) {
        testRemoveElements(new int[]{3, 2, 2, 3}, 3, new int[]{2, 2}, 2);
        testRemoveElements(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2, new int[]{0, 0, 1, 3, 4}, 5);
        testRemoveElements(new int[]{2, 2, 2, 2}, 2, new int[]{}, 0);
    }

    /* CONSTRAINTS: 0 <= nums.length <= 100
     *              0 <= nums[i] <= 50
     *              0 <= val <= 100 */

    // TIME COMPLEXITY  : O(n)
    // SPACE COMPLEXITY : O(1)
    private static int removeElementByForwardIteratingSecondPointer(int[] nums, int val) {
        if (val > 50) return nums.length;

        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index++] = nums[i];
            }
        }

        return index;
    }

    // TIME COMPLEXITY  : O(n)
    // SPACE COMPLEXITY : O(1)
    private static int removeElementByBackwardIteratingSecondPointer(int[] nums, int val) {
        if (val > 50) return nums.length;

        int i = 0, j = nums.length - 1;
        for (; i <= j; i++) {
            if (nums[i] == val) {
                nums[i--] = nums[j--];
            }
        }

        return i;
    }

    private static void testRemoveElements(int[] nums, int val, int[] expectedNums, int actualLength) {
        int k = removeElementByBackwardIteratingSecondPointer(nums, val); // Calls your implementation

        if (k != expectedNums.length) throw new AssertionError();
        Arrays.sort(nums, 0, k);
        for (int i = 0; i < actualLength; i++) {
            if (nums[i] != expectedNums[i]) throw new AssertionError();
        }
    }
}
