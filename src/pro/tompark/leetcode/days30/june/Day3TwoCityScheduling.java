package pro.tompark.leetcode.days30.june;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Two City Scheduling
 *
 *
 * Solution
 * There are 2N people a company is planning to interview. The cost of flying the i-th person to city A is costs[i][0], and the cost of flying the i-th person to city B is costs[i][1].
 *
 * Return the minimum cost to fly every person to a city such that exactly N people arrive in each city.
 *
 *
 *
 * Example 1:
 *
 * Input: [[10,20],[30,200],[400,50],[30,20]]
 * Output: 110
 * Explanation:
 * The first person goes to city A for a cost of 10.
 * The second person goes to city A for a cost of 30.
 * The third person goes to city B for a cost of 50.
 * The fourth person goes to city B for a cost of 20.
 *
 * The total minimum cost is 10 + 30 + 50 + 20 = 110 to have half the people interviewing in each city.
 *
 *
 * Note:
 *
 * 1 <= costs.length <= 100
 * It is guaranteed that costs.length is even.
 * 1 <= costs[i][0], costs[i][1] <= 1000
 */
public class Day3TwoCityScheduling {

    public static void main(String[] args) {
        int[][] costs = {{10,20},{30,200},{400,50},{30,20}};

        System.out.println(twoCitySchedCost(costs));
    }

    public static int twoCitySchedCost(int[][] costs) {
        int N = costs.length;
        int ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            ans += costs[i][0];
            pq.add(costs[i][1] - costs[i][0]);
            if (i >= N / 2) {
                ans += pq.poll();
            }
        }
        return ans;
    }

    public static int twoCitySchedCost2(int[][] costs) {
        Arrays.sort(costs, Comparator.comparingInt(o -> o[0] - o[1]));

        int cost = 0;
        for (int i = 0; i < costs.length; i++) {
            if (i < costs.length / 2) {
                cost += costs[i][0];
            } else {
                cost += costs[i][1];
            }
        }

        return cost;
    }

}
