package pro.tompark.leetcode.days30.may;

import java.util.*;

/**
 *  Interval List Intersections
 *
 * Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.
 *
 * Return the intersection of these two interval lists.
 *
 * (Formally, a closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.
 * The intersection of two closed intervals is a set of real numbers that is either empty,
 * or can be represented as a closed interval.  For example, the intersection of [1, 3] and [2, 4] is [2, 3].)
 *
 *
 *
 * Example 1:
 *
 * Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
 * Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
 * Reminder: The inputs and the desired output are lists of Interval objects, and not arrays or lists.
 *
 * Note:
 *
 * 0 <= A.length < 1000
 * 0 <= B.length < 1000
 * 0 <= A[i].start, A[i].end, B[i].start, B[i].end < 10^9
 * NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 */
public class Day23IntervalListIntersections {

    public static void main(String[] args) {
//        int[][] A = {{0,2}, {5,10}, {13,23}, {24,25}};
//        int[][] B = {{1,5}, {8,12}, {15,24}, {25,26}};
        int[][] A = {{5,10}};
        int[][] B = {{3,10}};

        int[][] result = intervalIntersection(A, B);

        for (int i = 0; i < result.length; i++) {
            System.out.print("[");
            System.out.print(result[i][0] + ", " + result[i][1]);
            System.out.println("]");
        }
    }

    public static int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> result = new ArrayList<>();

        int i = 0;
        int j = 0;
        while (i < A.length && j < B.length) {
            int[] a = A[i];
            int[] b = B[j];

            if (a[1] < b[0]) i++;
            else if (b[1] < a[0]) j++;
            else { // overlap
                int start = Math.max(a[0], b[0]);
                int end = Math.min(a[1], b[1]);
                result.add(new int[]{start, end});
                if (a[1] < b[1]) i++;
                else if (a[1] >= b[1]) j++;
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    public static int[][] intervalIntersection2(int[][] A, int[][] B) {
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>();

        for (int i = 0; i < B.length; i++) {
            for (int j = 0; j < A.length; j++) {
                if (B[i][0] >= A[j][0] && B[i][0] <= A[j][1]
                        && A[j][1] >= B[i][0] && A[j][1] <= B[i][1]) {
                    list.add(Map.entry(B[i][0], A[j][1]));
                } else if (A[j][0] >= B[i][0] && A[j][0] <= B[i][1]
                        && B[i][1] >= A[j][0] && B[i][1] <= A[j][1]) {
                    list.add(Map.entry(A[j][0], B[i][1]));
                } else if (A[j][0] >= B[i][0] && A[j][1] <= B[i][1]) {
                    list.add(Map.entry(A[j][0], A[j][1]));
                } else if (B[i][0] >= A[j][0] && B[i][1] <= A[j][1]) {
                    list.add(Map.entry(B[i][0], B[i][1]));
                }
            }
        }

        int[][] result = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            Map.Entry<Integer, Integer> es = list.get(i);
            result[i][0] = es.getKey();
            result[i][1] = es.getValue();
        }
        return result;
    }
}