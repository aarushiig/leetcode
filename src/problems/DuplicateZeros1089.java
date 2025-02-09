package problems;

import java.util.Arrays;

// DIFFICULTY   : Easy
// TOPICS       : Array, Two Pointers
public class DuplicateZeros1089 {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 0, 2, 3, 0, 4, 5, 0};
        System.out.printf("ORIGINAL: %s%n", Arrays.toString(arr1));
        duplicateZerosUsingTwoPass(arr1);
        System.out.printf("MODIFIED: %s%n%n", Arrays.toString(arr1));

        int[] arr2 = new int[]{1, 2, 3};
        System.out.printf("ORIGINAL: %s%n", Arrays.toString(arr2));
        duplicateZerosUsingTwoPass(arr2);
        System.out.printf("MODIFIED: %s%n%n", Arrays.toString(arr2));

        int[] arrEC = new int[]{8, 5, 4, 0, 0, 0, 0, 7};
        System.out.printf("ORIGINAL: %s%n", Arrays.toString(arrEC));
        duplicateZerosUsingTwoPass(arrEC);
        System.out.printf("MODIFIED: %s%n%n", Arrays.toString(arrEC));
    }

    /* CONSTRAINTS: 1 <= arr.length <= 10^4
     *              0 <= arr[i] <= 9 */

    // TIME COMPLEXITY  : O(n^2)
    // SPACE COMPLEXITY : O(1)
    private static void duplicateZerosUsingInPlaceModifications(int[] arr) {
        for (int i = 0; i < (arr.length - 1); i++) {
            if (arr[i] == 0) {
                for (int j = (arr.length - 1); j > (i + 1); j--) {
                    arr[j] = arr[j - 1];
                }

                arr[i + 1] = 0;
                i++;
            }
        }
    }

    // TIME COMPLEXITY  : O(n)
    // SPACE COMPLEXITY : O(n)
    private static void duplicateZerosUsingAnExtraArray(int[] arr) {
        int[] duplicateZeros = new int[arr.length];

        int arrItereator = 0;
        for (int i = 0; i < duplicateZeros.length; i++) {
            if (arr[arrItereator] == 0) {
                duplicateZeros[i] = duplicateZeros[i + 1] = 0;
                i++;
            } else {
                duplicateZeros[i] = arr[arrItereator];
            }

            arrItereator++;
        }

        System.arraycopy(duplicateZeros, 0, arr, 0, arr.length);
    }

    // TIME COMPLEXITY  : O(n)
    // SPACE COMPLEXITY : O(1)
    private static void duplicateZerosUsingTwoPass(int[] arr) {
        // FIRST PASS: Find the number of zeros to be duplicated.
        //             We stop counting when we iterate beyond the last element in the OG array that would be a part of the modified array.
        int countOfZerosToBeDuplicated = 0;
        int lastModifiedElementIndex = arr.length - 1;
        for (int i = 0; i <= lastModifiedElementIndex - countOfZerosToBeDuplicated; i++) {
            if (arr[i] == 0) {
                // EDGE CASE: When the last (boundary) element of the OG array that would be present in the modified array is zero,
                //            it can't be duplicated as there is no more space available.
                if (i == lastModifiedElementIndex - countOfZerosToBeDuplicated) {
                    arr[lastModifiedElementIndex] = 0;    // We just copy this zero into the modified array w/o duplication.
                    lastModifiedElementIndex--;
                    break;
                }

                countOfZerosToBeDuplicated++;
            }
        }

        // SECOND PASS: Iterate through the array backwards starting from the last element of the OG array that would be a part of the modified array.
        //              Copy the zeros twice, and non-zeros once.
        for (int i = (lastModifiedElementIndex - countOfZerosToBeDuplicated); i >= 0; i--) {
            if (arr[i] == 0) {
                arr[i + countOfZerosToBeDuplicated] = 0;
                arr[i + countOfZerosToBeDuplicated - 1] = 0;

                countOfZerosToBeDuplicated--;
            } else {
                arr[i + countOfZerosToBeDuplicated] = arr[i];
            }
        }
    }
}
