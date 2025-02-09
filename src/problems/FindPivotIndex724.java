package problems;

// DIFFICULTY   : Easy
// TOPICS       : Array, Prefix Sum
public class FindPivotIndex724 {
    public static void main(String[] args) {
        System.out.printf("PIVOT INDEX: %d %d %d%n", pivotIndexUsingBruteForce(new int[]{1, 7, 3, 6, 5, 6}), pivotIndexUsingLeftAndRightSumArrays(new int[]{1, 7, 3, 6, 5, 6}), pivotIndexUsingPrefixSum(new int[]{1, 7, 3, 6, 5, 6}));

        System.out.printf("PIVOT INDEX: %d %d %d%n", pivotIndexUsingBruteForce(new int[]{1, 2, 3}), pivotIndexUsingLeftAndRightSumArrays(new int[]{1, 2, 3}), pivotIndexUsingPrefixSum(new int[]{1, 2, 3}));

        System.out.printf("PIVOT INDEX: %d %d %d%n", pivotIndexUsingBruteForce(new int[]{2, 1, -1}), pivotIndexUsingLeftAndRightSumArrays(new int[]{2, 1, -1}), pivotIndexUsingPrefixSum(new int[]{2, 1, -1}));
    }

    /* CONSTRAINTS: 1 <= nums.length <= 10^4
     *              -1000 <= nums[i] <= 1000 */

    // TIME COMPLEXITY  : O(n^2)
    // SPACE COMPLEXITY : O(1)
    private static int pivotIndexUsingBruteForce(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int leftSum = 0;
            for (int left = 0; left < i; left++) {
                leftSum += nums[left];
            }

            int rightSum = 0;
            for (int right = i + 1; right < nums.length; right++) {
                rightSum += nums[right];
            }

            if (leftSum == rightSum) return i;
        }

        return -1;
    }

    // TIME COMPLEXITY  : O(n)
    // SPACE COMPLEXITY : O(n)
    private static int pivotIndexUsingLeftAndRightSumArrays(int[] nums) {
        int[] sumLeft = new int[nums.length];
        sumLeft[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            sumLeft[i] = sumLeft[i - 1] + nums[i - 1];
        }

        int[] sumRight = new int[nums.length];
        sumRight[nums.length - 1] = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            sumRight[i] = sumRight[i + 1] + nums[i + 1];
        }

        for (int i = 0; i < nums.length; i++) {
            if (sumLeft[i] == sumRight[i]) return i;
        }

        return -1;
    }

    // TIME COMPLEXITY  : O(n)
    // SPACE COMPLEXITY : O(1)
    private static int pivotIndexUsingPrefixSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }

        for (int i = 0; i < nums.length; i++) {
            int prefixSumLeftOfIndex = 0;
            if (i > 0) prefixSumLeftOfIndex = nums[i - 1];

            int rightMostPrefixSum = nums[nums.length - 1];
            int prefixSumAtIndex = nums[i];

            if (prefixSumLeftOfIndex == rightMostPrefixSum - prefixSumAtIndex) return i;
        }

        return -1;
    }
}
