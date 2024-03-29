package dsa.graph_general;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Heshan Karunaratne
 */
public class CourseSchedule2 {

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] adj = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new LinkedList<>();
        }
        for (int[] courses : prerequisites) {
            adj[courses[1]].add(courses[0]);
        }
        List<Integer> s = new LinkedList<>();
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0 && dfs(i, adj, s, visited)) return new int[0];
        }
        Collections.reverse(s);
        int[] result = s.stream().mapToInt(Integer::intValue).toArray();
        return result;
    }

    private static boolean dfs(int u, List<Integer>[] adj, List<Integer> s, int[] visited) {
        visited[u] = 1;

        for (int v : adj[u]) {
            if (visited[v] == 1) return true;
            if (visited[v] == 0 && dfs(v, adj, s, visited)) return true;
        }

        visited[u] = 2;
        s.add(u);
        return false;
    }

    public static void main(String[] args) {
        int[][] preReq = {{1, 0}, {2, 0}, {3, 1}};
        int[] output = findOrder(4, preReq);
        System.out.println(Arrays.toString(output));
    }
}
