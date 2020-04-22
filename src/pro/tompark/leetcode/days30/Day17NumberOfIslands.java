package pro.tompark.leetcode.days30;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 *
 * Example 1:
 *
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * Output: 1
 *
 *
 * Example 2:
 *
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * Output: 3
 */
public class Day17NumberOfIslands {

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};
//        grid = new char[][] {
//                {'1', '1', '0', '0', '0'},
//                {'1', '1', '0', '0', '0'},
//                {'0', '0', '1', '0', '0'},
//                {'0', '0', '0', '1', '1'}};
//        grid = new char[][] {
//                {'1', '1', '1'},
//                {'0', '1', '0'},
//                {'1', '1', '1'}};

        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    mark(grid, i, j);
                }
            }
        }
        return count;
    }

    private static void mark(char[][] grid, int i, int j) {
        if (i >=  grid.length || j >= grid[i].length) {
            return;
        }

        if (grid[i][j] == '1') {
            grid[i][j] = '*';
            // right
            if (j+1 < grid[i].length && grid[i][j+1] == '1') {
                mark(grid, i, j+1);
            }
            // left
            if (j-1 >= 0 && grid[i][j-1] == '1') {
                mark(grid, i, j-1);
            }
            // up
            if (i -1 >= 0 && grid[i-1][j] == '1') {
                mark(grid, i-1, j);
            }
            // down
            if (i + 1 < grid.length && grid[i+1][j] == '1') {
                mark(grid, i+1, j);
            }
        }
    }
}