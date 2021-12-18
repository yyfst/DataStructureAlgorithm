import java.util.*;

public class UnionFindSet {
    public int totalSetSize;

    // 每个集合的大小：
    //   key   集合的代表节点值
    //   value 所在集合大小
    public Map<Node, Integer> eachSetSizeMap;

    // 代表节点映射：
    //   key     任意节点值
    //   value   key节点所在集合的代表节点
    public Map<Node, Node> representMap;

    // 节点映射：
    //    key:    代表节点
    //    value:  代表节点所在集合的所有节点
    public Map<Node, List<Node>> setNodeMap;

    public UnionFindSet(List<Node> nodes) {
        if (nodes == null || nodes.size() < 1) {
            return;
        }

        eachSetSizeMap = new HashMap<>();
        representMap = new HashMap<>();
        setNodeMap = new HashMap<>();
        for (Node node : nodes) {
            eachSetSizeMap.put(node, 1);
            representMap.put(node, node);
            List<Node> list = new ArrayList<>();
            list.add(node);
            setNodeMap.put(node, list);
            totalSetSize++;
        }
    }

    public void unionSet(Node node1, Node node2) {
        if (isInSameSet(node1, node2)) {
            return;
        }

        Node representNode1 = representMap.get(node1);
        Node representNode2 = representMap.get(node2);
        int size1 = eachSetSizeMap.get(representNode1);
        int size2 = eachSetSizeMap.get(representNode2);
        if (size1 < size2) {
            updateSetNodeList(representNode1, representNode2);
            eachSetSizeMap.remove(representNode1);
            updateEachSetSize(representNode2, size1 + size2);

        } else {
            updateSetNodeList(representNode2, representNode1);
            eachSetSizeMap.remove(representNode2);
            updateEachSetSize(representNode1, size1 + size2);
        }
        totalSetSize--;
    }

    public void updateSetNodeList(Node oldRepresentNode, Node newRepresentNode) {
        List<Node> oldList = setNodeMap.get(oldRepresentNode);
        List<Node> newList = setNodeMap.get(newRepresentNode);
        setNodeMap.remove(oldRepresentNode);
        newList.addAll(oldList);
        setNodeMap.put(newRepresentNode, newList);
        updateRepresentNode(oldList, newRepresentNode);
    }

    public void updateEachSetSize(Node representNode, int size) {
        eachSetSizeMap.put(representNode, size);
    }

    public void updateRepresentNode(List<Node> nodes, Node representNode) {
        for (Node node : nodes) {
            representMap.put(node, representNode);
        }
    }


    public boolean isInSameSet(Node node1, Node node2) {
        Node representNode1 = representMap.get(node1);
        Node representNode2 = representMap.get(node2);
        return representNode1 == representNode2;
    }
}
