import java.util.ArrayList;
import java.util.List;

public class Node {
    public int value;
    public int in;
    public int out;

    public List<Node> nextNodes;
    public List<Edge> edges;

    public Node(int value) {
        this.value = value;
        nextNodes = new ArrayList<>();
        edges = new ArrayList<>();
    }

    public void addNextNoes(Node nextNode) {
        nextNodes.add(nextNode);
    }

    public void addEdges(Edge edge) {
        edges.add(edge);
    }
}
