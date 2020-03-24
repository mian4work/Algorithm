/*
    Given a positive integer n, find the least number of perfect square numbers
    (for example, 1, 4, 9, 16, ...) which sum to n.

    Example 1:

    Input: n = 12
    Output: 3
    Explanation: 12 = 4 + 4 + 4.
    Example 2:

    Input: n = 13
    Output: 2
    Explanation: 13 = 4 + 9.
 */
public class Solution {
    /**
     * Brute force
     * Algorithm:
     * 1. Get square root of n --> r
     * 2. For any element in (1..r) --> i
     *      while n - i * i >= 0
     *          count++, n = n - i *
     *      min = Math.min(min, count)
     *
     * @param n
     * @return
     */
    public int numSquaresBruteForce(int n) {
        if(n == 0) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        int r = (int)Math.sqrt(n);
        for(int i = r; i >= 1; i--) {
            int steps = 0;
            int tempN = n;
            for(int j = i; j >=1; j--) {
                while (tempN - j * j >= 0) {
                    tempN -= j * j;
                    steps++;
                }
            }
            min = Math.min(min, steps);
        }

        return min;
    }
}
