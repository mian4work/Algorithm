public class Solution {
    /**
     * Done by myself. Use a boolean matrix to mark all connected '1' to true from one '1'.
     *
     * If [i, j] is 1 and matrix is false, count once and traverse to mark connected '1' to true.
     *
     * The mistake committed is a wrong thought: since we use loop to scan from left to right, we don't have to
     * traverse to left and up to mark the boolean matrix. No this is wrong. Example:
     *
     * {'1','0','1','1','1'}
     * {'1','0','1','0','1'}
     * {'1','1','1','0','1'}
     *
     * Notice that we have to traverse up to mark connected '1' to true from [2, 2]
     *
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int sum = 0;
        boolean[][] matrix = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == '1' && !matrix[i][j]) {
                    sum++;
                    mark(grid, matrix, i, j);
                }
            }
        }

        return sum;
    }

    void mark(char[][] grid, boolean[][] matrix, int i, int j) {
        if(i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length - 1) {
            return;
        }

        if(grid[i][j] == '1' && !matrix[i][j]) {
            matrix[i][j] = true;
            mark(grid, matrix, i, j - 1);
            mark(grid, matrix, i, j + 1);
            mark(grid, matrix, i - 1, j);
            mark(grid, matrix, i + 1, j);
        }
    }

    int y;          // The height of the given grid
    int x;          // The width of the given grid
    char[][] g;     // The given grid, stored to reduce recursion memory usage

    /**
     * A similar solution but more concise. The key is to mark visited island to '0' so it will not be visited again.
     * It saves the space.
     *
     * Given a 2d grid map of '1's (land) and '0's (water),
     * count the number of islands.
     *
     * This method approaches the problem as one of depth-first connected
     * components search
     * @param grid, the given grid.
     * @return the number of islands.
     */
    public int numIslandsLeetCode(char[][] grid) {
        // Store the given grid
        // This prevents having to make copies during recursion
        g = grid;

        // Our count to return
        int c = 0;

        // Dimensions of the given graph
        y = g.length;
        if (y == 0) return 0;
        x = g[0].length;

        // Iterate over the entire given grid
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (g[i][j] == '1') {
                    dfs(i, j);
                    c++;
                }
            }
        }
        return c;
    }

    /**
     * Marks the given site as visited, then checks adjacent sites.
     *
     * Or, Marks the given site as water, if land, then checks adjacent sites.
     *
     * Or, Given one coordinate (i,j) of an island, obliterates the island
     * from the given grid, so that it is not counted again.
     *
     * @param i, the row index of the given grid
     * @param j, the column index of the given grid
     */
    private void dfs(int i, int j) {

        // Check for invalid indices and for sites that aren't land
        if (i < 0 || i >= y || j < 0 || j >= x || g[i][j] != '1') return;

        // Mark the site as visited
        g[i][j] = '0';

        // Check all adjacent sites
        dfs(i + 1, j);
        dfs(i - 1, j);
        dfs(i, j + 1);
        dfs(i, j - 1);
    }


    /**
     * Failed try. Scan from left to right won't solve the problem because the connection may be in the middle
     *
     * Example:
     * {'1','1','1'}
     * {'0','1','0'}
     * {'1','1','1'}
     *
     * @param grid
     * @return
     */
    public int numIslandsFailed(char[][] grid) {
        int sum = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == '1'
                        && (j - 1 < 0 || grid[i][j - 1] == '0')
                        && (i - 1 < 0 || grid[i - 1][j] == '0')) {
                    sum++;
                }
            }
        }

        return sum;
    }
}
