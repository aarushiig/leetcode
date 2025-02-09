package problems;

import java.util.Arrays;

// DIFFICULTY   : Easy

// TOPICS       : Array, Two Pointers, Sorting

public class MergeSortedArray88 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        System.out.printf("ORIGINAL: %s%n", Arrays.toString(nums1));
        System.out.printf("ORIGINAL: %s%n", Arrays.toString(nums2));
        mergeUsingInPlaceModifications(nums1, 3, nums2, 3);
        System.out.printf("MERGED: %s%n%n", Arrays.toString(nums1));

        int[] nums3 = new int[]{1};
        int[] nums4 = new int[]{};
        System.out.printf("ORIGINAL: %s%n", Arrays.toString(nums3));
        System.out.printf("ORIGINAL: %s%n", Arrays.toString(nums4));
        mergeUsingInPlaceModifications(nums3, 1, nums4, 0);
        System.out.printf("MERGED: %s%n%n", Arrays.toString(nums3));

        int[] nums5 = new int[]{0};
        int[] nums6 = new int[]{1};
        System.out.printf("ORIGINAL: %s%n", Arrays.toString(nums5));
        System.out.printf("ORIGINAL: %s%n", Arrays.toString(nums6));
        mergeUsingInPlaceModifications(nums5, 0, nums6, 1);
        System.out.printf("MERGED: %s%n%n", Arrays.toString(nums5));
    }

    /* CONSTRAINTS: nums1.length == m + n
     *              nums2.length == n
     *              0 <= m, n <= 200
     *              1 <= m + n <= 200
     *              -10^9 <= nums1[i], nums2[j] <= 10^9 */

    // TIME COMPLEXITY  : O(m + n)
    // SPACE COMPLEXITY : O(1)
    private static void mergeUsingInPlaceModifications(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }

    // TIME COMPLEXITY  : O(m + n)
    // SPACE COMPLEXITY : O(m + n)
    private static void mergeUsingAnExtraArray(int[] nums1, int m, int[] nums2, int n) {
        int[] merge = new int[m + n];

        for (int i = 0, j = 0, k = 0; k < merge.length; k++) {
            if (i < m && j < n) {
                if (nums1[i] < nums2[j]) {
                    merge[k] = nums1[i];
                    i++;
                } else if (nums2[j] < nums1[i]) {
                    merge[k] = nums2[j];
                    j++;
                } else {
                    merge[k] = nums1[i];
                    merge[k + 1] = nums2[j];

                    i++;
                    j++;
                    k++;
                }
            } else if (i < m) {
                merge[k] = nums1[i];
                i++;
            } else if (j < n) {
                merge[k] = nums2[j];
                j++;
            }
        }

        System.arraycopy(merge, 0, nums1, 0, nums1.length);
    }
}
