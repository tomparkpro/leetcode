package pro.tompark.leetcode.days30.may;

import java.util.ArrayList;
import java.util.List;

/**
 * Course Schedule
 *
 *
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.
 *
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 *
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 *
 *
 *
 * Example 1:
 *
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 *              To take course 1 you should have finished course 0. So it is possible.
 *
 *
 * Example 2:
 *
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 *              To take course 1 you should have finished course 0, and to take course 0 you should
 *              also have finished course 1. So it is impossible.
 *
 *
 * Constraints:
 *
 * The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
 * You may assume that there are no duplicate edges in the input prerequisites.
 * 1 <= numCourses <= 10^5
 *
 *    Hide Hint #1
 * This problem is equivalent to finding if a cycle exists in a directed graph. If a cycle exists, no topological ordering exists and therefore it will be impossible to take all courses.
 *    Hide Hint #2
 * Topological Sort via DFS - A great video tutorial (21 minutes) on Coursera explaining the basic concepts of Topological Sort.
 *    Hide Hint #3
 * Topological sort could also be done via BFS.
 */
public class Day28CourseSchedule {

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}, {0, 1}};

        System.out.println(canFinish(numCourses, prerequisites));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] adjList = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int[] pre : prerequisites) {
            adjList[pre[0]].add(pre[1]);
        }

        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0 && !dfs(adjList, visited, i)) return false;
        }


        return true;
    }

    /**
     * visited
     * 0 ==> unvisited
     * 1 ==> being visited
     * 2 ==> completely visited
     */
    private static boolean dfs(List<Integer>[] adj, int[] visited, int v) {
        if (visited[v] == 1) return false;

        visited[v] = 1;
        for(int ad : adj[v]) {
            if (!dfs(adj, visited, ad)) return false;
        }
        visited[v] = 2;

        return true;
    }

    public static boolean canFinish2(int numCourses, int[][] prerequisites) {
        boolean[] visited = new boolean[numCourses];
        boolean[] completed = new boolean[numCourses];

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            adjList.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i] && !completed[i]) {
                if(!isPossible(adjList, i, visited, completed)) return false;
            }
        }

        return true;
    }

    private static boolean isPossible(List<List<Integer>> adjList, int v, boolean[] visited, boolean[] completed) {
        if (visited[v] && !completed[v]) return false;

        visited[v] = true;
        for (int adj : adjList.get(v)) {
            if (!isPossible(adjList, adj, visited, completed)) return false;
        }
        completed[v] = true;

        return true;
    }
}