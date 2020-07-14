import java.util.List;
/*
    The question is to find how many connected 1s in a 2D array. Connection means left, right, up and down, not diagonal.

    Example:

    1 0 0 0
    0 1 0 0
    1 0 0 1
    1 1 1 1

    The answer is 3

    first row has one, second row has 1 and third fourth have 1
 */
public class Solution2 {
    /**
     * Use recursion to solve the problem. The trick is to find 1 first and recursively search for other 1s
     * Use a dp to remember the visited cells
     *
     * @param rows
     * @param column
     * @param grid
     * @return
     */
    int numberAmazonTreasureTrucks(int rows, int column,
                                   List<List<Integer>> grid) {
        // WRITE YOUR CODE HERE
        if((rows == 0 && column == 0) || grid == null || grid.size() == 0) {
            return 0;
        }

        int ans = 0;
        boolean[][] dp = new boolean[rows][column];

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < column; j++) {
                if(grid.get(i).get(j) == 1) {
                    ans += Math.min(1, helper(dp, grid, i, j));
                }
            }
        }

        return ans;
    }

    int helper(boolean[][] dp, List<List<Integer>> grid, int x, int y) {
        if(dp[x][y]) {
            return 0;
        }
        int count = 1;
        dp[x][y] = true;
        //up cell
        if(x > 0 && !dp[x - 1][y] && grid.get(x - 1).get(y) == 1) {
            count += helper(dp, grid, x - 1, y);
        }

        //down cell
        if(x < grid.size() - 1 && !dp[x + 1][y] && grid.get(x + 1).get(y) == 1) {
            count += helper(dp, grid, x + 1, y);
        }

        //left cell
        if(y > 0 && !dp[x][y - 1] && grid.get(x).get(y - 1) == 1) {
            count += helper(dp, grid, x, y - 1);
        }

        //right cell
        if(y < grid.get(0).size() - 1 && !dp[x][y + 1] && grid.get(x).get(y + 1) == 1) {
            count += helper(dp, grid, x, y + 1);
        }

        return count;
    }
    // METHOD SIGNATURE ENDS
}
