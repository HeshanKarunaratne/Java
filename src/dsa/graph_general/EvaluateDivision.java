package dsa.graph_general;

import java.util.*;

/**
 * @author Heshan Karunaratne
 */
public class EvaluateDivision {

    static class Node {
        private String key;
        private double val;

        public Node(String key, double val) {
            this.key = key;
            this.val = val;
        }
    }

    public static void main(String[] args) {
        List<List<String>> equations = List.of(List.of("a", "b"), List.of("b", "c"));
        double[] values = {2.0, 3.0};
        List<List<String>> queries = List.of(List.of("a", "c"), List.of("b", "a"), List.of("a", "e"), List.of("a", "a"), List.of("x", "x"));
        double[] output = calcEquation(equations, values, queries);
        System.out.println(output);
    }

    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        Map<String, List<Node>> graph = buildGraph(equations, values);
        double[] result = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            result[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), new HashSet(), graph);
        }

        return result;
    }

    private static double dfs(String src, String des, Set<String> visited, Map<String, List<Node>> graph) {
        if (!graph.containsKey(src) || !graph.containsKey(des)) return -1.0;

        if (src.equals(des)) return 1.0;

        visited.add(src);
        for (Node neighbor : graph.get(src)) {
            if (!visited.contains(neighbor.key)) {
                double ans = dfs(neighbor.key, des, visited, graph);
                if (ans != -1.0) return ans * neighbor.val;
            }
        }
        return -1.0;
    }

    private static Map<String, List<Node>> buildGraph(List<List<String>> equations, double[] values) {
        Map<String, List<Node>> graph = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            String src = equations.get(i).get(0);
            String des = equations.get(i).get(1);
            graph.putIfAbsent(src, new ArrayList<>());
            graph.putIfAbsent(des, new ArrayList<>());
            graph.get(src).add(new Node(des, values[i]));
            graph.get(des).add(new Node(src, 1 / values[i]));
        }
        return graph;
    }

}
