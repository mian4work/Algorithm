/*
    Given an unsorted array of integers, find the length of longest increasing subsequence.

    For example,
    Given [10, 9, 2, 5, 3, 7, 101, 18],
    The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4.

    Note that there may be more than one LIS combination, it is only necessary for you to return the length.

    Your algorithm should run in O(n2) complexity.

    Follow up: Could you improve it to O(n log n) time complexity?
 */
public class Solution {

    /**
     * Time complexity is O(n^2)
     *
     * Loop each element in arr. For each element i, set max = arr[i] and loop rest of elements j to see if arr[j] > max,
     *      if so, set max to arr[j] and count plus 1
     *      if no, keep moving j
     *
     * For each count, select the largest one.
     *
     * @param arr
     * @return
     */
    public int lengthOfLIS(int[] arr) {
        if(arr == null || arr.length == 0) {
            return 0;
        }

        int len = 0;

        for(int i = 0; i < arr.length; i++) {
            int count = 1, max = arr[i];
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[j] > max) {
                    max = arr[j];
                    count++;
                }
            }

            len = Math.max(len, count);
        }

        return len;
    }

    /**
     * We don't have to loop in another loop. We can just loop once.
     * Use len to dynamically record the final length
     * For each element i, compare with next element i+1
     *      if arr[i+1] > arr[i]: count + 1
     *      else set count back to 1
     *      every step, len == max(len, count)
     *
     *      return len
     *
     * Time complexity: O(n)
     *
     * @param arr
     * @return
     */
    public int lengthOfLISImprove(int[] arr) {
        if(arr.length == 0) {
            return 0;
        }
        int count = 1, maxLen = 1;
        for(int i = 0; i < arr.length - 1; i++) {
            if(arr[i+1] > arr[i]) {
                count++;
                maxLen = Math.max(count, ++maxLen);
            } else {
                count = 1;
            }
        }

        return maxLen;
    }
}
