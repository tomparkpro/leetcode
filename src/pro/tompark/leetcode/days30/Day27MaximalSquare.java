package pro.tompark.leetcode.days30;

/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 *
 * Example:
 *
 * Input:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * Output: 4
 */
public class Day27MaximalSquare {

    public static void main(String[] args) {
//        char[][] matrix = {
//                {'1', '0', '1', '0', '0'},
//                {'1', '0', '1', '1', '1'},
//                {'1', '1', '1', '1', '1'},
//                {'1', '0', '0', '1', '0'},
//        };
//        char[][] matrix = {
//                {'1', '0', '1', '0'},
//                {'1', '0', '1', '1'},
//                {'1', '0', '1', '1'},
//                {'1', '1', '1', '1'},
//        };
        char[][] matrix = {
                {'0', '0', '0', '1'},
                {'1', '1', '0', '1'},
                {'1', '1', '1', '1'},
                {'0', '1', '1', '1'},
                {'0', '1', '1', '1'},
        };

        System.out.println(maximalSquare(matrix));
    }

    public static int maximalSquare(char[][] matrix) {
        if (matrix.length < 1 || matrix[0].length < 1) {
            return 0;
        }
        int max = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '1') {
                    max = Math.max(max, maxLen(matrix, i, j, i + 1, j + 1, 1));
                }
            }
        }

        return max * max;
    }

    private static int maxLen(char[][] matrix, int rootI, int rootJ, int i, int j, int max) {
        if (i >= matrix.length || j >= matrix[0].length || matrix[i][j] == '0') {
            return max;
        }

        boolean isAllOne = true;
        for (int k = j - 1; k >= rootJ ; k--) {
            if (matrix[i][k] == '0') {
                isAllOne = false;
                break;
            }
        }
        if (isAllOne) {
            for (int k = i - 1; k >= rootI; k--) {
                if (matrix[k][j] == '0') {
                    isAllOne = false;
                    break;
                }
            }
        }

        if (isAllOne) {
            max++;
            return maxLen(matrix, rootI, rootJ,i + 1, j + 1, max);
        } else {
            return max;
        }
    }
}