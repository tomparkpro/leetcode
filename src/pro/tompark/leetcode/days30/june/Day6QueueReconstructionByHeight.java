package pro.tompark.leetcode.days30.june;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Queue Reconstruction by Height
 *
 *
 * Suppose you have a random list of people standing in a queue.
 * Each person is described by a pair of integers (h, k),
 * where h is the height of the person and k is the number of people in front of this person
 * who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.
 *
 * Note:
 * The number of people is less than 1,100.
 *
 *
 * Example
 *
 * Input:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 *
 * Output:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 *
 *
 *    Hide Hint #1
 * What can you say about the position of the shortest person?
 * If the position of the shortest person is i, how many people would be in front of the shortest person?
 *    Hide Hint #2
 * Once you fix the position of the shortest person, what can you say about the position of the second shortest person?
 */
public class Day6QueueReconstructionByHeight {

    public static void main(String[] args) {
        int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};

        int[][] result = reconstructQueue(people);
        for (int[] res : result) {
            System.out.print(res[0] + "," + res[1] + " ");
        }
    }

    static int[][] reconstructQueue(int[][] people) {
        List<int[]> result = new ArrayList<>();

        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);

        for (int[] x : people) {
            result.add(x[1], x);
        }

        return result.toArray(new int[people.length][2]);
    }
}
