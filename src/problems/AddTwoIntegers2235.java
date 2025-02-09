package problems;

// DIFFICULTY   : Easy
// TOPICS       : Math
public class AddTwoIntegers2235 {
    public static void main(String[] args) {
        System.out.printf("SUM: %d%n", sum(12, 5));
        System.out.printf("SUM: %d%n", sum(-10, 4));
    }

    /* CONSTRAINTS: -100 <= num1, num2 <= 100 */

    // TIME COMPLEXITY  : O(1)
    // SPACE COMPLEXITY : O(1)
    private static int sum(int num1, int num2) {
        return num1 + num2;
    }
}
