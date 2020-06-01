package pro.tompark.leetcode.days30.may;

import java.util.*;

/**
 * K Closest Points to Origin
 *
 * Solution
 * We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
 *
 * (Here, the distance between two points on a plane is the Euclidean distance.)
 *
 * You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)
 *
 * Example 1:
 *
 * Input: points = [[1,3],[-2,2]], K = 1
 * Output: [[-2,2]]
 * Explanation:
 * The distance between (1, 3) and the origin is sqrt(10).
 * The distance between (-2, 2) and the origin is sqrt(8).
 * Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
 * We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
 *
 *
 * Example 2:
 *
 * Input: points = [[3,3],[5,-1],[-2,4]], K = 2
 * Output: [[3,3],[-2,4]]
 * (The answer [[-2,4],[3,3]] would also be accepted.)
 *
 *
 * Note:
 *
 * 1 <= K <= points.length <= 10000
 * -10000 < points[i][0] < 10000
 * -10000 < points[i][1] < 10000
 */
public class Day29KClosestPointsToOrigin {

    public static void main(String[] args) {
        int K = 2;
        int[][] points = {{3, 3}, {5, -1}, {-2, 4}};
//        int[][] points = {{0, 1}, {1, 0}};

        int[][] closest = kClosest(points, K);
        for (int[] c : closest) {
            System.out.print(c[0] + "," + c[1] + " ");
        }
    }

    // TODO remove static to run
    public static class Point implements Comparable<Point> {
        public int x, y;

        public Point(int[] p) {
            x = p[0];
            y = p[1];
        }

        @Override
        public int compareTo(Point p) {
            return (p.x * p.x + p.y * p.y) - (x * x + y * y);
        }
    }

    public static int[][] kClosest(int[][] points, int K) {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        for (int i = 0; i < points.length; i++) {
            int[] p = points[i];
            if (i < K) {
                pq.offer(new Point(p));
            } else {
                Point max = pq.peek();
                if (max.x * max.x + max.y * max.y < p[0] * p[0] + p[1] * p[1]) {
                    pq.poll();
                    pq.offer(new Point(p));
                }
            }
        }

        int[][] result = new int[K][2];
        for (int i = 0; i < result.length; i++) {
            Point p = pq.poll();
            result[i][0] = p.x;
            result[i][1] = p.y;
        }

        return result;
    }

    public static int[][] kClosest1(int[][] points, int K) {
        int[] distances = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            distances[i] = distance(points[i]);
        }
        Arrays.sort(distances);
        int[][] result = new int[K][2];
        int count = 0;

        int kValue = distances[K - 1];
        for (int i = 0; i < points.length; i++) {
            if (distance(points[i]) <= kValue) {
                result[count] = points[i];
                count++;
                if (count >= K) {
                    break;
                }
            }
        }

        return result;
    }

    private static int distance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    public static int[][] kClosest2(int[][] points, int K) {
        Map<Double, List<Integer[]>> map = new HashMap<>();
        int[][] result = new int[K][2];

        for (int[] p : points) {
            Double distance = Math.sqrt((p[0] * p[0]) + (p[1] * p[1]));
            List<Integer[]> ds = map.getOrDefault(distance, new ArrayList<>());
            ds.add(new Integer[] {p[0], p[1]});
            map.put(distance, ds);
        }

        Double[] keys = map.keySet().toArray(new Double[0]);
        if (keys.length > 1) {
            Arrays.sort(keys);
        }

        for (int i = 0; i < K; ) {
//            System.out.println(keys[i]);
            List<Integer[]> ps = map.get(keys[i]);
            for (Integer[] p : ps) {
                result[i] = new int[] {p[0], p[1]};
                i++;
                if (i >= K) {
                    break;
                }
            }
        }

        return result;
    }
}