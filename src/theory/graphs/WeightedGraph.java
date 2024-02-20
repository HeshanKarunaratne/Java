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

}