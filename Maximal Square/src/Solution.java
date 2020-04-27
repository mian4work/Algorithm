/*
    Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

    Example:

    Input:

    1 0 1 0 0
    1 0 1 1 1
    1 1 1 1 1
    1 0 0 1 0

    Output: 4
 */
public class Solution {
    /**
     * We can go brute force but it is not the best way to go.
     *
     * By using dynamic programming, we can calculate it step by step.
     *
     * For matrix[len1][len2], create a 2D array dp[len1][len2]:
     *      each cell [i, j] of dp,
     *          if matrix[i][j] is 1: we look back to its around: [i-1][j], [i][j-1], [i-1][j-1].
     *              if any part is 0, it can't construct a squire.
     *              if they are all 1, it is a squire with size 2
     *              so we need to simply find the min([i-1][j], [i][j-1], [i-1][j-1]) and add 1 to it. then set to dp.
     *          if matrix[i][j] is 0: we can't construct a squire, just set dp to 0
     *
     *      at the same time, find the max value of dp on the way.
     *
     * After the max is found, simply return max * max because it is a squire.
     *
     * @see <a href="https://assets.leetcode.com/static_assets/media/original_images/221_Maximal_Square.PNG?raw=true">Diagram</a>
     *
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0) {
            return 0;
        }
        int[][] dp = new int[matrix.length][matrix[0].length];
        int max = 0;
        //populate the first row and first col in dp table.
        for(int i = 0; i < Math.max(matrix.length, matrix[0].length); i++) {
            if(i < matrix.length && matrix[i][0] == '1') {
                dp[i][0] = 1;
                max = Math.max(max, dp[i][0]);
            }

            if(i < matrix[0].length && matrix[0][i] == '1') {
                dp[0][i] = 1;
                max = Math.max(max, dp[0][i]);
            }
        }
        //populate dp with min([i-1,j], [i,j-1],[i-1,j-1])+1 when matrix[i][j]==1
        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][j] == '1') {
                    int min = Math.min(dp[i - 1][j], dp[i][j - 1]);
                    min = Math.min(min, dp[i - 1][j - 1]);
                    dp[i][j] = min + 1;
                }
                max = Math.max(max, dp[i][j]);
            }
        }

        return max * max;
    }
}
