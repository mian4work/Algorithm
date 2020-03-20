/*
    A robot is located at the top-left corner of a m * n grid (marked ‘Start’ in the diagram below).

    The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid
    (marked ‘Finish’ in the diagram below).

    How many possible unique paths are there?

    o * * * a * *
    * * * b c * *
    * * * * * * f

    Above is a 3 x 7 grid. How many possible unique paths are there?

    Note: m and n will be at most 100.
 */
public class Solution {

    /**
     * Failed by first try. Refer to solution: https://zxi.mytechroad.com/blog/dynamic-programming/leetcode-62-unique-paths/
     *
     * The idea is: at any point (m, n), the path is the sum of path at (m - 1, n) and path at (m, n - 1).
     *      See above chart, path to 'c' equals path to 'a' + path to 'b'.
     *      When m==1 and n==1, return 1 always.
     *      When m < 0 or n < 0, return 0.
     *
     * Use an Integer[][] to save the already calculated path for example: path(1, 2) if we want to memorized it
     * @param m
     * @param n
     * @return
     */
    int uniquePathsDP(int m, int n) {

        if (m > 100 || n > 100) {
            return 0;
        }

        if(m < 0 || n < 0) {
            return 0;
        }

        if(m == 1 || n == 1) {
            return 1;
        }

        return uniquePathsDP(m - 1, n) + uniquePathsDP(m, n - 1);
    }

    /**
     * Use a two dimension array matrix to hold results.
     *
     * At any point (i, j):
     *      if i == 0 && j == 0: matrix[0, 0] = 1
     *      if i == 0: matrix[0, j] = 1;
     *      if j == 0: matrix[i, 0] = 1;
     *      else:
     *          matrix[i, j] = matrix[i - 1, j] + matrix[i, j - 1]
     *
     * Same logic with above solution.
     *
     * @param m
     * @param n
     * @return
     */
    int uniquePathsArray(int m, int n) {
        if (m > 100 || n > 100) {
            return 0;
        }

        int[][] matrix = new int[m][n];

        matrix[0][0] = 1;

        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                if(i == 0) {
                    matrix[0][j] = 1;
                } else if(j == 0) {
                    matrix[i][j] = 1;
                } else {
                    matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1];
                }
            }
        }

        return matrix[m - 1][n - 1];
    }
}
