import java.util.Arrays;
import java.util.HashMap;

/*
    We partition a row of numbers A into at most K adjacent (non-empty) groups, then our score is the sum of
    the average of each group. What is the largest score we can achieve?

    Note that our partition must use every number in A, and that scores are not necessarily integers.

    Example:
    Input:
    A = [9,1,2,3,9]
    K = 3
    Output: 20
    Explanation:
    The best choice is to partition A into [9], [1, 2, 3], [9]. The answer is 9 + (1 + 2 + 3) / 3 + 9 = 20.
    We could have also partitioned A into [9, 1], [2], [3, 9], for example.
    That partition would lead to a score of 5 + 2 + 6 = 13, which is worse.


    Note:

    1 <= A.length <= 100.
    1 <= A[i] <= 10000.
    1 <= K <= A.length.
    Answers within 10^-6 of the correct answer will be accepted as correct.
 */
public class Solution {
    public double largestSumOfAverages(int[] A, int K) {

        double[] dp = new double[A.length];
        Arrays.fill(dp, Double.MIN_VALUE);
        dp[0] = 0;
        dp[1] = A[0];
        //double max = Double.MAX_VALUE;
        for(int i = 2; i <= A.length; i++) {
            //max = Math.max(dp[i - 1], A[i]);
            double sum = 0.0;
            for(int j = 1; j <= K && i - j >= 0; j++) {
                //dp[i] = Math.max(dp[i - 1], A[i - 1]);
                //dp[i] = Math.max(dp[i - 2], (A[i - 1] + A[i - 2])/2);
                //dp[i] = Math.max(dp[i - 3], (A[i - 1] + A[i - 2] + A[i - 3]/3);
                dp[i] = Math.max(dp[i], Math.max(dp[i - j], (sum + A[i - j]) / j));
                sum += A[i - j];
            }
        }
        return dp[A.length];

    }
}
