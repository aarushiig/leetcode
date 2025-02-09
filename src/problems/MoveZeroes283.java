package problems;

import utility.ArrayUtilities;

import java.util.Arrays;

// DIFFICULTY   : Easy
// TOPICS       : Array, Two Pointers
public class MoveZeroes283 {
    public static void main(String[] args) {
        Integer[] nums1 = new Integer[]{0, 1, 0, 3, 12};
        moveZeroes(nums1);
        System.out.printf("MODIFIED ARRAY: %s%n", Arrays.toString(nums1));

        Integer[] nums2 = new Integer[]{0};
        moveZeroes(nums2);
        System.out.printf("MODIFIED ARRAY: %s%n", Arrays.toString(nums2));

        Integer[] nums3 = new Integer[]{1, 0, 1};
        moveZeroes(nums3);
        System.out.printf("MODIFIED ARRAY: %s%n", Arrays.toString(nums3));
    }

    /* CONSTRAINTS: 1 <= nums.length <= 3 * 10^4
     *              -2^31 <= nums[i] <= 2^31 - 1 */

    // TIME COMPLEXITY  : O(n)
    //SPACE COMPLEXITY  : O(1)
    private static void moveZeroes(Integer[] nums) {
        int writePointer = 0;

        for (int readPointer = 0; readPointer < nums.length; readPointer++) {
            if (nums[readPointer] != 0) {
                ArrayUtilities.swap(nums, readPointer, writePointer);
                writePointer++;
            }
        }
    }
}
