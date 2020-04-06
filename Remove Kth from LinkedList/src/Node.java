public class Node {
    public int value;
    public Node next;

    public Node(int value) {
        this.value = value;
    }

    public Node addNext(int value) {
        this.next = new Node(value);
        return next;
    }
}
