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

class DemoGraph3 {
    public static void main(String[] args) {
        WeightedGraph weightedGraph = new WeightedGraph(5);
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

        list.dfsIterative(1);
        System.out.println("");
        list.bfsIterative(1);
    }
}