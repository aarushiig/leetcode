package problems;

import java.util.Arrays;

// DIFFICULTY   : Easy
// TOPICS       : Array, Math
public class PlusOne66 {
    public static void main(String[] args) {
        System.out.printf("PLUS ONE: %s %s%n", Arrays.toString(plusOne(new int[]{1, 2, 3})), Arrays.toString(plusOneBySimulation(new int[]{1, 2, 3})));
        System.out.printf("PLUS ONE: %s %s%n%n", Arrays.toString(plusOne(new int[]{4, 3, 2, 1})), Arrays.toString(plusOneBySimulation(new int[]{4, 3, 2, 1})));

        System.out.printf("PLUS ONE: %s %s%n", Arrays.toString(plusOne(new int[]{9, 1, 2, 4})), Arrays.toString(plusOneBySimulation(new int[]{9, 1, 2, 4})));
        System.out.printf("PLUS ONE: %s %s%n", Arrays.toString(plusOne(new int[]{1, 2, 4, 9})), Arrays.toString(plusOneBySimulation(new int[]{1, 2, 4, 9})));
        System.out.printf("PLUS ONE: %s %s%n", Arrays.toString(plusOne(new int[]{1, 2, 9, 4})), Arrays.toString(plusOneBySimulation(new int[]{1, 2, 9, 4})));
        System.out.printf("PLUS ONE: %s %s%n%n", Arrays.toString(plusOne(new int[]{1, 2, 9, 9})), Arrays.toString(plusOneBySimulation(new int[]{1, 2, 9, 9})));

        System.out.printf("PLUS ONE: %s %s%n", Arrays.toString(plusOne(new int[]{9})), Arrays.toString(plusOneBySimulation(new int[]{9})));
        System.out.printf("PLUS ONE: %s %s%n", Arrays.toString(plusOne(new int[]{9, 9})), Arrays.toString(plusOneBySimulation(new int[]{9, 9})));
        System.out.printf("PLUS ONE: %s %s%n", Arrays.toString(plusOne(new int[]{9, 9, 9})), Arrays.toString(plusOneBySimulation(new int[]{9, 9, 9})));
    }

    /* CONSTRAINTS: 1 <= digits.length <= 100
     *              0 <= digits[i] <= 9
     *              digits does not contain any leading 0's. */

    // TIME COMPLEXITY  : O(n)
    // SPACE COMPLEXITY : O(n)
    private static int[] plusOneBySimulation(int[] digits) {
        boolean areAllDigitsNine = true;
        for (int digit : digits) {
            if (digit != 9) {
                areAllDigitsNine = false;
                break;
            }
        }

        int[] plusOne = areAllDigitsNine ? new int[digits.length + 1] : new int[digits.length];

        int p = plusOne.length - 1;
        plusOne[p] = 1;

        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9 && plusOne[p] == 1) {
                plusOne[p] = 0;
                plusOne[p - 1] = 1;
            } else {
                plusOne[p] += digits[i];
            }
            p--;
        }

        return plusOne;
    }

    // TIME COMPLEXITY  : O(n)
    // SPACE COMPLEXITY : O(1) for best & average cases, O(n) for worst case
    private static int[] plusOne(int[] digits) {
        int n = digits.length;

        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        int[] newNumber = new int[n + 1];
        newNumber[0] = 1;

        return newNumber;
    }
}
