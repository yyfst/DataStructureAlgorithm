public class UnionFindNode {
    public int value;

    public UnionFindNode parent;

    public UnionFindNode(int value) {
        this.value=value;
        parent = this;
    }
}
