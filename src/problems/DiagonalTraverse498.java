package problems;

import java.util.*;

// DIFFICULTY   : Medium
// TOPICS       : Array, Matrix, Simulation
public class DiagonalTraverse498 {
    public static void main(String[] args) {
        System.out.printf("DIAGONAL ORDER: %s%n", Arrays.toString(findDiagonalOrderBySimulation(new int[][]{{1, 2}, {3, 4}})));
        System.out.printf("DIAGONAL ORDER: %s%n%n", Arrays.toString(findDiagonalOrderUsingMath(new int[][]{{1, 2}, {3, 4}})));

        System.out.printf("DIAGONAL ORDER: %s%n", Arrays.toString(findDiagonalOrderBySimulation(new int[][]{{1, 2, 6}, {3, 5, 7}, {4, 8, 9}})));
        System.out.printf("DIAGONAL ORDER: %s%n%n", Arrays.toString(findDiagonalOrderUsingMath(new int[][]{{1, 2, 6}, {3, 5, 7}, {4, 8, 9}})));

        System.out.printf("DIAGONAL ORDER: %s%n", Arrays.toString(findDiagonalOrderBySimulation(new int[][]{{1, 2, 6, 7}, {3, 5, 8, 13}, {4, 9, 12, 14}, {10, 11, 15, 16}})));
        System.out.printf("DIAGONAL ORDER: %s%n%n", Arrays.toString(findDiagonalOrderUsingMath(new int[][]{{1, 2, 6, 7}, {3, 5, 8, 13}, {4, 9, 12, 14}, {10, 11, 15, 16}})));

        System.out.printf("DIAGONAL ORDER: %s%n", Arrays.toString(findDiagonalOrderBySimulation(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}})));
        System.out.printf("DIAGONAL ORDER: %s%n%n", Arrays.toString(findDiagonalOrderUsingMath(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}})));

        System.out.printf("DIAGONAL ORDER: %s%n", Arrays.toString(findDiagonalOrderBySimulation(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})));
        System.out.printf("DIAGONAL ORDER: %s%n%n", Arrays.toString(findDiagonalOrderUsingMath(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})));
    }

    /* CONSTRAINTS: m == mat.length
     *              n == mat[i].length
     *              1 <= m, n <= 10^4
     *              1 <= m * n <= 10^4
     *              -10^5 <= mat[i][j] <= 10^5 */

    // TIME COMPLEXITY  : O(m * n)
    // SPACE COMPLEXITY : O(1)
    private static int[] findDiagonalOrderBySimulation(int[][] mat) {
        int m = mat.length, n = mat[0].length, row = 0, column = 0, p = 0;
        boolean goingUp = true;

        int[] diagonalTraversal = new int[m * n];

        while (row < m && column < n) {
            diagonalTraversal[p++] = mat[row][column];

            if (goingUp) {
                if (row == 0 && column < (n - 1)) {
                    column++;           // MOVE RIGHT.
                    goingUp = false;
                } else if (row < (m - 1) && column == (n - 1)) {
                    row++;              // MOVE DOWN.
                    goingUp = false;
                } else {
                    row--;              // MOVE UP
                    column++;           // DIAGONALLY.
                }
            } else {
                if (row < (m - 1) && column == 0) {
                    row++;              // MOVE DOWN.
                    goingUp = true;
                } else if (row == (m - 1) && column < (n - 1)) {
                    column++;           // MOVE RIGHT.
                    goingUp = true;
                } else {
                    row++;              // MOVE DOWN
                    column--;           // DIAGONALLY.
                }
            }
        }

        return diagonalTraversal;
    }

    // TIME COMPLEXITY  : O(m * n)
    // SPACE COMPLEXITY : O(m * n)
    private static int[] findDiagonalOrderUsingMath(int[][] mat) {
        int m = mat.length, n = mat[0].length, k = 0;

        Map<Integer, List<Integer>> elementsToDiagonalMap = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                List<Integer> elementsOnADiagonal = elementsToDiagonalMap.get(i + j);

                if (elementsOnADiagonal != null && !elementsOnADiagonal.isEmpty()) {
                    elementsOnADiagonal.add(mat[i][j]);
                } else {
                    elementsOnADiagonal = new ArrayList<>();
                    elementsOnADiagonal.add(mat[i][j]);

                    elementsToDiagonalMap.put(i + j, elementsOnADiagonal);
                }
            }
        }

        int[] diagonalTraversal = new int[m * n];
        for (int d = 0; d < (m + n - 1); d++) {
            List<Integer> elementsOnADiagonal = elementsToDiagonalMap.get(d);
            if ((d & 1) != 0) {
                for (int i = 0; i < elementsOnADiagonal.size(); i++) {
                    diagonalTraversal[k++] = elementsOnADiagonal.get(i);
                }
            } else {
                for (int i = elementsOnADiagonal.size() - 1; i >= 0; i--) {
                    diagonalTraversal[k++] = elementsOnADiagonal.get(i);
                }
            }
        }

        return diagonalTraversal;
    }
}
