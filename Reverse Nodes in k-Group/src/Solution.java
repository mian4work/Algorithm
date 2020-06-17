/*
    Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

    k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is
    not a multiple of k then left-out nodes in the end should remain as it is.

    Example:

    Given this linked list: 1->2->3->4->5

    For k = 2, you should return: 2->1->4->3->5

    For k = 3, you should return: 3->2->1->4->5

    Note:

    Only constant extra memory is allowed.
    You may not alter the values in the list's nodes, only nodes itself may be changed.
 */
public class Solution {
    /**
     * This is the test from Discovery
     *
     * A in-place exchange can do the work:
     *
     *      1. set three points: prev, curr, next
     *      2. next is to remember the next node
     *      3. change prev -> curr to curr -> prev
     *      4. move curr to next
     *      5. use a count to count to k
     *      6. a in-place reverse is demo-ed in https://media.geeksforgeeks.org/wp-content/cdn-uploads/RGIF2.gif
     *
     * After k node reversed, next now points to k+1 node, check if next is null, if not, recursively call the same
     * method with next as head. REMEMBER, assign the calculated on to head.next so they can be linked together.
     *
     * Now prev is the head so return it.
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;
        int index = 0;

        while(index < k && curr != null) {
            //in-place reverse
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            index++;
        }

        if(next != null) {
            //!!!! this is very important!!!
            //this will connect
            head.next = reverseKGroup(next, k);
        }

        return prev;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
