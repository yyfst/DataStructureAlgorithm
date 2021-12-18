import java.util.List;

public class Edge {
    public int weight;
    public Node fromNode;
    public Node toNode;

    public Edge(Node fromNode, Node toNode, int weight) {
        this.fromNode = fromNode;
        this.toNode = toNode;
        this.weight = weight;
    }
}
