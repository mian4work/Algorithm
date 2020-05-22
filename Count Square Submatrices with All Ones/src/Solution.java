/*
    Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.

    Example 1:

    Input: matrix =
    [
      [0,1,1,1],
      [1,1,1,1],
      [0,1,1,1]
    ]
    Output: 15
    Explanation:
    There are 10 squares of side 1.
    There are 4 squares of side 2.
    There is  1 square of side 3.
    Total number of squares = 10 + 4 + 1 = 15.

    Example 2:

    Input: matrix =
    [
      [1,0,1],
      [1,1,0],
      [1,1,0]
    ]
    Output: 7
    Explanation:
    There are 6 squares of side 1.
    There is 1 square of side 2.
    Total number of squares = 6 + 1 = 7.


    Constraints:

    1 <= arr.length <= 300
    1 <= arr[0].length <= 300
    0 <= arr[i][j] <= 1
 */
public class Solution {
    /**
     * Need to know the solution. See video: https://www.youtube.com/watch?v=Z2h3rkVXPeQ
     *      1. create a dp[][]
     *      2. for each cell (i, j) in dp:
     *          a. when i==0 or j==0, populate the firs row or first column with matrix's data
     *          b. if dp[i][j] is min(matrix[i][j-1], matrix[i-1][j], matrix[i-1][j-1]) + matrix[i][j]
     *              why? see the video
 *              c. add dp one by one.
     *
     * @param matrix
     * @return
     */
    public int countSquares(int[][] matrix) {
        if(matrix == null || matrix.length == 0) {
            return 0;
        }
        int[][] dp = new int[matrix.length][matrix[0].length];
        dp[0][0] = matrix[0][0];
        for(int i = 1; i < matrix.length; i++) {
            dp[i][0] = matrix[i][0];
        }
        for(int j = 1; j < matrix[0].length; j++) {
            dp[0][j] =  matrix[0][j];
        }
        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[i].length; j++) {
                dp[i][j] = matrix[i][j] == 0 ? 0 : Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1])
                        + matrix[i][j];
            }
        }

        int ans = 0;
        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[i].length; j++) {
                ans += dp[i][j];
            }
        }

        return ans;
    }
}
