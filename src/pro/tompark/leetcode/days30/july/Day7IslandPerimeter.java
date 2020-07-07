package pro.tompark.leetcode.days30.july;

/**
 * Island Perimeter
 *
 *
 * You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.
 *
 * Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water,
 * and there is exactly one island (i.e., one or more connected land cells).
 *
 * The island doesn't have "lakes" (water inside that isn't connected to the water around the island).
 * One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100.
 * Determine the perimeter of the island.
 *
 *
 *
 * Example:
 *
 * Input:
 * [[0,1,0,0],
 *  [1,1,1,0],
 *  [0,1,0,0],
 *  [1,1,0,0]]
 *
 * Output: 16
 *
 * Explanation: The perimeter is the 16 yellow stripes in the image below:
 */
public class Day7IslandPerimeter {

    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}};

        int result = islandPerimeter(grid);
        System.out.println(result);
    }

    static int islandPerimeter(int[][] grid) {
        int islands = 0;    // number of islands
        int edges = 0;      // number of edges between islands
        int m = grid.length;
        int n = grid[0].length;

        // loop through all islands and
        // check how many edges are connected to other islands
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    islands++;
                    // first check right side
                    if (j + 1 < n && grid[i][j + 1] == 1) {
                        edges++;
                    }
                    // second check bottom side
                    if (i + 1 < m && grid[i + 1][j] == 1) {
                        edges++;
                    }
                }
            }
        }

        // perimeter = (islands * 4) - (connected edges * 2)
        return (islands * 4) - (edges * 2);
    }
}
