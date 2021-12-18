public class Main {
    public static void main(String[] args) {
        Node node1 = new Node(2);
        Node node2 = new Node(2);
        System.out.println(new Node(1));
        System.out.println(new Node(1));


        System.out.println(node1.hashCode());
        System.out.println(node2.hashCode());

        System.out.println(node1);
        System.out.println(node2);
    }
}
