import java.util.ArrayDeque;
import java.util.Deque;

/*
    Given an array of integers and a number k, where 1 <= k <= length of the array, compute the maximum values of
    each subarray of length k.

    For example, given array = [10, 5, 2, 7, 8, 7] and k = 3, we should get: [10, 7, 8, 8], since:

    10 = max(10, 5, 2)
    7 = max(5, 2, 7)
    8 = max(2, 7, 8)
    8 = max(7, 8, 7)

    Do this in O(n) time and O(k) space. You can modify the input array in-place and you do not need to
    store the results. You can simply print them out as you compute them.
 */
public class Solution {

    public void maxValueBruteForce(int[] arr, int k) {
        if(arr == null || arr.length == 0 || k < 1 || k > arr.length) {
            System.out.println("Not valid");
            return;
        }

        for(int i = 0; i <= arr.length - k; i++) {
            int max = Integer.MIN_VALUE;
            for(int j = i; j < i + k; j++) {
                max = Math.max(max, arr[j]);
            }
            System.out.print("[" + max + "]");
        }

        System.out.println();
    }

    /**
     * This is so complicated.
     *
     * refer to video: https://www.youtube.com/watch?v=39grPZtywyQ
     *
     * These two data points suggest an idea: we can keep a double-ended queue with max size k and only keep what
     * we need to evaluate in it. That is, if we see [1, 3, 5], then we only need to keep [5], since we know
     * that 1 and 3 cannot possibly be the maxes.
     *
     * So what we can do is maintain an ordered list of indices, where we only keep the elements we care about,
     * that is, we will maintain the loop invariant that our queue is always ordered so that we only keep the
     * indices we care about (i.e, there are no elements that are greater after, since we would just pick the
     * greater element as the max instead).
     *
     * It will help to go over an example. Consider our test input: [10, 5, 2, 7, 8, 7] and k = 3.
     * Our queue at each step would look like this (recall that these are indices):
     *
     * Pre-processing:
     *
     * After processing 10: [0] After processing 5: [0, 1] # 5 is smaller than 10, and 10 is still valid until
     * we hit the 3rd index After processing 2: [0, 1, 2] # 2 is smaller than 5, and 10 is still valid
     *
     * Main Loop
     * Print value of first element in our queue: 10
     *
     * After processing 7: [4] # 10 is no longer valid (we can tell since the current index - 0 > k),
     * so we dequeue from the front. 7 is bigger than 5 and 2, so we get rid of them from the back and
     * replace it with the 7
     *
     * Print value of first element in our queue: 7
     *
     * After processing 8: [5] # 8 is bigger than 7, so no point in keeping 7 around.
     * We get rid of it from the back and replace it with the 8
     *
     * Print value of first element in our queue: 8
     *
     * After processing 7: [5, 4] # 7 is smaller than 8, so we enqueue it from the back
     *
     * Print value of first element in our queue: 8
     *
     * @param arr
     * @param k
     */
    public void maxValueDeque(int[] arr, int k) {
        if(arr == null || arr.length == 0 || k < 1 || k > arr.length) {
            System.out.println("Not valid");
            return;
        }

        Deque<Integer> deque = new ArrayDeque<>();

        deque.addLast(0);
        for(int i = 1; i < k; i++) {
            while(arr[i] > arr[deque.peekLast()]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }

        for(int i = k; i < arr.length; i++) {
            System.out.print("[" + arr[deque.peekFirst()] + "]");
            if(deque.peekFirst()!= null && i - deque.peekFirst() >= k) { //means first element in deque is out of k window
                deque.removeFirst();
            }

            while(deque.peekLast() != null && arr[i] > arr[deque.peekLast()]) {
                deque.removeLast();
            }

            deque.addLast(i);
        }
        System.out.print("[" + arr[deque.peekFirst()] + "]"); //this is for last one since the loop is done.
        System.out.println();
    }
}
