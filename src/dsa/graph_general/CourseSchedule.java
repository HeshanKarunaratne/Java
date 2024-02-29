package dsa.graph_general;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heshan Karunaratne
 */
public class CourseSchedule {
    static List<Integer>[] adj;
    static boolean[] visited;
    static boolean[] marked;

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        adj = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new ArrayList<>();
        }

        visited = new boolean[numCourses];
        marked = new boolean[numCourses];

        for (int[] item : prerequisites) {
            adj[item[0]].add(item[1]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (isCyclic(i)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isCyclic(int i) {
        visited[i] = true;

        for (Integer j : adj[i]) {
            if (!visited[j]) {
                if (isCyclic(j)) {
                    return true;
                }
            } else if (!marked[j]) {
                return true;
            }
        }
        marked[i] = true;
        return false;
    }

    public static void main(String[] args) {
        int[][] preReq = {{1, 0}, {0, 1}};
        boolean b = canFinish(2, preReq);
        System.out.println(b);
    }
}
