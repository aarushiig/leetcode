package problems;

// DIFFICULTY   : Easy
// TOPICS       : Array
public class ValidMountainArray941 {
    public static void main(String[] args) {
        System.out.printf("VALID MOUNTAIN ARRAY: %B %b %B%n", validMountainArray(new int[]{2, 1}), validMountainArrayUsingTwoPointersClimbingDown(new int[]{2, 1}), validMountainArrayUsingTwoPointersClimbingUp(new int[]{2, 1}));
        System.out.printf("VALID MOUNTAIN ARRAY: %B %b %B%n", validMountainArray(new int[]{1, 2}), validMountainArrayUsingTwoPointersClimbingDown(new int[]{1, 2}), validMountainArrayUsingTwoPointersClimbingUp(new int[]{1, 2}));
        System.out.printf("VALID MOUNTAIN ARRAY: %B %b %B%n", validMountainArray(new int[]{0, 0, 0}), validMountainArrayUsingTwoPointersClimbingDown(new int[]{0, 0, 0}), validMountainArrayUsingTwoPointersClimbingUp(new int[]{0, 0, 0}));
        System.out.printf("VALID MOUNTAIN ARRAY: %B %b %B%n", validMountainArray(new int[]{3, 5, 5}), validMountainArrayUsingTwoPointersClimbingDown(new int[]{3, 5, 5}), validMountainArrayUsingTwoPointersClimbingUp(new int[]{3, 5, 5}));
        System.out.printf("VALID MOUNTAIN ARRAY: %B %b %B%n", validMountainArray(new int[]{6, 5, 5}), validMountainArrayUsingTwoPointersClimbingDown(new int[]{6, 5, 5}), validMountainArrayUsingTwoPointersClimbingUp(new int[]{6, 5, 5}));
        System.out.printf("VALID MOUNTAIN ARRAY: %B %b %B%n", validMountainArray(new int[]{3, 6, 5, 6, 7, 6, 5, 3, 0}), validMountainArrayUsingTwoPointersClimbingDown(new int[]{3, 6, 5, 6, 7, 6, 5, 3, 0}), validMountainArrayUsingTwoPointersClimbingUp(new int[]{3, 6, 5, 6, 7, 6, 5, 3, 0}));
        System.out.printf("VALID MOUNTAIN ARRAY: %B %b %B%n", validMountainArray(new int[]{1, 7, 9, 5, 4, 1, 2}), validMountainArrayUsingTwoPointersClimbingDown(new int[]{1, 7, 9, 5, 4, 1, 2}), validMountainArrayUsingTwoPointersClimbingUp(new int[]{1, 7, 9, 5, 4, 1, 2}));
        System.out.printf("VALID MOUNTAIN ARRAY: %B %b %B%n", validMountainArray(new int[]{0, 3, 2, 1}), validMountainArrayUsingTwoPointersClimbingDown(new int[]{0, 3, 2, 1}), validMountainArrayUsingTwoPointersClimbingUp(new int[]{0, 3, 2, 1}));
    }

    /* CONSTRAINTS: 1 <= arr.length <= 10^4
     *              0 <= arr[i] <= 10^4 */

    // TIME COMPLEXITY  : O(n)
    // SPACE COMPLEXITY : O(1)
    private static boolean validMountainArray(int[] arr) {
        if (arr.length < 3) return false;

        int maxIndex = 0, i = 1;

        // STRICTLY INCREASING
        for (; i < arr.length; i++) {
            if (arr[i] > arr[maxIndex]) maxIndex = i;
            else break;
        }

        // STRICTLY DECREASING
        for (; i < arr.length; i++) {
            if (arr[i] >= arr[i - 1]) return false;
        }

        return maxIndex != 0 && maxIndex != (arr.length - 1);
    }

    // TIME COMPLEXITY  : O(n)
    // SPACE COMPLEXITY : O(1)
    private static boolean validMountainArrayUsingTwoPointersClimbingDown(int[] arr) {
        if (arr.length < 3) return false;

        int max = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[max]) max = i;
        }

        for (int leftOfMax = max - 1; leftOfMax >= 0; leftOfMax--) {
            if (arr[leftOfMax] >= arr[leftOfMax + 1]) return false;
        }


        for (int rightOfMax = max + 1; rightOfMax < arr.length; rightOfMax++) {
            if (arr[rightOfMax] >= arr[rightOfMax - 1]) return false;
        }

        return max != 0 && max != (arr.length - 1);
    }

    // TIME COMPLEXITY  : O(n)
    // SPACE COMPLEXITY : O(1)
    private static boolean validMountainArrayUsingTwoPointersClimbingUp(int[] arr) {
        if (arr.length < 3) return false;

        int left = 0, right = arr.length - 1;
        while ((left + 1 < arr.length) && (arr[left] < arr[left + 1])) left++;
        while ((right > 0) && (arr[right - 1] > arr[right])) right--;

        return (left != 0) && (left == right) && (right != arr.length - 1);
    }
}
