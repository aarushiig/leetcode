package problems;

// DIFFICULTY   : Easy
// TOPICS       : Array
public class MaxConsecutiveOnes485 {
    public static void main(String[] args) {
        System.out.printf("MAX CONSECUTIVE ONES: %d%n", findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1}));
        System.out.printf("MAX CONSECUTIVE ONES: %d%n", findMaxConsecutiveOnes(new int[]{1, 0, 1, 1, 0, 1}));
        System.out.printf("MAX CONSECUTIVE ONES: %d%n", findMaxConsecutiveOnes(new int[]{1}));
        System.out.printf("MAX CONSECUTIVE ONES: %d%n", findMaxConsecutiveOnes(new int[]{0}));
    }

    /* CONSTRAINTS: 1 <= nums.length <= 10^5
     *              nums[i] is either 0 or 1. */

    // TIME COMPLEXITY  : O(n)
    // SPACE COMPLEXITY : O(1)
    private static int findMaxConsecutiveOnes(int[] nums) {
        int maxConsecutiveOnes = 0, consecutiveOnes = 0;

        for (int num : nums) {
            if (num == 1) {
                consecutiveOnes++;
                maxConsecutiveOnes = Math.max(consecutiveOnes, maxConsecutiveOnes);
            } else {
                consecutiveOnes = 0;
            }
        }

        return maxConsecutiveOnes;
    }
}
