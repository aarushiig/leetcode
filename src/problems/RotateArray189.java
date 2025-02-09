package problems;

import java.util.Arrays;

// DIFFICULTY   : Medium
// TOPICS       : Array, Math, Two Pointers
public class RotateArray189 {
    public static void main(String[] args) {
        int k0 = 1;
        int[] nums0 = new int[]{1};
        rotateInPlace(nums0, k0);
        System.out.printf("ROTATE ARRAY: %s%n", Arrays.toString(nums0));

        int k1 = 3;
        int[] nums1 = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotateInPlace(nums1, k1);
        System.out.printf("ROTATE ARRAY: %s%n", Arrays.toString(nums1));

        int k2 = 2;
        int[] nums2 = new int[]{-1, -100, 3, 99};
        rotateInPlace(nums2, k2);
        System.out.printf("ROTATE ARRAY: %s%n", Arrays.toString(nums2));

        int k3 = 2;
        int[] nums3 = new int[]{1, 2, 3, 4, 5, 6};
        rotateInPlace(nums3, k3);
        System.out.printf("ROTATE ARRAY: %s%n", Arrays.toString(nums3));

        int k4 = 2;
        int[] nums4 = new int[]{-1};
        rotateInPlace(nums4, k4);
        System.out.printf("ROTATE ARRAY: %s%n", Arrays.toString(nums4));

        int k5 = 3;
        int[] nums5 = new int[]{1, 2};
        rotateInPlace(nums5, k5);
        System.out.printf("ROTATE ARRAY: %s%n", Arrays.toString(nums5));
    }

    /* CONSTRAINTS: 1 <= nums.length <=10^5
                    -2^31 <= nums[i] <= 2^31 -1
                    0 <= k <= 10^5 */

    // TIME COMPLEXITY  : O(n)
    // SPACE COMPLEXITY : O(n)
    private static void rotateUsingAdditionalArray(int[] nums, int k) {
        if (k == 0) return;

        int[] rotatedNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            rotatedNums[(i + k) % nums.length] = nums[i];
        }

        System.arraycopy(rotatedNums, 0, nums, 0, nums.length);
    }

    private static void rotateInPlace(int[] nums, int k) {
        if (k == 0 || k >= nums.length) return;

        int i = k, elementOnTheMove = nums[0], elementBeingReplaced = nums[k], steps = 0;

        boolean isStepsAndLengthEven = (k % 2 == 0) && (nums.length % 2 == 0);
        int counter = 0, maxCounter = (nums.length / k);

        while (steps < (nums.length + 1)) {
            nums[i] = elementOnTheMove;
            steps++;

            if (isStepsAndLengthEven) {
                if (counter == maxCounter) {
                    elementOnTheMove = nums[i - 1];
                    i = ((i - 1 + k) % nums.length);
                    elementBeingReplaced = nums[i];

                    counter = 0;
                } else {
                    i = (i + k) % nums.length;
                    elementOnTheMove = elementBeingReplaced;
                    elementBeingReplaced = nums[i];

                    counter++;
                }
            } else {
                i = (i + k) % nums.length;
                elementOnTheMove = elementBeingReplaced;
                elementBeingReplaced = nums[i];
            }
        }
    }
}
