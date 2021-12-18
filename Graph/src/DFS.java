import java.util.*;

public class DFS {
    public Graph graph;

    public DFS() {
        graph = new Graph();
    }

    public List<Integer> graphDfs(Node beginNode) {
        if (beginNode == null) {
            return Collections.emptyList();
        }

        List<Integer> result = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(beginNode);
        result.add(beginNode.value);
        while (!stack.isEmpty()) {
            Node curNode = stack.peek();
            if (curNode.nextNodes.size() == 0) {
                stack.pop();
                continue;
            }

            int index = 0;
            while (index < curNode.nextNodes.size()) {
                if (!result.contains(curNode.nextNodes.get(index).value)) {
                    stack.push(curNode.nextNodes.get(index));
                    result.add(curNode.nextNodes.get(index).value);
                    break;
                }
                index++;
            }

            if (index == curNode.nextNodes.size()) {
                stack.pop();
            }
        }
        return result;
    }
}
