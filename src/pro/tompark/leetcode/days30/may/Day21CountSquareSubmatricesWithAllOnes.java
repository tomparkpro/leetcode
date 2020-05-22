package pro.tompark.leetcode.days30.may;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Count Square Submatrices with All Ones
 * Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.
 *
 *
 *
 * Example 1:
 *
 * Input: matrix =
 * [
 *   [0,1,1,1],
 *   [1,1,1,1],
 *   [0,1,1,1]
 * ]
 * Output: 15
 * Explanation:
 * There are 10 squares of side 1.
 * There are 4 squares of side 2.
 * There is  1 square of side 3.
 * Total number of squares = 10 + 4 + 1 = 15.
 *
 *
 * Example 2:
 *
 * Input: matrix =
 * [
 *   [1,0,1],
 *   [1,1,0],
 *   [1,1,0]
 * ]
 * Output: 7
 * Explanation:
 * There are 6 squares of side 1.
 * There is 1 square of side 2.
 * Total number of squares = 6 + 1 = 7.
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 300
 * 1 <= arr[0].length <= 300
 * 0 <= arr[i][j] <= 1
 *    Hide Hint #1
 * Create an additive table that counts the sum of elements of submatrix with the superior corner at (0,0).
 *    Hide Hint #2
 * Loop over all subsquares in O(n^3) and check if the sum make the whole array to be ones, if it checks then add 1 to the answer.
 */
public class Day21CountSquareSubmatricesWithAllOnes {

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 1, 1, 1}
        };

        System.out.println(countSquares(matrix));
    }

    public static int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[] counts = new int[n];
        int topleft = 0;
        int result = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    int top = (i == 0) ? 0 : counts[j];
                    int left = (j == 0) ? 0 : counts[j - 1];
                    counts[j] = 1 + Math.min(Math.min(top, left), topleft);
                    result += counts[j];

                    topleft = (j == n - 1) ? 0 : top;
                } else {
                    counts[j] = 0;
                }
            }
        }

        return result;
    }

    public static int countSquares2(int[][] matrix) {
        int count = 0;

        int size = Math.min(matrix.length, matrix[0].length);
        for (int k = 1; k <= size; k++) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] == 1 && isSquare(matrix, i, j, k)) {
                        count++;
                    }
                }
            }
            System.out.println(count);
        }

        return count;
    }

    public static boolean isSquare(int[][] matrix, int i, int j, int size) {
        if (i + size - 1 >= matrix.length || j + size - 1 >= matrix[i].length) return false;
        boolean isSquare = true;

        for (int k = i; k < i + size; k++) {
            if (isSquare) {
                for (int l = j; l < j + size; l++) {
                    if (matrix[k][l] != 1) {
                        isSquare = false;
                        break;
                    }
                }
            }
        }

        return isSquare;
    }

}