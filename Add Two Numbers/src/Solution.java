/*
    You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse
    order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

    You may assume the two numbers do not contain any leading zero, except the number 0 itself.

    Example:

    Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
    Output: 7 -> 0 -> 8
    Explanation: 342 + 465 = 807.
 */
public class Solution {
    /**
     * Optimized version. Read the code carefully.
     *
     * One key is to create a fake head and start from the next. Finally return the head.next.
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(); //add a fake head
        ListNode point = ans;
        int sum, plus = 0;
        while(l1 != null || l2 != null) {
            sum = plus;

            if(l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if(l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            point.next = new ListNode(sum % 10);
            point = point.next;
            plus = sum / 10;
        }

        if(plus > 0) {
            point.next = new ListNode(plus);
        }

        return ans.next;
    }
    /**
     * The key part is reverse order.
     *
     * First try works but the code is not optimized.
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbersFirstTry(ListNode l1, ListNode l2) {
        int plus = 0, localSum;
        ListNode ans = new ListNode();
        ListNode point = ans;
        while(true) {
            localSum = plus;
            if(l1 == null && l2 == null) {
                if(localSum > 0) {
                    point.next = new ListNode(localSum);
                }
                return ans.next;
            } else if(l1 == null) {
                localSum += l2.val;
                plus = localSum / 10;
                if(plus > 0) {
                    localSum = localSum % 10;
                }
                point.next = new ListNode(localSum);
                l2 = l2.next;
                point = point.next;
            } else if(l2 == null) {
                localSum += l1.val;
                plus = localSum / 10;
                if(plus > 0) {
                    localSum = localSum % 10;
                }
                point.next = new ListNode(localSum);
                l1 = l1.next;
                point = point.next;
            } else {
                localSum += l1.val + l2.val;
                plus = localSum / 10;
                if(plus > 0) {
                    localSum = localSum % 10;
                }
                point.next = new ListNode(localSum);
                l1 = l1.next;
                l2 = l2.next;
                point = point.next;
            }
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

