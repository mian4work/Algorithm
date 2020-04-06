public class Main {

    public static void main(String[] args) {
	    Solution solution = new Solution();

	    Node head = new Node(1);
	    head.addNext(2).addNext(3).addNext(4).addNext(5).addNext(6).addNext(7).addNext(8).addNext(9).addNext(10);

	    printList(head);
	    solution.remove(head, 4);
	    printList(head);
    }

    static void printList(Node head) {
        Node node = head;
        while(node.next != null) {
            System.out.print("[" + node.value + "]");
            node = node.next;
        }

        System.out.println();
    }
}
