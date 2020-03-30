public class Node {
    public Integer value;
    public Node next;

    public Node(Integer value) {
        this.value = value;
    }

    public Node add(Integer value) {
        next = new Node(value);
        return next;
    }
}
