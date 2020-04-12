import java.util.PriorityQueue;

/*
    We have a collection of stones, each stone has a positive integer weight.

    Each turn, we choose the two heaviest stones and smash them together.
    Suppose the stones have weights x and y with x <= y.  The result of this smash is:
    If x == y, both stones are totally destroyed;
    If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
    At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)

    Example 1:

    Input: [2,7,4,1,8,1]
    Output: 1
    Explanation:
    We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
    we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
    we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
    we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of last stone.

    Note:

    1 <= stones.length <= 30
    1 <= stones[i] <= 1000
 */
public class Solution {
    /**
     * Mine is 100%
     *
     * The main idea is to do a insertion sort (for short list, insertion sort is quick). Then pick up the first two and
     * calculate the result. put the result in the second position and sort the rest of the array from the second position.
     *
     * @param stones
     * @return
     */
    public int lastStoneWeight(int[] stones) {
        if(stones == null) {
            return 0;
        }

        if(stones.length == 1) {
            return stones[0];
        }

        insertSort(stones, 0, stones.length - 1);
        int start = 1;
        for(int i = start; i < stones.length; i++) {
            stones[i] = stones[i - 1] - stones[i];
            insertSort(stones, i, stones.length - 1);
            start++;
        }
        return stones[start - 1];
    }

    public void insertSort(int[] arr, int start, int end) {
        for(int i = start; i < end; i++) {
            if (arr[i] < arr[i + 1]) {
                int j = i + 1;
                loop:
                while(j > 0) {
                    if(arr[j - 1] < arr[j]) {
                        exchange(arr, j - 1, j);
                    } else {
                        break loop;
                    }
                    j--;
                }
            }
        }
    }

    void exchange(int[] arr, int i, int j) {
        arr[i] = arr[i] + arr[j];
        arr[j] = arr[i] - arr[j];
        arr[i] = arr[i] - arr[j];
    }

    /**
     * A clean solution by using priority queue.
     * 
     * @param A
     * @return
     */
    public int lastStoneWeightPQ(int[] A) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)-> b - a);
        for (int a : A)
            pq.offer(a);
        while (pq.size() > 1)
            pq.offer(pq.poll() - pq.poll());
        return pq.poll();
    }
}
