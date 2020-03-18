public class Main {

    public static void main(String[] args) {
	    Node root = new Node(0);
	    Node node1 = new Node(1);
        Node node2 = new Node(0);
        root.left = node1;
        root.right = node2;

        Node node3 = new Node(1);
        Node node4 = new Node(0);
        node2.left = node3;
        node2.right = node4;

        Node node5 = new Node(1);
        Node node6 = new Node(1);
        node3.left = node5;
        node3.right = node6;

        Solution solution = new Solution();
        System.out.println(solution.countUniValTree(root));
    }
}
