package problems;

// DIFFICULTY   : Easy
// TOPICS       : Array, Two Pointers
public class RemoveDuplicatesFromSortedArray26 {
    public static void main(String[] args) {
        testRemoveDuplicates(new int[]{1, 1, 2}, new int[]{1, 2});
        testRemoveDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}, new int[]{0, 1, 2, 3, 4});
        testRemoveDuplicates(new int[]{-18}, new int[]{-18});
    }

    /* CONSTRAINTS: 1 <= nums.length <= 3 * 10^4
     *              -100 <= nums[i] <= 100
     *              nums is sorted in non-decreasing order. */

    // TIME COMPLEXITY  : O(n)
    // SPACE COMPLEXITY : O(1)
    private static int removeDuplicates(int[] nums) {
        int newLength = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[newLength]) {
                nums[++newLength] = nums[i];
            }
        }

        return newLength + 1;
    }

    private static void testRemoveDuplicates(int[] nums, int[] expectedNums) {
        int k = removeDuplicates(nums);

        if (k != expectedNums.length) throw new AssertionError();
        for (int i = 0; i < k; i++) {
            if (nums[i] != expectedNums[i]) throw new AssertionError();
        }
    }
}
