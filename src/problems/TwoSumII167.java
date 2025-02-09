package problems;

import java.util.Arrays;

// DIFFICULTY   : Medium
// TOPICS       : Array, Two Pointers, Binary Search
public class TwoSumII167 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{2, 7, 11, 15};
        int target1 = 9;
        System.out.printf("TWO SUM: %s %s %s%n", Arrays.toString(twoSumUsingBruteForce(nums1, target1)), Arrays.toString(twoSumUsingTwoPointers(nums1, target1)), Arrays.toString(twoSumUsingTwoRecursion(nums1, target1)));

        int[] nums2 = new int[]{2, 3, 4};
        int target2 = 6;
        System.out.printf("TWO SUM: %s %s %s%n", Arrays.toString(twoSumUsingBruteForce(nums2, target2)), Arrays.toString(twoSumUsingTwoPointers(nums2, target2)), Arrays.toString(twoSumUsingTwoRecursion(nums2, target2)));

        int[] nums3 = new int[]{-1, 0};
        int target3 = -1;
        System.out.printf("TWO SUM: %s %s %s%n", Arrays.toString(twoSumUsingBruteForce(nums3, target3)), Arrays.toString(twoSumUsingTwoPointers(nums3, target3)), Arrays.toString(twoSumUsingTwoRecursion(nums3, target3)));

        int[] nums4 = new int[]{3, 24, 50, 79, 88, 150, 345};
        int target4 = 200;
        System.out.printf("TWO SUM: %s %s %s%n", Arrays.toString(twoSumUsingBruteForce(nums4, target4)), Arrays.toString(twoSumUsingTwoPointers(nums4, target4)), Arrays.toString(twoSumUsingTwoRecursion(nums4, target4)));
    }

    /* CONSTRAINTS: 2 <= nums.length <= 3 * 10^4
                    -1000 <= nums[i] <= 1000
                    -1000 <= target <= 1000
                    numbers is sorted in non-decreasing order.
                    The tests are generated such that there is exactly one solution. */

    // TIME COMPLEXITY  : O(n^2)
    // SPACE COMPLEXITY : O(1)
    private static int[] twoSumUsingBruteForce(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = (i + 1); j < numbers.length; j++) {
                if (i != j && ((numbers[i] + numbers[j]) == target)) {
                    return new int[]{(Math.min(i, j) + 1), (Math.max(i, j) + 1)};
                }
            }
        }

        return new int[]{-1, -1};
    }

    // TIME COMPLEXITY  : O(n)
    // SPACE COMPLEXITY : O(1)
    private static int[] twoSumUsingTwoPointers(int[] numbers, int target) {
        int left = 0, right = (numbers.length - 1);

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum < target) left++;
            else if (sum > target) right--;
            else return new int[]{left + 1, right + 1};
        }

        return new int[]{-1, -1};
    }

    // TIME COMPLEXITY  : O()
    // SPACE COMPLEXITY : O()
    private static int[] twoSumUsingTwoRecursion(int[] numbers, int target) {
        return twoSumUsingTwoRecursion(numbers, target, 0, (numbers.length - 1));
    }

    private static int[] twoSumUsingTwoRecursion(int[] numbers, int target, int left, int right) {
        int sum = numbers[left] + numbers[right];

        if (sum == target) return new int[]{left + 1, right + 1};
        else if (sum < target) {
            left++;
            return twoSumUsingTwoRecursion(numbers, target, left, right);
        } else {
            right--;
            return twoSumUsingTwoRecursion(numbers, target, left, right);
        }
    }
}
