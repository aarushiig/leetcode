package problems;

import java.util.Arrays;

// DIFFICULTY   : Easy
// TOPICS       : Array
public class ReplaceElementsWithGreatestElementOnRightSide1299 {
    public static void main(String[] args) {
        System.out.printf("MODIFIED ARRAY: %s%n", Arrays.toString(replaceElements(new int[]{17, 18, 5, 4, 6, 1})));
        System.out.printf("MODIFIED ARRAY: %s%n", Arrays.toString(replaceElements(new int[]{400})));
    }

    /* CONSTRAINTS: 1 <= arr.length <= 10^4
     *              1 <= arr[i] <= 10^5 */

    // TIME COMPLEXITY  : O(n)
    // SPACE COMPLEXITY : O(1)
    private static int[] replaceElements(int[] arr) {
        int greatestElement = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            greatestElement = Math.max(arr[i], arr[i] = greatestElement);
        }

        return arr;
    }
}
