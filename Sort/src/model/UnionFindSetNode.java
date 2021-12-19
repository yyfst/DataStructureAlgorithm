package model;

public class UnionFindSetNode {
    public UnionFindSetNode parent;
    public int value;

    public UnionFindSetNode(int value) {
        this.value = value;
        parent = this;
    }

    public void setParent(UnionFindSetNode node) {
        parent = node;
    }
}
