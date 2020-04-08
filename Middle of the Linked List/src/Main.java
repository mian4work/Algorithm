public class Main {

    public static void main(String[] args) {
	    ListNode one = new ListNode(1);
	    ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        ListNode six = new ListNode(6);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;

        Solution solution = new Solution();
        printList(one);
        printList(solution.middleNode(one));
    }

    static void printList(ListNode node) {
        while(node != null) {
            System.out.print("[" + node.val + "]");
            node = node.next;
        }

        System.out.println();
    }
}
