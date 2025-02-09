package problems;

import java.util.*;

// DIFFICULTY   : Easy
// TOPICS       : Array, Sorting
public class ThirdMaximumNumber414 {
    public static void main(String[] args) {
        int[] nums1 = {3, 2, 1};
        System.out.printf("THIRD MAX: %d %d %d %d %d%n", thirdMaxUsing3Pointers(nums1), thirdMaxUsing3PointersAnd3Flags(nums1), thirdMaxUsingSorting(nums1), thirdMaxUsingHashSetAndMinHeapViaPriorityQueue(nums1), thirdMaxUsingOrderedSet(nums1));

        int[] nums2 = {1, 2};
        System.out.printf("THIRD MAX: %d %d %d %d %d%n", thirdMaxUsing3Pointers(nums2), thirdMaxUsing3PointersAnd3Flags(nums2), thirdMaxUsingSorting(nums2), thirdMaxUsingHashSetAndMinHeapViaPriorityQueue(nums2), thirdMaxUsingOrderedSet(nums2));

        int[] nums3 = {2, 2, 3, 1};
        System.out.printf("THIRD MAX: %d %d %d %d %d%n", thirdMaxUsing3Pointers(nums3), thirdMaxUsing3PointersAnd3Flags(nums3), thirdMaxUsingSorting(nums3), thirdMaxUsingHashSetAndMinHeapViaPriorityQueue(nums3), thirdMaxUsingOrderedSet(nums3));

        int[] nums4 = {5, 2, 2};
        System.out.printf("THIRD MAX: %d %d %d %d %d%n", thirdMaxUsing3Pointers(nums4), thirdMaxUsing3PointersAnd3Flags(nums4), thirdMaxUsingSorting(nums4), thirdMaxUsingHashSetAndMinHeapViaPriorityQueue(nums4), thirdMaxUsingOrderedSet(nums4));

        int[] nums5 = {1, 2, 2, 5, 3, 5};
        System.out.printf("THIRD MAX: %d %d %d %d %d%n", thirdMaxUsing3Pointers(nums5), thirdMaxUsing3PointersAnd3Flags(nums5), thirdMaxUsingSorting(nums5), thirdMaxUsingHashSetAndMinHeapViaPriorityQueue(nums5), thirdMaxUsingOrderedSet(nums5));

        int[] nums6 = {Integer.MIN_VALUE, 1, Integer.MAX_VALUE};
        System.out.printf("THIRD MAX: %d %d %d %d %d%n", thirdMaxUsing3Pointers(nums6), thirdMaxUsing3PointersAnd3Flags(nums6), thirdMaxUsingSorting(nums6), thirdMaxUsingHashSetAndMinHeapViaPriorityQueue(nums6), thirdMaxUsingOrderedSet(nums6));

        int[] nums7 = {-100};
        System.out.printf("THIRD MAX: %d %d %d %d %d%n", thirdMaxUsing3Pointers(nums7), thirdMaxUsing3PointersAnd3Flags(nums7), thirdMaxUsingSorting(nums7), thirdMaxUsingHashSetAndMinHeapViaPriorityQueue(nums7), thirdMaxUsingOrderedSet(nums7));
    }

    /* CONSTRAINTS: 1 <= nums.length <= 10^4
     *              -2^31 <= nums[i] <= 2^31 - 1 */

    // TIME COMPLEXITY  : O(n)
    // SPACE COMPLEXITY : O(1)
    private static int thirdMaxUsing3Pointers(int[] nums) {
        long[] max = {Long.MIN_VALUE, Long.MIN_VALUE, Long.MIN_VALUE};

        for (int num : nums) {
            if (num == max[0] || num == max[1] || num == max[2]) continue;

            if (num > max[0]) {
                max[2] = max[1];
                max[1] = max[0];
                max[0] = num;
            } else if (num > max[1]) {
                max[2] = max[1];
                max[1] = num;
            } else if (num > max[2]) {
                max[2] = num;
            }
        }

        return (int) (max[2] > Long.MIN_VALUE ? max[2] : max[0]);
    }

    // TIME COMPLEXITY  : O(n)
    // SPACE COMPLEXITY : O(1)
    private static int thirdMaxUsing3PointersAnd3Flags(int[] nums) {
        int[] max = {-1, -1, -1};
        boolean[] maxUpdated = {false, false, false};

        for (int num : nums) {
            if ((num == max[0] && maxUpdated[0]) || (num == max[1] && maxUpdated[1]) || (num == max[2] && maxUpdated[2]))
                continue;

            if (num > max[0] || !maxUpdated[0]) {
                max[2] = max[1];
                max[1] = max[0];

                boolean secondMaxUpdated = maxUpdated[1];
                if (maxUpdated[0]) maxUpdated[1] = true;
                if (secondMaxUpdated) maxUpdated[2] = true;

                max[0] = num;
                maxUpdated[0] = true;
            } else if (num > max[1] || !maxUpdated[1]) {
                max[2] = max[1];
                if (maxUpdated[1]) maxUpdated[2] = true;

                max[1] = num;
                maxUpdated[1] = true;
            } else if (num > max[2] || !maxUpdated[2]) {
                max[2] = num;
                maxUpdated[2] = true;
            }
        }

        return (maxUpdated[2] ? max[2] : max[0]);
    }

    // TIME COMPLEXITY  : O(n.logn)
    // SPACE COMPLEXITY : O(1)
    private static int thirdMaxUsingSorting(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i < (nums.length / 2); i++) {
            int t = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = t;
        }

        int elementsCounted = 1, previousDistinctElement = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != previousDistinctElement) {
                previousDistinctElement = nums[i];
                elementsCounted++;
            }

            if (elementsCounted == 3) {
                return nums[i];
            }
        }

        return nums[0];
    }

    // TIME COMPLEXITY  : O(n)
    // SPACE COMPLEXITY : O(1)
    private static int thirdMaxUsingHashSetAndMinHeapViaPriorityQueue(int[] nums) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(num)) continue;

            if (minHeap.size() == 3) {
                if (minHeap.peek() < num) {
                    set.remove(minHeap.poll());

                    minHeap.add(num);
                    set.add(num);
                }
            } else {
                minHeap.add(num);
                set.add(num);
            }
        }

        if (minHeap.size() == 1) {
            return minHeap.peek();
        } else if (minHeap.size() == 2) {
            return Math.max(minHeap.poll(), minHeap.peek());
        }

        return minHeap.peek();
    }

    // TIME COMPLEXITY  : O(n)
    // SPACE COMPLEXITY : O(1)
    private static int thirdMaxUsingOrderedSet(int[] nums) {
        TreeSet<Integer> orderedSet = new TreeSet<>();

        for (int num : nums) {
            if (orderedSet.contains(num)) continue;

            if (orderedSet.size() == 3) {
                if (num > orderedSet.first()) {
                    orderedSet.pollFirst();
                    orderedSet.add(num);
                }
            } else {
                orderedSet.add(num);
            }
        }

        if (orderedSet.size() == 3) return orderedSet.first();

        return orderedSet.last();
    }
}
