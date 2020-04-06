/*
    This problem was asked by Google.

    Given a singly linked list and an integer k, remove the kth last element from the list.
    k is guaranteed to be smaller than the length of the list.

    The list is very long, so making more than one pass is prohibitively expensive.

    Do this in constant space and in one pass.
 */
public class Solution {
    /**
     * This is a typical two points problem.
     * 
     * @param head
     * @param k
     */
    public void remove(Node head, int k) {
        if(head == null) {
            return;
        }

        int index = 0;
        Node start = head;
        Node end = head;

        while(index < k) {
            end = end.next;
            index++;
        }

        while(end.next != null) {
            start = start.next;
            end = end.next;
        }

        start.next = null;
    }
}
