package problems;

// DIFFICULTY   : Easy
// TOPICS       : Array, Sorting
public class LargestNumberAtLeastTwiceOfOthers747 {
    public static void main(String[] args) {
        System.out.printf("DOMINANT INDEX: %d %d%n", dominantIndexInTwoPasses(new int[]{3, 6, 1, 0}), dominantIndexInOnePass(new int[]{3, 6, 1, 0}));
        System.out.printf("DOMINANT INDEX: %d %d%n", dominantIndexInTwoPasses(new int[]{1, 2, 3, 4}), dominantIndexInOnePass(new int[]{1, 2, 3, 4}));
        System.out.printf("DOMINANT INDEX: %d %d%n", dominantIndexInTwoPasses(new int[]{0, 0, 3, 2}), dominantIndexInOnePass(new int[]{0, 0, 3, 2}));
    }

    /* CONSTRAINTS: 2 <= nums.length <= 50
     *              0 <= nums[i] <= 100
     *              The largest element in nums is unique. */

    // TIME COMPLEXITY  : O(n)
    // SPACE COMPLEXITY : O(1)
    private static int dominantIndexInTwoPasses(int[] nums) {
        int largestNumber = nums[0], largestNumberIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > largestNumber) {
                largestNumber = nums[i];
                largestNumberIndex = i;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (largestNumberIndex != i && largestNumber < (nums[i] * 2)) return -1;
        }

        return largestNumberIndex;
    }

    // TIME COMPLEXITY  : O(n)
    // SPACE COMPLEXITY : O(1)
    private static int dominantIndexInOnePass(int[] nums) {
        int largestNumber = -1, largestNumberIndex = -1, secondLargestNumber = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > largestNumber) {
                secondLargestNumber = largestNumber;
                largestNumber = nums[i];
                largestNumberIndex = i;
            } else if (largestNumber > nums[i] && nums[i] > secondLargestNumber) {
                secondLargestNumber = nums[i];
            }
        }

        return (largestNumber < (secondLargestNumber * 2)) ? -1 : largestNumberIndex;
    }
}
