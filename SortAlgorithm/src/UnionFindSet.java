import model.UnionFindSetNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UnionFindSet {
    private static int unionFindSetSize;
    private static List<UnionFindSetNode> nodes;
    private static final Map<UnionFindSetNode, Integer> setNodeSizeMap = new HashMap<>();
    private static final Map<UnionFindSetNode, UnionFindSetNode> nodeParentMap = new HashMap<>();

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        unionFindSetInit(list);
        System.out.println(getUnionFindSetSize());
        boolean isSame1 = isSameSet(nodes.get(1), nodes.get(2));
        System.out.println(isSame1);

        unionSet(nodes.get(1), nodes.get(2));
        unionSet(nodes.get(0), nodes.get(2));
        boolean isSame2 = isSameSet(nodes.get(0), nodes.get(2));
        System.out.println(isSame2);
        System.out.println(getUnionFindSetSize());
        System.out.println(getSetSize(nodes.get(0)));

        findParentNode(nodes.get(2));
        System.out.println(nodeParentMap.size());
    }

    public static void unionFindSetInit(List<Integer> list) {
        nodes = new ArrayList<>();
        for (int value : list) {
            UnionFindSetNode unionFindSetNode = new UnionFindSetNode(value);
            nodes.add(unionFindSetNode);
            nodeParentMap.put(unionFindSetNode, unionFindSetNode);
            setNodeSizeMap.put(unionFindSetNode, 1);
            unionFindSetSize++;
        }
    }

    // 判断两个节点是否位于同一个集合里
    // TODO 可以优化，直接查父节点表来判断
    public static boolean isSameSet(UnionFindSetNode data1, UnionFindSetNode data2) {
        UnionFindSetNode node1 = findParentNode(data1);
        UnionFindSetNode node2 = findParentNode(data2);
        if (node1 == null || node2 == null) {
            return false;
        }
        return node1 == node2;
    }

    // 查找某个节点的父节点
    private static UnionFindSetNode findParentNode(UnionFindSetNode data) {
        if (nodeParentMap.containsKey(data)) {
            return nodeParentMap.get(data);
        }

        UnionFindSetNode parent = data;
        List<UnionFindSetNode> nodes = new ArrayList<>();
        while (data.parent != data) {
            nodes.add(data);
            parent = data.parent;
            data = data.parent;
        }

        for (UnionFindSetNode node : nodes) {
            nodeParentMap.put(node, parent);
        }

        return parent;
    }

    // 合并两个节点所在的集合
    public static void unionSet(UnionFindSetNode node1, UnionFindSetNode node2) {
        // 判断是否已经处于同一个集合
        if (isSameSet(node1, node2)) {
            System.out.println("is same set, stop union!");
            return;
        }

        if (setNodeSizeMap.get(node1) > setNodeSizeMap.get(node2)) {
            UnionFindSetNode node = node2;
            node2.setParent(findParentNode(node1));
            setNodeSizeMap.remove(node2);
            setNodeSizeMap.put(node1, setNodeSizeMap.get(node1) + 1);

            while (node.parent != node) {
                delParentNode(node);
                node = node.parent;
            }
            delParentNode(node);

        } else {
            UnionFindSetNode node = node1;
            node1.setParent(findParentNode(node2));
            setNodeSizeMap.remove(node1);
            setNodeSizeMap.put(node2, setNodeSizeMap.get(node2) + 1);

            while (node.parent != node) {
                delParentNode(node);
                node = node.parent;
            }
            delParentNode(node);
        }

        unionFindSetSize--;
    }

    // 获取并查集的集合数量
    public static int getUnionFindSetSize() {
        return unionFindSetSize;
    }

    // 获取单个节点所处集合的节点数量
    public static int getSetSize(UnionFindSetNode node) {
        return setNodeSizeMap.get(findParentNode(node));
    }

    private static void delParentNode(UnionFindSetNode node) {
        nodeParentMap.remove(node);
    }
}
