package problems;

import java.util.Arrays;

// DIFFICULTY   : Easy
// TOPICS       : Array, Sorting, Counting Sort
public class HeightChecker1051 {
    public static void main(String[] args) {
        System.out.printf("COUNT: %s %s %n", heightCheckerByComparingWithAnExtraSortedArray(new int[]{1, 1, 4, 2, 1, 3}), heightCheckerUsingCountingSort(new int[]{1, 1, 4, 2, 1, 3}));
        System.out.printf("COUNT: %s %s %n", heightCheckerByComparingWithAnExtraSortedArray(new int[]{5, 1, 2, 3, 4}), heightCheckerUsingCountingSort(new int[]{5, 1, 2, 3, 4}));
        System.out.printf("COUNT: %s %s %n", heightCheckerByComparingWithAnExtraSortedArray(new int[]{1, 2, 3, 4, 5}), heightCheckerUsingCountingSort(new int[]{1, 2, 3, 4, 5}));
        System.out.printf("COUNT: %s %s %n", heightCheckerByComparingWithAnExtraSortedArray(new int[]{1}), heightCheckerUsingCountingSort(new int[]{1}));
    }

    /* CONSTRAINTS: 1 <= heights.length <= 100
     *              1 <= heights[i] <= 100 */

    // TIME COMPLEXITY  : O(n.logn)
    // SPACE COMPLEXITY : O(n)
    private static int heightCheckerByComparingWithAnExtraSortedArray(int[] heights) {
        int[] expected = new int[heights.length];
        System.arraycopy(heights, 0, expected, 0, heights.length);
        Arrays.sort(expected);

        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != expected[i]) count++;
        }

        return count;
    }

    // TIME COMPLEXITY  : O(n + k)
    // SPACE COMPLEXITY : O(n + k)
    private static int heightCheckerUsingCountingSort(int[] heights) {
        // COUNTING SORT (STABLE, TC: O(n + k), SC: O(n + k))
        // Calculate the frequency of each element.
        int[] heightsCS = new int[101];
        for (int height : heights) {
            heightsCS[height]++;
        }

        // Calculate the running sum of the frequency array.
        for (int i = 1; i < heightsCS.length; i++) {
            heightsCS[i] += heightsCS[i - 1];
        }

        // Shift the elements of the frequency array right by one, to calculate the starting index of each element of the sorted array.
        for (int i = heightsCS.length - 1; i > 0; i--) {
            heightsCS[i] = heightsCS[i - 1];
        }
        heightsCS[0] = 0;

        // Generate the sorted array.
        int[] expected = new int[heights.length];
        for (int height : heights) {
            expected[heightsCS[height]++] = height;
        }

        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != expected[i]) count++;
        }

        return count;
    }
}
