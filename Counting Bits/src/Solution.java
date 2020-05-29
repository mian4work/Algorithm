/*
    Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's
    in their binary representation and return them as an array.

    Example 1:

    Input: 2
    Output: [0,1,1]
    Example 2:

    Input: 5
    Output: [0,1,1,2,1,2]
    Follow up:

    It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear
    time O(n) /possibly in a single pass?
    Space complexity should be O(n).
    Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any
    other language.
 */
public class Solution {
    /**
     * The solution is from reference.
     *
     * This problem looks hard but if we use dp, it is easy to solve.
     *
     * We know the bits of 0 is 0 so we have a dp[] from 0 to num.
     *
     * The next one, let's say 1. the result is moving out of last one (use either 1/2 or 1 >> 1) to get the result from
     * dp[0] and use 1%2 to get the last bit, add them together
     *
     * Another example: 10
     *      10/2 == 5, or 10>>1 == 5, let's retrieve the count in dp[5]
     *      then example the last bit 10%2 == 0
     *      so the result equals to dp[5]
     *      save to dp[10] for future reference
     *
     * @param num
     * @return
     */
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        for(int i = 1; i <= num; i++) {
            ans[i] = ans[i / 2] + i % 2;
        }
        return ans;
    }
}
