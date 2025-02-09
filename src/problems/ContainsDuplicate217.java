package problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// DIFFICULTY   : Easy
// TOPICS       : Array, Hash Table, Sorting
public class ContainsDuplicate217 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 1};
        System.out.printf("CONTAINS DUPLICATE?: %s %s%n", containsDuplicateUsingASet(nums1), containsDuplicateUsingSorting(nums1));

        int[] nums2 = new int[]{1, 2, 3, 4};
        System.out.printf("CONTAINS DUPLICATE?: %s %s%n", containsDuplicateUsingASet(nums2), containsDuplicateUsingSorting(nums2));

        int[] nums3 = new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.printf("CONTAINS DUPLICATE?: %s %s%n", containsDuplicateUsingASet(nums3), containsDuplicateUsingSorting(nums3));
    }

    /* CONSTRAINTS: 1 <= nums.length <= 10^5
                    -10^9 <= nums[i] <= 10^9 */

    // TIME COMPLEXITY  : O(n.logn)
    // SPACE COMPLEXITY : O(n)
    private static boolean containsDuplicateUsingASet(int[] nums) {
        Set<Integer> uniqueElements = new HashSet<>();
        for (int num : nums) {
            if (uniqueElements.contains(num)) return true;
            else uniqueElements.add(num);
        }

        return false;
    }

    // TIME COMPLEXITY  : O(n.logn)
    // SPACE COMPLEXITY : O(1)
    private static boolean containsDuplicateUsingSorting(int[] nums) {
        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) return true;
        }

        return false;
    }
}
