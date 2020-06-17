public class Main {

    public static void main(String[] args) {
	    Solution solution = new Solution();
	    ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
	    printNode(head);
	    ListNode ans = solution.reverseKGroup(head, 3);
	    printNode(ans);
    }

    static void printNode(ListNode node) {
        StringBuilder builder = new StringBuilder();
        while(node != null) {
            builder.append(node.val + "->");
            node = node.next;
        }

        System.out.println(builder.subSequence(0, builder.length() - 2).toString());
    }
}
