package problems;

import java.util.*;

// DIFFICULTY   : Easy
// TOPICS       : Array, Hash Table, Two Pointers, Binary Search, Sorting
public class CheckIfNAndItsDoubleExist1346 {
    public static void main(String[] args) {
        System.out.printf("CHECK: %s %s %s%n", checkIfExistUsingSetLookup(new int[]{10, 2, 5, 3}), checkIfExistUsingFrequencyHashMap(new int[]{10, 2, 5, 3}), checkIfExistsUsingBinarySearch(new int[]{10, 2, 5, 3}));
        System.out.printf("CHECK: %s %s %s%n", checkIfExistUsingSetLookup(new int[]{3, 1, 7, 11}), checkIfExistUsingFrequencyHashMap(new int[]{3, 1, 7, 11}), checkIfExistsUsingBinarySearch(new int[]{3, 1, 7, 11}));
        System.out.printf("CHECK: %s %s %s%n", checkIfExistUsingSetLookup(new int[]{0, 0}), checkIfExistUsingFrequencyHashMap(new int[]{0, 0}), checkIfExistsUsingBinarySearch(new int[]{0, 0}));
        System.out.printf("CHECK: %s %s %s%n", checkIfExistUsingSetLookup(new int[]{-2, 0, 10, -19, 4, 6, -8}), checkIfExistUsingFrequencyHashMap(new int[]{-2, 0, 10, -19, 4, 6, -8}), checkIfExistsUsingBinarySearch(new int[]{-2, 0, 10, -19, 4, 6, -8}));
    }

    /* CONSTRAINTS: 2 <= arr.length <= 500
     *              -10^3 <= arr[i] <= 10^3 */

    // TIME COMPLEXITY  : O(n)
    // SPACE COMPLEXITY : O(n)
    private static boolean checkIfExistUsingSetLookup(int[] arr) {
        Set<Integer> uniqueElements = new HashSet<>();

        for (int n : arr) {
            if (uniqueElements.contains(n * 2) || (n % 2 == 0 && uniqueElements.contains(n / 2))) return true;
            uniqueElements.add(n);
        }

        return false;
    }

    // TIME COMPLEXITY  : O(n)
    // SPACE COMPLEXITY : O(n)
    private static boolean checkIfExistUsingFrequencyHashMap(int[] arr) {
        Map<Integer, Integer> frequency = new HashMap<>();

        for (int n : arr) {
            frequency.put(n, frequency.getOrDefault(n, 0) + 1);
        }

        for (int n : arr) {
            if ((n != 0 && frequency.containsKey(n * 2)) || (n == 0 & frequency.get(n) > 1)) return true;
        }

        return false;
    }

    // TIME COMPLEXITY  : O(n.logn)
    // SPACE COMPLEXITY : O(logn)
    private static boolean checkIfExistsUsingBinarySearch(int[] arr) {
        // Implemented using a variant of the quick sort algorithm, Arrays.sort() has a space complexity of O(logn).
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            int index = binarySearch(arr, arr[i] * 2);
            if (index >= 0 && index != i) return true;
        }

        return false;
    }

    private static int binarySearch(int[] arr, int lookupTarget) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int middle = (left + right) / 2;

            if (lookupTarget == arr[middle]) return middle;

            if (lookupTarget < arr[middle]) right = middle - 1;
            if (lookupTarget > arr[middle]) left = middle + 1;
        }

        return -1;
    }
}
