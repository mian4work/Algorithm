
class Solution {
    /**
     * 1. Define three pointers pStart, pOdd, pNextOdd
     * 2. Locate pOdd
     * 3. Locate pOddNext by +2
     * 4. Cut pOdd from list
     * 5. Append pOdd pStart
     * 6. Update pStart to next
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        if(head == null) {
            return null;
        }

        if(head.next == null) {
            return head;
        }

        ListNode pStart = head, pEven = head.next, pOdd = head.next.next;
        while(pOdd != null) {
            pEven.next = pOdd.next;
            pEven = pEven.next;

            ListNode node = pStart.next;
            ListNode next = pOdd.next;

            pStart.next = pOdd;
            pOdd.next = node;
            pStart = pStart.next;

            pOdd = next == null ? null : next.next;
        }

        return head;
    }
}

/*
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}