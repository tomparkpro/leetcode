package pro.tompark.leetcode.days30.june;

import java.util.*;

/**
 * Cheapest Flights Within K Stops
 *
 *
 * There are n cities connected by m flights. Each flight starts from city u and arrives at v with a price w.
 *
 * Now given all the cities and flights, together with starting city src and the destination dst, your task is to find the cheapest price from src to dst with up to k stops. If there is no such route, output -1.
 *
 * Example 1:
 * Input:
 * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 * src = 0, dst = 2, k = 1
 * Output: 200
 * Explanation:
 * The graph looks like this:
 *
 *
 * The cheapest price from city 0 to city 2 with at most 1 stop costs 200, as marked red in the picture.
 * Example 2:
 * Input:
 * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 * src = 0, dst = 2, k = 0
 * Output: 500
 * Explanation:
 * The graph looks like this:
 *
 *
 * The cheapest price from city 0 to city 2 with at most 0 stop costs 500, as marked blue in the picture.
 *
 *
 * Constraints:
 *
 * The number of nodes n will be in range [1, 100], with nodes labeled from 0 to n - 1.
 * The size of flights will be in range [0, n * (n - 1) / 2].
 * The format of each flight will be (src, dst, price).
 * The price of each flight will be in the range [1, 10000].
 * k is in the range of [0, n - 1].
 * There will not be any duplicated flights or self cycles.
 *
 */
public class Day14CheapestFlightsWithinKStops {

    public static void main(String[] args) {
        int n = 3;
        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
        int src = 0;
        int dst = 2;
        int K =1;

        System.out.println(new Solution().findCheapestPrice(n, flights, src, dst, K));
    }

    public static class Solution {

        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
            // define Trip class

            // populate Adj Map <Integer, List<Trip>>
            Map<Integer, List<Trip>> tripMap = populateTripMap(flights);

            // heap using PriorityQueue
            PriorityQueue<Trip> heap = new PriorityQueue<>(flights.length, Comparator.comparingInt(a -> a.cost));

            // setup BFS
            heap.addAll(tripMap.getOrDefault(src, Collections.emptyList()));

            // search node using Dijkstra Algo
            while (!heap.isEmpty()) {
                Trip lowest = heap.poll();

                // checking the dst
                if (lowest.dst == dst) {
                    return lowest.cost;
                }

                // pruning the edges(stops)
                if (lowest.stops == K) {
                    continue;
                }

                // add all edges(trips) from lowest.dst
                for (Trip trip : tripMap.getOrDefault(lowest.dst, Collections.emptyList())) {
                    heap.add(new Trip(trip.dst, lowest.cost + trip.cost, lowest.stops + 1));
                }
            }

            // return cost or -1
            return -1;
        }

        private Map<Integer, List<Trip>> populateTripMap(int[][] flights) {
            Map<Integer, List<Trip>> tripMap = new HashMap<>();
            for (int[] flight : flights) {
                List<Trip> trips = tripMap.getOrDefault(flight[0], new ArrayList<>());
                trips.add(new Trip(flight[1], flight[2], 0));
                tripMap.put(flight[0], trips);
            }
            return tripMap;
        }

        public class Trip {
            int dst;
            int cost;
            int stops;

            public Trip(int dst, int cost, int stops) {
                this.dst = dst;
                this.cost = cost;
                this.stops = stops;
            }
        }
    }

}
