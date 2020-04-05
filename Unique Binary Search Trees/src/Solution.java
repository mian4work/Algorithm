/*
    Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?

    Example:

    Input: 3
    Output: 5
    Explanation:
    Given n = 3, there are a total of 5 unique BST's:

       1         3     3      2      1
        \       /     /      / \      \
         3     2     1      1   3      2
        /     /       \                 \
       2     1         2                 3
 */
public class Solution {

    /**
     * The key concept to solve this problem is
     *      given any element i, the total unique BSTs is
     *      (total unique BSTs on left side i-1) * (total unique BSTs on right side i+1)
     *      it is the cartesian product: one change in left causes all changes in right. a combination.
     *
     * So the algorithm is sum(i, n) = sum(i-1, n) * sum(n-i, n) where 1 < i < n
     *
     * The best explanation: https://www.youtube.com/watch?v=HWJEMKWzy-Q
     *
     * @param n
     * @return
     */
    public int numTreesRecursion(int n) {
        return helper(1, n);
    }

    public int helper(int start, int end) {
        if(start >= end) {
            return 1;
        }

        int total = 0;
        for(int i = start; i <= end; i++) {
            total += helper(start, i - 1) * helper(i + 1, end);
        }
        return total;
    }

    public int numTreesDP(int n) {
        int[] dp = new int[n + 2];

        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] * dp[n - i];
        }

        return dp[n];
    }
}
