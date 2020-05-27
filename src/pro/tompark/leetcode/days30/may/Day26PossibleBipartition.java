package pro.tompark.leetcode.days30.may;

import java.util.*;

/**
 * Possible Bipartition
 * Given a set of N people (numbered 1, 2, ..., N), we would like to split everyone into two groups of any size.
 *
 * Each person may dislike some other people, and they should not go into the same group.
 *
 * Formally, if dislikes[i] = [a, b], it means it is not allowed to put the people numbered a and b into the same group.
 *
 * Return true if and only if it is possible to split everyone into two groups in this way.
 *
 *
 *
 * Example 1:
 * Input: N = 4, dislikes = [[1,2],[1,3],[2,4]]
 * Output: true
 * Explanation: group1 [1,4], group2 [2,3]
 *
 * Example 2:
 * Input: N = 3, dislikes = [[1,2],[1,3],[2,3]]
 * Output: false
 *
 * Example 3:
 * Input: N = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
 * Output: false
 *
 *
 * Note:
 *
 * 1 <= N <= 2000
 * 0 <= dislikes.length <= 10000
 * 1 <= dislikes[i][j] <= N
 * dislikes[i][0] < dislikes[i][1]
 * There does not exist i != j for which dislikes[i] == dislikes[j].
 */
public class Day26PossibleBipartition {

    public static void main(String[] args) {
        int[][] dislikes = {{1,2},{2,3},{3,4},{4,5},{1,5}};
        int N = 5;

        System.out.println(possibleBipartition(N, dislikes));
    }

    // union found split two group
    // GroupA : all hate b, GroupB: all hate a;
    public static boolean possibleBipartition(int N, int[][] dislikes) {
        int[] group = new int[N+1];
        for (int i = 0; i <= N; i++) {
            group[i] = i; // initial
        }

        for (int[] dislike : dislikes) {
            int a = dislike[0];
            int b = dislike[1];

            if (group[a] == a && group[b] == b) {
                group[a] = b;
                group[b] = a;
            } else if (group[a] == a && group[b] != b) {
                // let a go to group that all hate b;
                group[a] = group[group[b]];
            } else if (group[b] ==b && group[a] != a) {
                group[b] = group[group[a]];
            } else if (group[b] == group[a]) {
                return false;
            }
        }
        
        return true;
    }

    public static boolean possibleBipartition2(int N, int[][] dislikes) {
        int[] groups = new int[N];
        Arrays.fill(groups, -1);

        List<Integer>[] adj = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] p : dislikes) {
            adj[p[0] - 1].add(p[1] - 1);
            adj[p[1] - 1].add(p[0] - 1);
        }

        for (int i = 0; i < N; i++) {
            if (groups[i] == -1 && !dfs(adj, groups, i, 0)) {
                return false;
            }
        }

        return true;
    }

    private static boolean dfs(List<Integer>[] adj, int[] groups, int v, int grp) {
        if (groups[v] == -1) groups[v] = grp;
        else return groups[v] == grp;

        for (int n : adj[v]) {
            if (!dfs(adj, groups, n, 1 - grp)) {
                return false;
            }
        }

        return true;
    }
}