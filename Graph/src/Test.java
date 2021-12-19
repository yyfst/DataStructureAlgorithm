import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
//        TestBfs();
//        TestDfs();
        TestKruskal();
    }

    private static void TestKruskal() {

        int[][] data1 = new int[][]{
                {4, 1, 2},
                {10, 1, 4},
                {7, 1, 6},
                {2, 2, 3},
                {5, 4, 5},
                {8, 6, 5},
                {10, 3, 5}
        };

        int[][] data2 = new int[][]{
                {5, 1, 2},
                {9, 2, 10},
                {18, 10, 11},
                {11, 11, 15},
                {12, 15, 5},
                {8, 1, 7},
                {4, 7, 10},
                {1, 10, 8},
                {51, 8, 7},
                {80, 8, 5},
                {21, 8, 15}
        };


        Kruskal kruskal = new Kruskal(null);
        kruskal.kruskalMST();
        for (Edge edge : kruskal.getResult()) {
            System.out.println(edge.weight);
        }


    }


    private static void TestDfs() {
        int[][] data1 = new int[][]{
                {4, 1, 2},
                {10, 1, 4},
                {7, 1, 6},
                {2, 2, 3},
                {5, 4, 5},
                {8, 6, 5},
                {10, 3, 5}
        };

        int[][] data2 = new int[][]{
                {5, 1, 2},
                {9, 2, 10},
                {18, 10, 11},
                {11, 11, 15},
                {12, 15, 5},
                {8, 1, 7},
                {4, 7, 10},
                {1, 10, 8},
                {51, 8, 7},
                {80, 8, 5},
                {21, 8, 15}
        };


        DFS dfs = new DFS();
        dfs.graph.create(data2);
        List<Integer> result = new ArrayList<>();
        if (dfs.graph.edges.size() > 0) {
            Node beginNode = dfs.graph.edges.get(0).fromNode;
            result = dfs.graphDfs(beginNode);
        }

        System.out.println(result);
    }

    private static void TestBfs() {
        int[][] data1 = new int[][]{
                {4, 1, 2},
                {10, 1, 4},
                {7, 1, 6},
                {2, 2, 3},
                {5, 4, 5},
                {8, 6, 5},
                {10, 3, 5}
        };

        int[][] data2 = new int[][]{
                {5, 1, 2},
                {18, 10, 11},
                {11, 11, 15},
                {12, 15, 5},
                {8, 1, 7},
                {4, 7, 10},
                {1, 10, 8},
                {51, 8, 7},
                {9, 2, 10},
                {80, 8, 5},
                {21, 8, 15}
        };

        BFS bfs = new BFS();
        bfs.graph.create(new int[0][0]);
        List<Integer> result = new ArrayList<>();
        if (bfs.graph.edges.size() > 0) {
            Node beginNode = bfs.graph.edges.get(0).fromNode;
            result = bfs.graphBfs(beginNode);
        }

        System.out.println(result);
    }

}
