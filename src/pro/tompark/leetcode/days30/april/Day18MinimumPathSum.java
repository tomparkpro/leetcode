package pro.tompark.leetcode.days30.april;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 * Example:
 *
 * Input:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 *
 * Output: 7
 *
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */
public class Day18MinimumPathSum {

    public static void main(String[] args) {
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}};

        System.out.println(minPathSum(grid));
    }

    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 1; i < n; i++) {
            grid[0][i] = grid[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            grid[i][0] = grid[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] = grid[i][j] + Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }

        return grid[m - 1][n - 1];
    }

    /**
     * Time Limit Exceeded
     */
    public static int minPathSum2(int[][] grid) {
        return minPath2(grid, 0, 0);
    }

    private static int minPath2(int[][] grid, int i, int j) {
        if (i == grid.length - 1 && j == grid[i].length - 1) {
            return grid[i][j];
        }

        int right = -1;
        int down = -1;

        // right
        if (j < grid[i].length - 1) {
            right = minPath2(grid, i, j+1);
        }

        // down
        if (i < grid.length - 1) {
            down = minPath2(grid, i+1, j);
        }

        if (right >= 0 && down >= 0) {
            return grid[i][j] + Math.min(right, down);
        } else if (right >= 0) {
            return grid[i][j] + right;
        } else if (down >= 0) {
            return grid[i][j] + down;
        } else {
            return grid[i][j];
        }
    }
}
