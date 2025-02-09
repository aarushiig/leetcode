package problems;

// DIFFICULTY   : Medium
// TOPICS       : Array, Binary Search, Sliding Window, Prefix Sum
public class MinimizeSizeSubarraySum209 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{2, 3, 1, 2, 4, 3};
        int target1 = 7;
        System.out.printf("MINIMUM LENGTH: %s%n", minSubArrayLenUsingTwoLoops(target1, nums1));

        int[] nums2 = new int[]{1, 4, 4};
        int target2 = 4;
        System.out.printf("MINIMUM LENGTH: %s%n", minSubArrayLenUsingTwoLoops(target2, nums2));

        int[] nums3 = new int[]{1, 1, 1, 1, 1, 1, 1, 1};
        int target3 = 11;
        System.out.printf("MINIMUM LENGTH: %s%n", minSubArrayLenUsingTwoLoops(target3, nums3));
    }

    /* CONSTRAINTS: 1 <= target <= 10^9
                    1 <= nums.length <=10^5
                    1 <= nums[i] <= 10^4 */

    // TIME COMPLEXITY  : O(n^2)
    // SPACE COMPLEXITY : O(1)
    private static int minSubArrayLenUsingTwoLoops(int target, int[] nums) {
        int minimumLength = (nums.length + 1);

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < Math.min(i + minimumLength, nums.length); j++) {
                sum += nums[j];
                if (sum >= target) {
                    minimumLength = Math.min(minimumLength, (j - i + 1));
                    break;
                }
            }
        }

        return (minimumLength > nums.length) ? 0 : minimumLength;
    }

    // TIME COMPLEXITY  : O()
    // SPACE COMPLEXITY : O()
    private static int minSubArrayLen(int target, int[] nums) {
        return 0;
    }
}
