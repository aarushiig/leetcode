package problems;

import java.util.ArrayList;
import java.util.List;

// DIFFICULTY   ; Medium
// TOPICS       : Array, Matrix, Simulation
public class SpiralMatrix54 {
    public static void main(String[] args) {
        int[][] matrix1 = {{1, 2, 3}, {8, 9, 4}, {7, 6, 5}};
        System.out.printf("SPIRAL ORDER: %n%s %n%s %n%s%n%n", spiralOrderBySimulation1(matrix1), spiralOrderBySimulation2(matrix1), spiralOrderByRecursion(matrix1));


        int[][] matrix2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.printf("SPIRAL ORDER: %n%s %n%s %n%s%n%n", spiralOrderBySimulation1(matrix2), spiralOrderBySimulation2(matrix2), spiralOrderByRecursion(matrix2));


        int[][] matrix3 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.printf("SPIRAL ORDER: %n%s %n%s %n%s%n%n", spiralOrderBySimulation1(matrix3), spiralOrderBySimulation2(matrix3), spiralOrderByRecursion(matrix3));


        int[][] matrix4 = {{1}};
        System.out.printf("SPIRAL ORDER: %n%s %n%s %n%s%n%n", spiralOrderBySimulation1(matrix4), spiralOrderBySimulation2(matrix4), spiralOrderByRecursion(matrix4));


        int[][] matrix5 = {{1, 2, 3, 4}};
        System.out.printf("SPIRAL ORDER: %n%s %n%s %n%s%n%n", spiralOrderBySimulation1(matrix5), spiralOrderBySimulation2(matrix5), spiralOrderByRecursion(matrix5));


        int[][] matrix6 = {{1}, {2}, {3}, {4}};
        System.out.printf("SPIRAL ORDER: %n%s %n%s %n%s%n", spiralOrderBySimulation1(matrix6), spiralOrderBySimulation2(matrix6), spiralOrderByRecursion(matrix6));
    }

    /* CONSTRAINTS: m == mat.length
     *              n == mat[i].length
     *              1 <= m, n <= 10
     *              -100 <= mat[i][j] <= 100 */

    // TIME COMPLEXITY  : O(m * n)
    // SPACE COMPLEXITY : O(1)
    private static List<Integer> spiralOrderBySimulation1(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int upMIN = 1, downMAX = (m - 1), leftMIN = 0, rightMAX = (n - 1);

        int r = 0, c = -1;
        String direction = "RIGHT";

        List<Integer> spiralTraversal = new ArrayList<>();
        while (spiralTraversal.size() < m * n) {
            switch (direction.toUpperCase()) {
                case "RIGHT": {
                    if (c < rightMAX) c++;
                    else {
                        r++;
                        direction = "DOWN";
                        rightMAX--;
                    }
                    break;
                }
                case "DOWN": {
                    if (r < downMAX) r++;
                    else {
                        downMAX--;
                        direction = "LEFT";
                        c--;
                    }
                    break;
                }
                case "LEFT": {
                    if (c > leftMIN) c--;
                    else {
                        leftMIN++;
                        direction = "UP";
                        r--;
                    }
                    break;
                }
                case "UP": {
                    if (r > upMIN) r--;
                    else {
                        upMIN++;
                        direction = "RIGHT";
                        c++;
                    }
                    break;
                }
            }

            spiralTraversal.add(matrix[r][c]);
        }

        return spiralTraversal;
    }

    // TIME COMPLEXITY  : O(m * n)
    // SPACE COMPLEXITY : O(1)
    private static List<Integer> spiralOrderBySimulation2(int[][] matrix) {
        int m = matrix.length, up = 0, down = (m - 1);
        int n = matrix[0].length, left = 0, right = (n - 1);

        List<Integer> spiralTraversal = new ArrayList<>();
        while (spiralTraversal.size() < m * n) {
            // RIGHT across a row
            for (int c = left; c <= right && spiralTraversal.size() < m * n; c++)
                spiralTraversal.add(matrix[up][c]);
            up++;

            // DOWN a column
            for (int r = up; r <= down && spiralTraversal.size() < m * n; r++)
                spiralTraversal.add(matrix[r][right]);
            right--;

            // LEFT across a row
            for (int c = right; c >= left && spiralTraversal.size() < m * n; c--)
                spiralTraversal.add(matrix[down][c]);
            down--;

            // UP a column
            for (int r = down; r >= up && spiralTraversal.size() < m * n; r--)
                spiralTraversal.add(matrix[r][left]);
            left++;
        }

        return spiralTraversal;
    }

    // TIME COMPLEXITY  : O(m * n)
    // SPACE COMPLEXITY : O(1)
    private static List<Integer> spiralOrderByRecursion(int[][] matrix) {
        return spiralling(matrix, matrix.length, matrix[0].length, 0, -1, 0, 1, new ArrayList<>());
    }

    private static List<Integer> spiralling(int[][] matrix, int m, int n, int r, int c, int dr, int dc, List<Integer> result) {
        if (m == 0 || n == 0) return result;

        for (int i = 0; i < n; i++) {
            r += dr;
            c += dc;

            result.add(matrix[r][c]);
        }

        return spiralling(matrix, n, (m - 1), r, c, dc, -dr, result);
    }
}
