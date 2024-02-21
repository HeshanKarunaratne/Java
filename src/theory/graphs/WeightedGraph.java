package theory.graphs;

import java.util.*;

/**
 * @author Heshan Karunaratne
 */
public class WeightedGraph {
    private int vertices;
    private List<GraphEdge>[] adjacencyList;

    public WeightedGraph(int vertices) {
        this.vertices = vertices;
        this.adjacencyList = new ArrayList[vertices];

        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
    }

    public void addDirectedEdge(int source, int destination, int weight) {
        GraphEdge edge = new GraphEdge(source, destination, weight);
        adjacencyList[source].add(edge);
    }

    public void addUndirectedEdge(int source, int destination, int weight) {
        GraphEdge sourceToDestinationEdge = new GraphEdge(source, destination, weight);
        GraphEdge destinationToSourceEdge = new GraphEdge(destination, source, weight);
        adjacencyList[source].add(sourceToDestinationEdge);
        adjacencyList[destination].add(destinationToSourceEdge);
    }

    public List<GraphEdge>[] getVertices() {
        return adjacencyList;
    }

    public static List<GraphEdge> primMST(WeightedGraph graph) {

        List<GraphEdge>[] vertices = graph.getVertices();
        boolean[] inMST = new boolean[vertices.length];
        PriorityQueue<GraphEdge> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(GraphEdge::getWeight));

        List<GraphEdge> mstEdges = new ArrayList<>();
        int startVertex = 0;
        inMST[startVertex] = true;

        priorityQueue.addAll(vertices[startVertex]);

        while (!priorityQueue.isEmpty()) {
            GraphEdge currentEdge = priorityQueue.poll();
            int destination = currentEdge.getDestination();
            if (inMST[destination]) continue;
            mstEdges.add(currentEdge);
            inMST[destination] = true;
            priorityQueue.addAll(vertices[destination]);

        }
        return mstEdges;
    }

    public static List<GraphEdge> kruskalMST(WeightedGraph graph) {

        List<GraphEdge>[] vertices = graph.getVertices();
        PriorityQueue<GraphEdge> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(GraphEdge::getWeight));

        for (List<GraphEdge> edges : vertices)
            priorityQueue.addAll(edges);

        List<GraphEdge> kruskalEdges = new ArrayList<>();
        Set<Integer> visitedSet = new HashSet<>();

        while (!priorityQueue.isEmpty()) {
            GraphEdge currentEdge = priorityQueue.poll();

            if (visitedSet.contains(currentEdge.getSource()) && visitedSet.contains(currentEdge.getDestination()))
                continue;

            visitedSet.add(currentEdge.getSource());
            visitedSet.add(currentEdge.getDestination());
            kruskalEdges.add(currentEdge);
        }
        return kruskalEdges;
    }

    public static int[] dijkstrasMST(WeightedGraph graph, int source) {

        int[] distances = new int[graph.getVertices().length];
        Arrays.fill(distances, Integer.MAX_VALUE);
        PriorityQueue<GraphEdge> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(GraphEdge::getWeight));
        distances[source] = 0;
        priorityQueue.add(new GraphEdge(source, source, 0));

        while (!priorityQueue.isEmpty()) {
            GraphEdge currentEdge = priorityQueue.poll();

            int destination = currentEdge.getDestination();
            for (GraphEdge edge : graph.getVertices()[destination]) {
                int newDistance = distances[destination] + edge.getWeight();

                if (newDistance < distances[edge.getDestination()]) {
                    distances[edge.getDestination()] = newDistance;
                    priorityQueue.add(new GraphEdge(edge.getSource(), edge.getDestination(), newDistance));
                }
            }
        }
        return distances;
    }

    public static Map<Integer, Integer> colorGraph(WeightedGraph graph) {

        List<GraphEdge>[] vertices = graph.getVertices();
        Map<Integer, Integer> colorMap = new HashMap<>();

        for (int vertex = 0; vertex < vertices.length; vertex++) {
            Set<Integer> neighborColors = new HashSet<>();

            for (GraphEdge edge : vertices[vertex]) {
                if (colorMap.containsKey(edge.getDestination())) {
                    neighborColors.add(colorMap.get(edge.getDestination()));
                }
            }

            int color = 1;
            while (neighborColors.contains(color)) {
                color++;
            }

            colorMap.put(vertex, color);
        }

        return colorMap;
    }
}

class DemoWeightGraph {

    public static void main(String[] args) {
        WeightedGraph weightedGraph = new WeightedGraph(7);
        weightedGraph.addUndirectedEdge(0, 1, 2);
        weightedGraph.addUndirectedEdge(1, 2, 4);
        weightedGraph.addUndirectedEdge(1, 4, 1);
        weightedGraph.addUndirectedEdge(4, 5, 9);
        weightedGraph.addUndirectedEdge(4, 6, 1);
        weightedGraph.addUndirectedEdge(6, 3, 2);

        List<GraphEdge>[] vertices = weightedGraph.getVertices();
        System.out.println(vertices);

        List<GraphEdge> graphEdges = WeightedGraph.primMST(weightedGraph);
        List<GraphEdge> kruskalEdges = WeightedGraph.kruskalMST(weightedGraph);
        int[] dijkstrasEdges = WeightedGraph.dijkstrasMST(weightedGraph, 0);
        Map<Integer, Integer> map = WeightedGraph.colorGraph(weightedGraph);
    }
}