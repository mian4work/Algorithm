import java.util.HashMap;
import java.util.Map;

/*
    Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes
    the sum of all numbers along its path.

    Note: You can only move either down or right at any point in time.

    Example:

    Input:
    [
      [1,3,1],
      [1,5,1],
      [4,2,1]
    ]
    Output: 7
    Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */
public class Solution {

    private int m = 0, n = 0;

    /**
     * Using dynamic programming without using another storage. Just change the grid cells on the way right and down.
     *
     * 84.96%
     *
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }

        m = grid.length;
        n = grid[0].length;

        for(int i = 1; i < Math.max(m, n); i++) {
            if(i < m) {
                grid[i][0] += grid[i - 1][0];
            }
            if(i < n) {
                grid[0][i] += grid[0][i - 1];
            }
        }

        for(int i = 1; i < grid.length; i++) {
            for(int j = 1; j < grid[i].length; j++) {
                int value = grid[i][j];
                grid[i][j] = Math.min(grid[i - 1][j] + value, grid[i][j - 1] + value);
            }
        }

        return grid[m - 1][n - 1];
    }

    /**
     * Use recursion but time exceed limits.
     *
     * The idea is simple but the most IMPORTANT point is how to treat the coordinate which is out of bound.
     * Originally set to 0 but since we are calculating the min path,
     *      1. we need to check if next point is out of bound
     *      2. if so, set the result to MAX VALUE.
     *
     * @param grid
     * @return
     */
    public int minPathSumTimeExceedLimit(int[][] grid) {
        if(grid == null) {
            return 0;
        }
        m = grid.length;
        n = grid[0].length;

        if(m == 0) {
            return 0;
        }

        Map<Integer[], Integer> cache = new HashMap<>();

        return minPath(grid, cache, 0, 0);
    }

    int minPath(int[][] grid, Map<Integer[], Integer> cache, int i, int j) {
        if(i == m - 1 && j == n - 1) {
            return grid[i][j];
        }

        Integer[] c = new Integer[2];
        c[0] = i;
        c[1] = j;

        if(cache.containsKey(c)) {
            return cache.get(c);
        }

        int right = Integer.MAX_VALUE, down = Integer.MAX_VALUE;

        if(i + 1 <= m - 1) {
            right = grid[i][j] + minPath(grid, cache, i + 1, j);
        }

        if(j + 1 <= n - 1) {
            down = grid[i][j] + minPath(grid, cache, i, j + 1);
        }

        int ans = Math.min(right, down);
        cache.put(c, ans);

        return ans;
    }
}
