package problems;

// DIFFICULTY   : Easy
// TOPICS       : Array, Binary Search
public class BinarySearch704 {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 3, 5, 9, 12};

        int target1 = 9;
        System.out.printf("SEARCH: %d %d %d %d%n", search(nums, target1), searchByRecursion(nums, target1), searchUsingUpperBound(nums, target1), searchUsingLowerBound(nums, target1));

        int target2 = 2;
        System.out.printf("SEARCH: %d %d %d %d%n", search(nums, target2), searchByRecursion(nums, target2), searchUsingUpperBound(nums, target2), searchUsingLowerBound(nums, target2));
    }

    /* CONSTRAINTS: 1 <= nums.length <= 10^4
                    -10^4 < nums[i], target < 10^4
                     All the integers in nums are unique.
                     nums is sorted in ascending order. */

    // TIME COMPLEXITY  : O(logn)
    // SPACE COMPLEXITY : O(1)
    private static int search(int[] nums, int target) {
        int low = 0, high = (nums.length - 1);

        while (low <= high) {
            int middle = (low + high) / 2;

            if (nums[middle] == target) return middle;
            else if (nums[middle] < target) low = middle + 1;
            else high = middle - 1;
        }

        return -1;
    }

    // TIME COMPLEXITY  : O(logn)
    // SPACE COMPLEXITY : O(1)
    private static int searchByRecursion(int[] nums, int target) {
        return searchByRecursion(nums, target, 0, (nums.length - 1));
    }

    private static int searchByRecursion(int[] nums, int target, int low, int high) {
        if (low > high) return -1;

        int middle = (low + high) / 2;

        if (nums[middle] == target) return middle;
        else if (nums[middle] < target) return searchByRecursion(nums, target, (middle + 1), high);
        else return searchByRecursion(nums, target, low, (middle - 1));
    }

    // TIME COMPLEXITY  : O(logn)
    // SPACE COMPLEXITY : O(1)
    private static int searchUsingUpperBound(int[] nums, int target) {
        int low = 0, high = nums.length;

        while (low < high) {
            int middle = (low + high) / 2;

            if (nums[middle] <= target) low = middle + 1;
            else high = middle;
        }

        if (low > 0 && nums[low - 1] == target) return low - 1;
        else return -1;
    }

    // TIME COMPLEXITY  : O(logn)
    // SPACE COMPLEXITY : O(1)
    private static int searchUsingLowerBound(int[] nums, int target) {
        int low = 0, high = nums.length;

        while (low < high) {
            int middle = (low + high) / 2;

            if (nums[middle] >= target) high = middle;
            else low = middle + 1;
        }

        if (low < nums.length && nums[low] == target) return low;
        else return -1;
    }
}
