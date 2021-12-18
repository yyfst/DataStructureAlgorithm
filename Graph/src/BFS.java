import java.util.*;

public class BFS {
    public Graph graph;

    public BFS() {
        graph = new Graph();
    }

    public List<Integer> graphBfs(Node beginNode) {
        if (beginNode == null) {
            return Collections.emptyList();
        }

        List<Integer> result = new ArrayList<>();   // 结果集
        Set<Integer> visited = new HashSet<>();     // 已访问过节点
        Queue<Node> queue = new LinkedList<>();     // 保存当前访问节点的指向节点
        queue.add(beginNode);
        result.add(beginNode.value);
        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            for (Node data : curNode.nextNodes) {
                if (visited.contains(data.value)) {
                    continue;
                }

                result.add(data.value);
                visited.add(data.value);
                queue.add(data);
            }
        }
        return result;
    }
}
