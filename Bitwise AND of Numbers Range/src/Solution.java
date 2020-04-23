/*
    Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

    Example 1:

    Input: [5,7]
    Output: 4
    Example 2:

    Input: [0,1]
    Output: 0
 */
public class Solution {
    /**
     * Very smart solution and easy understand.
     *
     * Let's say m = 5 and n = 7, what is the Most Significant Bit (MSB) in both numbers?
     * The MSB is like this:
     *  Example 1:
     *      5 and 7
     *      101 (5)
     *      111 (7)
     *      the  MSB is on the first bit
     *
     * Example 2:
     *      2 and 7
     *      010 (2)
     *      111 (7)
     *      the MSB is on the second bit
     *
     * One MSB is found, the right side of MSB will all be zero because any COLUMN of bits will have a 0 which will
     * makes the overall bitwise AND to 0
     *
     * Based on this, we can shift m and n to right until they are bitwise same and remember how many times we shifted
     * Then shift the smaller one m back to shifted times (filled with 0)
     *
     * For 2 and 7, the shift will stop at 0 instead of 1
     * For 5 and 7, the shift will stop at first bit 1
     *
     *
     * @param m
     * @param n
     * @return
     */
    public int rangeBitwiseAnd(int m, int n) {
        int shift = 0;
        while(m != n) {
            m = m >> 1;
            n = n >> 1;
            shift++;
        }

        return m << shift;
    }

    /**
     * The brute force cause time limit exceeded when calculating 2147483647
     * @param m
     * @param n
     * @return
     */
    public int rangeBitwiseAndBruteForce(int m, int n) {
        for(int i = m + 1; i <= n; i++) {
            m = m & i;
        }
        return m;
    }
}
