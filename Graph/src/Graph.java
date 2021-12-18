import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    final private static int EDGE_WEIGHT_INDEX = 0;

    final private static int FROM_NODE_VALUE_INDEX = 1;

    final private static int TO_NODE_VALUE_INDEX = 2;

    public Map<Integer, Node> nodeMap;
    public List<Edge> edges;

    public Graph() {
        nodeMap = new HashMap<>();
        edges = new ArrayList<>();
    }

    public void create(int[][] graphStruct) {
        if (graphStruct == null || graphStruct.length == 0) {
            return;
        }

        for (int[] struct : graphStruct) {
            if (struct == null || struct.length == 0) {
                continue;
            }
            int edgeWeight = struct[EDGE_WEIGHT_INDEX];
            int fromNodeValue = struct[FROM_NODE_VALUE_INDEX];
            int toNodeValue = struct[TO_NODE_VALUE_INDEX];

            Node fromNode = getNode(fromNodeValue);
            addNodes2Map(fromNodeValue, fromNode);
            Node toNode = getNode(toNodeValue);
            addNodes2Map(toNodeValue, toNode);

            Edge edge = new Edge(fromNode, toNode, edgeWeight);
            edges.add(edge);

            addNodeOut(nodeMap.get(fromNodeValue));
            addNodeIn(nodeMap.get(toNodeValue));
            fromNode.addNextNoes(toNode);
            fromNode.addEdges(edge);
        }
    }

    private Node getNode(int value) {
        if (nodeMap.containsKey(value)) {
            return nodeMap.get(value);
        }

        return new Node(value);
    }

    private void addNodes2Map(int value, Node node) {
        if (nodeMap.containsKey(value)) {
            return;
        }
        nodeMap.put(value, node);
    }

    private void addNodeIn(Node node) {
        node.in++;
    }

    private void delNodeIn(Node node) {
        node.in--;
    }

    private void addNodeOut(Node node) {
        node.out++;
    }

    private void delNodeOut(Node node) {
        node.out--;
    }
}
