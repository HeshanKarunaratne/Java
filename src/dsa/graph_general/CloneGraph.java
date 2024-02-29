package dsa.graph_general;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Heshan Karunaratne
 */
public class CloneGraph {
    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public static Node cloneGraph(Node node) {
        if (node == null) return null;
        Map<Integer, Node> map = new HashMap<>();
        return cloneGraph(node, map);
    }

    private static Node cloneGraph(Node node, Map<Integer, Node> map) {
        if (map.containsKey(node.val)) return map.get(node.val);
        Node copy = new Node(node.val);
        map.put(node.val, copy);

        for (Node neighbor : node.neighbors) {
            copy.neighbors.add(cloneGraph(neighbor, map));
        }

        return copy;
    }

}
