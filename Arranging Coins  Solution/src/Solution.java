/*
    You have a total of n coins that you want to form in a staircase shape, where every k-th row must have
    exactly k coins.

    Given n, find the total number of full staircase rows that can be formed.

    n is a non-negative integer and fits within the range of a 32-bit signed integer.

    Example 1:

    n = 5

    The coins can form the following rows:
    ¤
    ¤ ¤
    ¤ ¤

    Because the 3rd row is incomplete, we return 2.
    Example 2:

    n = 8

    The coins can form the following rows:
    ¤
    ¤ ¤
    ¤ ¤ ¤
    ¤ ¤

    Because the 4th row is incomplete, we return 3.
 */
public class Solution {
    /**
     * Solution from leetcode. Just use math to get the result.
     *
     * Suppose we need k rows to form stairs so 1+2+3+...+k <= n, that means
     *      k*(k+1) / 2 <= n
     *      so k*(k+1) <= 2*n
     *      so k = sqrt(2*n + 1/4) - 1/2
     *
     * reference: https://leetcode.com/articles/arranging-coins/
     * @param n
     * @return
     */
    public int arrangeCoins(int n) {
        return (int)(Math.sqrt(2 * (long)n + 0.25) - 0.5);
    }
    /**
     * My first solution. It is easy but we need to set sum to long. Otherwise it will be overflow.
     * @param n
     * @return
     */
    public int arrangeCoinsFirstTry(int n) {
        if (n == 0) {
            return 0;
        }

        long sum = 0;
        int row = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
            if (sum == n) {
                row = i;
                break;
            } else if (sum > n) {
                row = i - 1;
                break;
            }
        }

        return row;
    }
}
