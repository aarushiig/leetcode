package problems;

// DIFFICULTY   : Easy
// TOPICS       : Math, Bit Manipulation
public class NumberOfStepsToReduceANumberToZero1342 {
    public static void main(String[] args) {
        System.out.printf("STEPS: %d%n", numberOfStepsUsingBitManipulation(14));
        System.out.printf("STEPS: %d%n", numberOfStepsUsingBitManipulation(8));
        System.out.printf("STEPS: %d%n", numberOfStepsUsingBitManipulation(123));
    }

    /* CONSTRAINTS: 0 <= num <= 10^6 */

    // TIME COMPLEXITY  : O(logn)
    // SPACE COMPLEXITY : O(1)
    private static int numberOfStepsUsingBitManipulation(int num) {
        int steps = 0;

        while (num > 0) {
            num = (num & 1) == 0 ? num >> 1 : num ^ 1;

            steps++;
        }

        return steps;
    }

    private static int numberOfSteps(int num) {
        return (Integer.toBinaryString(num).length() - 1) + (Integer.bitCount(num));
    }

    private static int numberOfStepsUsingRecursion(int num) {
        if (num == 0) return num;

        return 1 + (num % 2 == 0 ? numberOfStepsUsingRecursion(num / 2) : numberOfStepsUsingRecursion(num - 1));
    }

    // TIME COMPLEXITY  : O(logn)
    // SPACE COMPLEXITY : O(1)
    private static int numberOfStepsUsingIteration(int num) {
        int steps = 0;

        while (num > 0) {
            if (num % 2 == 0) num /= 2;
            else num--;

            steps++;
        }

        return steps;
    }
}
