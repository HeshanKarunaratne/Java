package theory.graphs;

import java.util.*;

/**
 * @author Heshan Karunaratne
 */
public class GraphAdjacencyList {
    private Map<Integer, List<Integer>> adjacencyList;

    public GraphAdjacencyList() {
        this.adjacencyList = new HashMap<>();
    }

    public void addVertex(int vertex) {
        adjacencyList.put(vertex, new LinkedList<>());
    }

    public void removeVertex(int vertex) {
        adjacencyList.remove(vertex);
        for (List<Integer> neighbors : adjacencyList.values()) {
            neighbors.remove((Integer) vertex);
        }
    }

    public void addEdge(int source, int destination) {
        adjacencyList.get(source).add(destination);
        adjacencyList.get(destination).add(source);
    }

    public void removeEdge(int source, int destination) {
        adjacencyList.get(source).remove((Integer) destination);
        adjacencyList.get(destination).remove((Integer) source);
    }

    public void dfsIterative(int vertex) {
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        stack.push(vertex);

        while (!stack.isEmpty()) {
            Integer currentVertex = stack.pop();
            if (!visited.contains(currentVertex)) {
                System.out.print(currentVertex + " ");
                visited.add(currentVertex);
                for (int neighbor : adjacencyList.getOrDefault(currentVertex, Collections.emptyList())) {
                    if (!visited.contains(neighbor)) {
                        stack.push(neighbor);
                    }
                }
            }
        }
    }

    public void bfsIterative(int vertex) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.add(vertex);
        visited.add(vertex);

        while (!queue.isEmpty()) {
            Integer currentVertex = queue.poll();
            System.out.print(currentVertex + " ");

            for (int neighbor : adjacencyList.getOrDefault(currentVertex, Collections.emptyList())) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }

        }
    }

}

class DemoGraph2 {
    public static void main(String[] args) {
        GraphAdjacencyList list = new GraphAdjacencyList();
        list.addVertex(1);
        list.addVertex(2);
        list.addVertex(3);
        list.addVertex(4);
        list.addVertex(5);

        list.addEdge(1, 4);
        list.addEdge(1, 3);
        list.addEdge(1, 2);
        list.addEdge(3, 5);
        list.addEdge(2, 3);
//        list.removeEdge(1, 2);
//        list.removeVertex(1);

        list.dfsIterative(1);
        System.out.println("");
        list.bfsIterative(1);
    }
}