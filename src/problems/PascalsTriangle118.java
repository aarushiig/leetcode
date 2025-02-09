package problems;

import java.util.ArrayList;
import java.util.List;

// DIFFICULTY   : Easy
// TOPICS       : Array, Dynamic Programming
public class PascalsTriangle118 {
    public static void main(String[] args) {
        System.out.printf("PASCAL'S TRIANGLE: %d%n%s%n%s%n%n", 1, generate(1), generateByDPUsingRecursion(1));
        System.out.printf("PASCAL'S TRIANGLE: %d%n%s%n%s%n%n", 2, generate(2), generateByDPUsingRecursion(2));
        System.out.printf("PASCAL'S TRIANGLE: %d%n%s%n%s%n", 5, generate(5), generateByDPUsingRecursion(5));
    }

    /* CONSTRAINTS: 1<= numRows <= 30 */

    // TIME COMPLEXITY  : O(n ^ 2)
    // SPACE COMPLEXITY : O()
    private static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();

        List<Integer> row0 = new ArrayList<>();
        row0.add(1);
        pascalTriangle.add(row0);

        for (int i = 1; i < numRows; i++) {
            List<Integer> rowI = new ArrayList<>();
            rowI.add(1);

            List<Integer> previousRow = pascalTriangle.get(i - 1);
            for (int j = 1; j <= (i - 1); j++) {
                rowI.add(previousRow.get(j - 1) + previousRow.get(j));
            }

            rowI.add(1);
            pascalTriangle.add(rowI);
        }

        return pascalTriangle;
    }

    // TIME COMPLEXITY  : O(n ^ 2)
    // SPACE COMPLEXITY : O()
    private static List<List<Integer>> generateByDPUsingRecursion(int numRows) {
        if (numRows == 0) return new ArrayList<>();
        if (numRows == 1) {
            List<List<Integer>> pascalTriangle = new ArrayList<>();
            pascalTriangle.add(List.of(1));
            return pascalTriangle;
        }

        List<List<Integer>> previousRows = generateByDPUsingRecursion(numRows - 1);

        List<Integer> newRow = new ArrayList<>();
        newRow.add(1);

        List<Integer> previousRow = previousRows.get(numRows - 2);
        for (int i = 1; i < (numRows - 1); i++) {
            newRow.add(previousRow.get(i - 1) + previousRow.get(i));
        }

        newRow.add(1);
        previousRows.add(newRow);
        return previousRows;
    }
}
