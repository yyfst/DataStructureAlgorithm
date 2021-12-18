import java.util.*;

public class Kruskal {
    private final Graph graph;
    private final PriorityQueue<Edge> edgePriorityQueue;
    private final UnionFindSet unionFindSet;


    private final List<Edge> result;


    public Kruskal(int[][] graphStruct) {
        result = new ArrayList<>();
        graph = new Graph();
        graph.create(graphStruct);
        unionFindSet = new UnionFindSet(new ArrayList<>(graph.nodeMap.values()));
        edgePriorityQueue = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        });
    }

    public void setEdgePriorityQueue(List<Edge> edges) {
        edgePriorityQueue.addAll(edges);
    }

    public void kruskalMST() {
        setEdgePriorityQueue(graph.edges);
        while (!edgePriorityQueue.isEmpty()) {
            Edge edge = edgePriorityQueue.poll();
            Node from = edge.fromNode;
            Node to = edge.toNode;

            if (!unionFindSet.isInSameSet(from, to)) {
                unionFindSet.unionSet(from, to);
                result.add(edge);
                System.out.println("not union set, new edge: " + edge.weight);
                System.out.println("from: " + from.value + "  to: " + to.value);
            } else {

                System.out.println("do not need this edge: " + edge.weight);
                System.out.println("from: " + from.value + "  to: " + to.value);
            }
            System.out.println("---------------");
        }

        System.out.println("set num: " + String.valueOf(unionFindSet.totalSetSize));
    }

    @Override
    public String toString() {
        return "Kruskal{" +
                "result=" + result +
                '}';
    }

    public List<Edge> getResult() {
        return result;
    }
}
