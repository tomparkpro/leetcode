package pro.tompark.leetcode.days30.may;

/**
 * Check If It Is a Straight Line
 * You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point. Check if these points make a straight line in the XY plane.
 *
 *
 * Example 1:
 *
 * Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
 * Output: true
 * Example 2:
 *
 *
 * Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
 * Output: false
 *
 *
 * Constraints:
 *
 * 2 <= coordinates.length <= 1000
 * coordinates[i].length == 2
 * -10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
 * coordinates contains no duplicate point.
 *    Hide Hint #1
 * If there're only 2 points, return true.
 *    Hide Hint #2
 * Check if all other points lie on the line defined by the first 2 points.
 *    Hide Hint #3
 * Use cross product to check collinearity.
 */
public class Day8CheckIfItIsAStraightLine {

    public static void main(String[] args) {
//        int[][] coordinates = {{1,2},{2,3},{3,4},{4,5},{5,6},{6,7}};
        int[][] coordinates = {{1,1},{2,2},{3,4},{4,5},{5,6},{7,7}};

        System.out.println(checkStraightLine(coordinates));
    }

    public static boolean checkStraightLine(int[][] coordinates) {
        if (coordinates == null || coordinates.length < 2) return false;
        if (coordinates.length == 2) return true;

        boolean isStraightLine = true;
        int[] first = coordinates[0];
        int[] second = coordinates[1];
        int x1 = first[0], y1 = first[1];
        int x2 = second[0], y2 = second[1];

        // m = (y2 - y1) / (x2 - x1)
        float m = (x2 >= x1) ? (float)(y2 - y1) / (x2 - x1) : (float)(y1 - y2) / (x1 - x2);
        for (int i = 2; i < coordinates.length; i++) {
            x2 = coordinates[i][0];
            y2 = coordinates[i][1];
            float m2 = (x2 >= x1) ? (float)(y2 - y1) / (x2 - x1) : (float)(y1 - y2) / (x1 - x2);
            if (m != m2) {
                isStraightLine = false;
                break;
            }
        }

        return isStraightLine;
    }

}