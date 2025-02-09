package problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// DIFFICULTY   : Easy
// TOPICS       : Array, Hash Table
public class TwoSum1 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{2, 7, 11, 15};
        System.out.printf("TWO SUM: %s %s%n", Arrays.toString(twoSumUsingBruteForce(nums1, 9)), Arrays.toString(twoSumUsingHashMap(nums1, 9)));

        int[] nums2 = new int[]{3, 2, 4};
        System.out.printf("TWO SUM: %s %s%n", Arrays.toString(twoSumUsingBruteForce(nums2, 6)), Arrays.toString(twoSumUsingHashMap(nums2, 6)));

        int[] nums3 = new int[]{3, 3};
        System.out.printf("TWO SUM: %s %s%n", Arrays.toString(twoSumUsingBruteForce(nums3, 6)), Arrays.toString(twoSumUsingHashMap(nums3, 6)));

    }

    /* CONSTRAINTS: 2 <= nums.length <= 10^4
                    -10^9 <= nums[i] <= 10^9
                    -10^9 <= target <= 10^9
                    Only one valid answer exists. */

    // TIME COMPLEXITY  : O(n^2)
    // SPACE COMPLEXITY : O(1)
    private static int[] twoSumUsingBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = (i + 1); j < nums.length; j++) {
                if (i != j && ((nums[i] + nums[j]) == target)) return new int[]{i, j};
            }
        }

        return new int[]{-1, -1};
    }

    // TIME COMPLEXITY  : O(n)
    // SPACE COMPLEXITY : O(n)
    private static int[] twoSumUsingHashMap(int[] nums, int target) {
        Map<Integer, Integer> arrayToMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            arrayToMap.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int search = target - nums[i];

            int j = arrayToMap.getOrDefault(search, -1);
            if (j != -1 && j != i) return new int[]{i, j};
        }

        return new int[]{-1, -1};
    }
}
