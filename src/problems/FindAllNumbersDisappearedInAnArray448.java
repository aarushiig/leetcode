package problems;

import utility.ArrayUtilities;

import java.util.*;

// DIFFICULTY   : Easy
// TOPICS       : Array, Hash Table
public class FindAllNumbersDisappearedInAnArray448 {
    public static void main(String[] args) {
        System.out.printf("DISAPPEARED NUMBERS: %s %s %s %s %s %s %s%n", findDisappearedNumbersUsingBruteForce(new int[]{4, 3, 2, 7, 8, 2, 3, 1}), findDisappearedNumbersUsingSortingAndBinarySearch(new int[]{4, 3, 2, 7, 8, 2, 3, 1}), findDisappearedNumbersUsingHashMap(new int[]{4, 3, 2, 7, 8, 2, 3, 1}), findDisappearedNumbersUsingHashSet(new int[]{4, 3, 2, 7, 8, 2, 3, 1}), findDisappearedNumbersUsingCountingArray(new int[]{4, 3, 2, 7, 8, 2, 3, 1}), findDisappearedNumbersByPlacingElementsAtRightIndex(new Integer[]{4, 3, 2, 7, 8, 2, 3, 1}), findDisappearedNumbersUsingNegationToMarkAsSeen(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
        System.out.printf("DISAPPEARED NUMBERS: %s %s %s %s %s %s %s%n", findDisappearedNumbersUsingBruteForce(new int[]{1, 1}), findDisappearedNumbersUsingSortingAndBinarySearch(new int[]{1, 1}), findDisappearedNumbersUsingHashMap(new int[]{1, 1}), findDisappearedNumbersUsingHashSet(new int[]{1, 1}), findDisappearedNumbersUsingCountingArray(new int[]{1, 1}), findDisappearedNumbersByPlacingElementsAtRightIndex(new Integer[]{1, 1}), findDisappearedNumbersUsingNegationToMarkAsSeen(new int[]{1, 1}));
    }

    /* CONSTRAINTS: n = nums.length
     *              1 <= n <= 10^5
     *              1 <= nums[i] <= n */

    // TIME COMPLEXITY  : O(n^2)
    // SPACE COMPLEXITY : O(1)
    private static List<Integer> findDisappearedNumbersUsingBruteForce(int[] nums) {
        List<Integer> disappearedNumbers = new ArrayList<>();

        for (int i = 1; i <= nums.length; i++) {
            boolean found = false;

            for (int num : nums) {
                if (i == num) {
                    found = true;
                    break;
                }
            }

            if (!found) disappearedNumbers.add(i);
        }

        return disappearedNumbers;
    }

    // TIME COMPLEXITY  : O(n.logn)
    // SPACE COMPLEXITY : O(1)
    private static List<Integer> findDisappearedNumbersUsingSortingAndBinarySearch(int[] nums) {
        Arrays.sort(nums);

        List<Integer> disappearedNumbers = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            boolean found = false;

            int low = 0, high = nums.length - 1;
            while (low <= high) {
                int middle = (low + high) / 2;

                if (nums[middle] == i) {
                    found = true;
                    break;
                }

                if (i < nums[middle]) high = middle - 1;
                else low = middle + 1;
            }

            if (!found) disappearedNumbers.add(i);
        }

        return disappearedNumbers;
    }

    // TIME COMPLEXITY  : O(n)
    // SPACE COMPLEXITY : O(n)
    private static List<Integer> findDisappearedNumbersUsingHashMap(int[] nums) {
        Map<Integer, Integer> numberFrequency = new HashMap<>();
        for (int num : nums) {
            numberFrequency.put(num, numberFrequency.getOrDefault(num, 0) + 1);
        }

        List<Integer> disappearedNumbers = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            if (!numberFrequency.containsKey(i)) disappearedNumbers.add(i);
        }

        return disappearedNumbers;
    }

    // TIME COMPLEXITY  : O(n)
    // SPACE COMPLEXITY : O(n)
    private static List<Integer> findDisappearedNumbersUsingHashSet(int[] nums) {
        Set<Integer> numberFrequency = new HashSet<>();
        for (int num : nums) {
            numberFrequency.add(num);
        }

        List<Integer> disappearedNumbers = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            if (!numberFrequency.contains(i)) disappearedNumbers.add(i);
        }

        return disappearedNumbers;
    }

    // TIME COMPLEXITY  : O(n)
    // SPACE COMPLEXITY : O(n)
    private static List<Integer> findDisappearedNumbersUsingCountingArray(int[] nums) {
        int[] numberFrequency = new int[nums.length + 1];
        for (int num : nums) {
            numberFrequency[num]++;
        }

        List<Integer> disappearedNumbers = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            if (numberFrequency[i] == 0) disappearedNumbers.add(i);
        }

        return disappearedNumbers;
    }

    // TIME COMPLEXITY  : O(n)
    // SPACE COMPLEXITY : O(1)
    private static List<Integer> findDisappearedNumbersByPlacingElementsAtRightIndex(Integer[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i + 1 && !nums[nums[i] - 1].equals(nums[i])) {
                ArrayUtilities.swap(nums, nums[i] - 1, i);
            }
        }

        List<Integer> disappearingNumbers = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) disappearingNumbers.add(i + 1);
        }

        return disappearingNumbers;
    }

    // TIME COMPLEXITY  : O(n)
    // SPACE COMPLEXITY : O(1)
    private static List<Integer> findDisappearedNumbersUsingNegationToMarkAsSeen(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[Math.abs(nums[i]) - 1] = -Math.abs(nums[Math.abs(nums[i]) - 1]);
        }

        List<Integer> disappearingNumbers = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) disappearingNumbers.add(i + 1);
        }

        return disappearingNumbers;
    }
}
