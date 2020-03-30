import java.util.HashSet;
import java.util.Set;

/*
    Given two singly linked lists that intersect at some point, find the intersecting node. The lists are non-cyclical.

    For example, given A = 3 -> 7 -> 8 -> 10 and B = 99 -> 1 -> 8 -> 10, return the node with value 8.

    In this example, assume nodes with the same value are the exact same node objects.

    Do this in O(M + N) time (where M and N are the lengths of the lists) and constant space
 */
public class Solution {

    public int joint(Node l1, Node l2) {
        if(l1 == null || l2 == null) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();

        Node index = l1;
        while(index != null) {
            set.add(index.value);
            index = index.next;
        }

        index = l2;
        while (index != null) {
            if(!set.add(index.value)) {
                return index.value;
            }
            index = index.next;
        }

        return 0;
    }
}
