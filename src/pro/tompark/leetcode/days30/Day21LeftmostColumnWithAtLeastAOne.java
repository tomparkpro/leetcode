package pro.tompark.leetcode.days30;

import java.util.ArrayList;
import java.util.List;

/**
 * (This problem is an interactive problem.)
 *
 * A binary matrix means that all elements are 0 or 1. For each individual row of the matrix,
 * this row is sorted in non-decreasing order.
 *
 * Given a row-sorted binary matrix binaryMatrix, return leftmost column index(0-indexed) with at least a 1 in it.
 * If such index doesn't exist, return -1.
 *
 * You can't access the Binary Matrix directly.  You may only access the matrix using a BinaryMatrix interface:
 *
 * BinaryMatrix.get(x, y) returns the element of the matrix at index (x, y) (0-indexed).
 * BinaryMatrix.dimensions() returns a list of 2 elements [n, m], which means the matrix is n * m.
 * Submissions making more than 1000 calls to BinaryMatrix.get will be judged Wrong Answer.
 * Also, any solutions that attempt to circumvent the judge will result in disqualification.
 *
 * For custom testing purposes you're given the binary matrix mat as input in the following four examples.
 * You will not have access the binary matrix directly.
 *
 *
 * Example 1:
 * Input: mat = [[0,0],[1,1]]
 * Output: 0
 * Example 2:
 *
 *
 * Input: mat = [[0,0],[0,1]]
 * Output: 1
 * Example 3:
 *
 *
 * Input: mat = [[0,0],[0,0]]
 * Output: -1
 * Example 4:
 *
 *
 * Input: mat = [[0,0,0,1],[0,0,1,1],[0,1,1,1]]
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= mat.length, mat[i].length <= 100
 * mat[i][j] is either 0 or 1.
 * mat[i] is sorted in a non-decreasing way.
 *
 *  Hide Hint
 *  1. (Binary Search) For each row do a binary search to find the leftmost one on that row and update the answer.
 *
 *  2. (Optimal Approach) Imagine there is a pointer p(x, y) starting from top right corner. p can only move left or down.
 *  If the value at p is 0, move down. If the value at p is 1, move left.
 *  Try to figure out the correctness and time complexity of this algorithm.
 */
public class Day21LeftmostColumnWithAtLeastAOne {

    /**
     * // This is the BinaryMatrix's API interface.
     * // You should not implement it, or speculate about its implementation
     * interface BinaryMatrix {
     *     public int get(int x, int y) {}
     *     public List<Integer> dimensions {}
     * };
     */
    public static void main(String[] args) {
        BinaryMatrix binaryMatrix = new BinaryMatrix();

        System.out.println(leftMostColumnWithOne(binaryMatrix));
    }

    public static int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        int result = -1;
        List<Integer> dimensions = binaryMatrix.dimensions();
        int rows = dimensions.get(0);
        int cols = dimensions.get(1);
        int currentRow = 0;
        int currentCol = cols - 1;

        while (currentRow < rows && currentCol >= 0) {
            if (binaryMatrix.get(currentRow, currentCol) == 0) {
                currentRow++;
            } else {
                currentCol--;
            }
        }

        if (currentCol != cols - 1) {
            result = currentCol + 1;
        }

        return result;
    }

    static class BinaryMatrix {
//        int[][] mat = {
//                {0, 0, 0, 1},
//                {0, 0, 1, 1},
//                {0, 1, 1, 1}};
//        int[][] mat = {
//                {0, 0},
//                {1, 1}};
//        int[][] mat = {
//                {0, 0},
//                {0, 1}};
        int[][] mat = {
                {0, 0},
                {0, 0}};

        public int get(int x, int y) {
            return mat[x][y];
        }

        public List<Integer> dimensions() {
            List<Integer> list = new ArrayList<>();
            list.add(mat.length);
            list.add(mat[0].length);
            return list;
        }
     }
}
