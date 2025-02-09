package problems;

import utility.ArrayUtilities;

import java.util.Arrays;

// DIFFICULTY   : Easy
// TOPICS       : Array, Two Pointers, Sorting
public class SortArrayByParity905 {
    public static void main(String[] args) {
        System.out.printf("MODIFIED ARRAY: %s%n", Arrays.toString(sortArrayByParity(new Integer[]{3, 1, 2, 4})));
        System.out.printf("MODIFIED ARRAY: %s%n", Arrays.toString(sortArrayByParity(new Integer[]{0})));
        System.out.printf("MODIFIED ARRAY: %s%n", Arrays.toString(sortArrayByParity(new Integer[]{1, 2, 3, 4})));
        System.out.printf("MODIFIED ARRAY: %s%n", Arrays.toString(sortArrayByParity(new Integer[]{4, 3, 2, 1})));
    }

    /* CONSTRAINTS: 1 <= nums.length <= 5000
     *              0 <= nums[i] <= 5000 */

    // TIME COMPLEXITY  : O(n)
    //SPACE COMPLEXITY  : O(1)
    private static Integer[] sortArrayByParity(Integer[] nums) {
        int writerPointer = 0;

        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & 1) == 0) {
                ArrayUtilities.swap(nums, i, writerPointer);
                writerPointer++;
            }
        }

        return nums;
    }
}
