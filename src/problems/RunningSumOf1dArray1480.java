package problems;

import java.util.Arrays;

// DIFFICULTY   : Easy
// TOPICS       : Array, Prefix Sum
public class RunningSumOf1dArray1480 {
    public static void main(String[] args) {
        System.out.printf("RUNNING SUM: %s%n", Arrays.toString(runningSum(new int[]{1, 2, 3, 4})));
        System.out.printf("RUNNING SUM: %s%n", Arrays.toString(runningSum(new int[]{1, 1, 1, 1, 1})));
        System.out.printf("RUNNING SUM: %s%n", Arrays.toString(runningSum(new int[]{3, 1, 2, 10, 1})));
    }

    /* CONSTRAINTS  : 1 <= nums.length <= 1000
     *                -10^6 <= nums[i] <= 10^6 */

    // TIME COMPLEXITY  : O(n)
    // SPACE COMPLEXITY : O(1)
    private static int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }

        return nums;
    }
}
