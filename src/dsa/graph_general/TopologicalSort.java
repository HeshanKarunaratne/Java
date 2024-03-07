package dsa.graph_general;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author Heshan Karunaratne
 */
public class TopologicalSort {

    static int[] topoSort(int V, List<List<Integer>> adj) {
        int[] visited = new int[V];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                dfs(i, visited, stack, adj);
            }
        }

        int ans[] = new int[V];
        int i = 0;
        while (!stack.isEmpty()) {
            ans[i++] = stack.peek();
            stack.pop();
        }
        return ans;
    }

    private static void dfs(int node, int[] visited, Stack<Integer> stack, List<List<Integer>> adj) {
        visited[node] = 1;
        for (Integer i : adj.get(node)) {
            if (visited[i] == 0) {
                dfs(i, visited, stack, adj);
            }
        }
        stack.push(node);
    }

    public static void main(String[] args) {
        int[] output = topoSort(4, List.of(List.of(1, 0), List.of(2, 0), List.of(3, 1), List.of(3, 2)));
        System.out.println(Arrays.toString(output));
    }
}
