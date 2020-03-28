/*
    Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

    Example:

    Input: s = 7, nums = [2,3,1,2,4,3]
    Output: 2
    Explanation: the subarray [4,3] has the minimal length under the problem constraint.

    Follow up:
    If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
 */
public class Solution {
    /**
     * Flexible window size problem.
     *
     * Keep adding element to currentWindowSum until it is >= s.
     *
     * Once it is >= s, it is time to move left pointer 'windowStart' to shrink the size of the sub array to see if
     * it is >= s. At the same time, record the min length
     *
     * Notice: we don't need a 'if' to check if it is >= s, we can direct use a 'while' loop to check.
     *
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen(int s, int[] nums) {
        int currentWindowSum = 0;
        int minWindowSize = Integer.MAX_VALUE;
        int windowStart = 0;

        for(int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            currentWindowSum += nums[windowEnd];

            while (currentWindowSum >= s) {
                minWindowSize = Math.min(windowEnd - windowStart + 1, minWindowSize);
                currentWindowSum -= nums[windowStart];
                windowStart++;
            }
        }
        return minWindowSize == Integer.MAX_VALUE ? 0 : minWindowSize;
    }
}
