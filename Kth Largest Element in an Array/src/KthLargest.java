import java.util.PriorityQueue;

/*
    Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order,
    not the kth distinct element.

    Example 1:

    Input: [3,2,1,5,6,4] and k = 2
    Output: 5

    Example 2:

    Input: [3,2,3,1,2,4,5,5,6] and k = 4
    Output: 4

    Note:
    You may assume k is always valid, 1 ≤ k ≤ array's length.
 */

/**
 * The smart solution is to create a min priority queue. Keep the size of the queue to k so the kth largest element is
 * the minimum element.
 */
public class KthLargest {
    int k;
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int n : nums) {
            pq.offer(n);

            if(pq.size() > k) {
                pq.poll();
            }
        }
    }

    public int add(int val) {
        pq.offer(val);
        if(pq.size() > k) {
            pq.poll();
        }

        return pq.peek();
    }
}
