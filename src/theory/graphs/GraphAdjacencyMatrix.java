package theory.graphs;

/**
 * @author Heshan Karunaratne
 */
public class GraphAdjacencyMatrix {
    private int adjMatrix[][];
    private int numVertices;

    public GraphAdjacencyMatrix(int numVertices) {
        this.numVertices = numVertices;
        this.adjMatrix = new int[numVertices][numVertices];
    }

    public void addEdge(int i, int j) {
        adjMatrix[i - 1][j - 1] = 1;
        adjMatrix[j - 1][i - 1] = 1;
    }

    public void removeEdge(int i, int j) {
        adjMatrix[i - 1][j - 1] = 0;
        adjMatrix[j - 1][i - 1] = 0;
    }

    public void addVertex() {
        int[][] newAdjMatrix = new int[numVertices + 1][numVertices + 1];

        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                newAdjMatrix[i][j] = adjMatrix[i][j];
            }
        }
        adjMatrix = newAdjMatrix;
        numVertices++;
    }

    public void removeVertex(int v) {
        int[][] newAdjMatrix = new int[numVertices - 1][numVertices - 1];

        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (i != v && j != v) {
                    newAdjMatrix[i][j] = adjMatrix[i][j];
                }
            }
        }
        adjMatrix = newAdjMatrix;
        numVertices--;
    }
}

class DemoGraph {

    public static void main(String[] args) {
        GraphAdjacencyMatrix graph = new GraphAdjacencyMatrix(4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(4, 3);
        graph.addEdge(1, 3);
        graph.removeEdge(1, 3);

        graph.addVertex();
        graph.addEdge(5, 5);

        graph.removeVertex(4);
    }
}