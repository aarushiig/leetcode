package problems;

import java.util.Arrays;

// DIFFICULTY   : Easy
// TOPICS       : Array, Two Pointers, Sorting
public class SquaresOfASortedArray977 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{-4, -1, 0, 3, 10};
        System.out.printf("SORTED SQUARES: %s%n", Arrays.toString(sortedSquaresUsingTwoPointers(nums1)));
        System.out.printf("SORTED SQUARES: %s%n", Arrays.toString(sortedSquaresBySquaringAndSorting(nums1)));

        int[] nums2 = new int[]{-7, -3, 2, 3, 11};
        System.out.printf("SORTED SQUARES: %s%n", Arrays.toString(sortedSquaresUsingTwoPointers(nums2)));
        System.out.printf("SORTED SQUARES: %s%n", Arrays.toString(sortedSquaresBySquaringAndSorting(nums2)));

        int[] nums3 = new int[]{-4, -2, 2, 4};
        System.out.printf("SORTED SQUARES: %s%n", Arrays.toString(sortedSquaresUsingTwoPointers(nums3)));
        System.out.printf("SORTED SQUARES: %s%n", Arrays.toString(sortedSquaresBySquaringAndSorting(nums3)));
    }

    /* CONSTRAINTS: 1 <= nums.length <= 10^4
     *              -10^4 <= nums[i] <= 10^4
     *              nums is sorted in non-decreasing (equal or increasing) order. */

    // TIME COMPLEXITY  : O(n)
    // SPACE COMPLEXITY : O(1)
    private static int[] sortedSquaresUsingTwoPointers(int[] nums) {
        int[] squares = new int[nums.length];

        int left = 0, right = nums.length - 1;

        for (int pointer = (squares.length - 1); pointer >= 0; pointer--) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                squares[pointer] = nums[left] * nums[left];
                left++;
            } else {
                squares[pointer] = nums[right] * nums[right];
                right--;
            }
        }

        return squares;
    }

    // TIME COMPLEXITY  : O(n + n.logn) ~ O(n.logn)
    // SPACE COMPLEXITY : O(1)
    private static int[] sortedSquaresBySquaringAndSorting(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] *= nums[i];
        }

        Arrays.sort(nums);

        return nums;
    }
}
