package problems;

// DIFFICULTY   : Easy
// TOPICS       : Array, Math
public class FindNumbersWithEvenNumberOfDigits1295 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{12, 345, 2, 6, 7896};
        System.out.printf("COUNT: %d %d %d %d%n", findNumbersByDigitExtraction(nums1), findNumbersByConvertingToString(nums1), findNumbersByLogarithm(nums1), findNumbersByConstraintAnalysis(nums1));

        int[] nums2 = new int[]{555, 901, 482, 1771};
        System.out.printf("COUNT: %d %d %d %d%n", findNumbersByDigitExtraction(nums2), findNumbersByConvertingToString(nums2), findNumbersByLogarithm(nums2), findNumbersByConstraintAnalysis(nums2));

        int[] nums3 = new int[]{12};
        System.out.printf("COUNT: %d %d %d %d%n", findNumbersByDigitExtraction(nums3), findNumbersByConvertingToString(nums3), findNumbersByLogarithm(nums3), findNumbersByConstraintAnalysis(nums3));

        int[] nums4 = new int[]{1};
        System.out.printf("COUNT: %d %d %d %d%n", findNumbersByDigitExtraction(nums4), findNumbersByConvertingToString(nums4), findNumbersByLogarithm(nums4), findNumbersByConstraintAnalysis(nums4));
    }

    /* CONSTRAINTS: 1 <= nums.length <= 500
     *              1 <= nums[i] <= 10^5 */

    // TIME COMPLEXITY  : O(n.logm) where n = nums.length and m = num.length
    // SPACE COMPLEXITY : O(1)
    private static int findNumbersByDigitExtraction(int[] nums) {
        int count = 0;

        for (int num : nums) {
            int digitCount = 0;
            while (num > 0) {
                num /= 10;
                digitCount++;
            }

            if ((digitCount & 1) == 0) count++;
        }

        return count;
    }

    // TIME COMPLEXITY  : O(n.logm) where n = nums.length and m = num.length
    // SPACE COMPLEXITY : O(logm)
    private static int findNumbersByConvertingToString(int[] nums) {
        int count = 0;

        for (int num : nums) {
            if (String.valueOf(num).length() % 2 == 0) count++;
        }

        return count;
    }

    // TIME COMPLEXITY  : O(n.logm) where n = nums.length and m = num.length
    // SPACE COMPLEXITY : O(logm)
    private static int findNumbersByLogarithm(int[] nums) {
        int count = 0;

        for (int num : nums) {
            if ((Math.floor(Math.log10(num)) + 1) % 2 == 0) count++;
        }

        return count;
    }

    // TIME COMPLEXITY  : O(n)
    // SPACE COMPLEXITY : O(1)
    private static int findNumbersByConstraintAnalysis(int[] nums) {
        int count = 0;

        for (int num : nums)
            if ((10 <= num && num < 100) || (1000 <= num && num < 10000) || num == 100000) count++;

        return count;
    }
}
