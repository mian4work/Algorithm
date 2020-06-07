/*
    You are given coins of different denominations and a total amount of money. Write a function to compute the number
    of combinations that make up that amount. You may assume that you have infinite number of each kind of coin.

    Example 1:

    Input: amount = 5, coins = [1, 2, 5]
    Output: 4
    Explanation: there are four ways to make up the amount:
    5=5
    5=2+2+1
    5=2+1+1+1
    5=1+1+1+1+1

    Example 2:

    Input: amount = 3, coins = [2]
    Output: 0
    Explanation: the amount of 3 cannot be made up just with coins of 2.

    Example 3:

    Input: amount = 10, coins = [10]
    Output: 1


    Note:

    You can assume that

    0 <= amount <= 5000
    1 <= coin <= 5000
    the number of coins is less than 500
    the answer is guaranteed to fit into signed 32-bit integer
 */
public class Solution {
    /**
     * This is a typical backpack problem.
     *
     * The algorithm is:
     *
     *      1. construct a 2d array dp where row is coins and column is from [0..amount]
     *      2. for a coin 'c' at an amount 'a':
     *          get the total ways to form this amount a without this coin c
     *          plus the total ways to form the amount (c - a) (if c >= a). it is the value at (c - a) in the same row.
     *          if c < a, get the value from row - 1, which is the value without this coin.
     *
     *          one thing needed to note: initialize the first column 0 to 1.
     *
     *          example with coin 1, 2, 5 and total amount is 5
     *
     *          0  1 2 3 4 5     <-- the amount 0..5
     *        0 0  0 0 0 0 0
     *        1 1  1 1 1 1 1
     *        2 1  1 2 2 3 3
     *        5 1  1 2 2 3 4
     *
     *          ^: initialized to 1 (otherwise the result is 1 less)
     *        ^: coins
     * @param amount
     * @param coins
     * @return
     */
    public int change(int amount, int[] coins) {
        if(coins == null || coins.length == 0) {
            return 0;
        }

        int[][] dp = new int[coins.length + 1][amount + 1];
        //initialize the value==0 to 1 except the first one [0][0]
        dp[0][0] = 1;

        for(int i = 1; i <= coins.length; i++) {
            dp[i][0] = 1;
            for(int j = 1; j <= amount; j++) {
                dp[i][j] = dp[i - 1][j] + (j >= coins[i - 1] ? dp[i][j - coins[i - 1]] : 0);
            }
        }

        return dp[coins.length][amount];
    }
    /**
     * The first try failed. I thought too much.
     *
     * My own algorithm:
     *
     *      1. construct a 2d dp array which column is from 0 to amount, row is 0 and coins
     *      2. column 0 means how many coins to form value 0? of course 0
     *      3. row 0 means with 0 coin, how many way to form value? of course 0
     *      4. on each row (represent the coin value):
     *          if coin value == column value, fill with upper row's value + 1
     *          if coin value > column value, means it contribute nothing to column value, use left column value
     *          if coin value < column value, use (column value - coin value) to get an index, use this index
     *              to check the value in [same row, index column] + 1
     * @param amount
     * @param coins
     * @return
     */
    public int changeFirstTry(int amount, int[] coins) {
        if(coins == null || coins.length == 0) {
            return 0;
        }

        int[][] dp = new int[coins.length + 1][amount + 1];
        for(int i = 0; i < coins.length; i++) {
            int row = i + 1;
            for(int j = 0; j < amount; j++) {
                int col = j + 1;
                if(coins[i] == col) {
                    dp[row][col] = dp[row - 1][col] + 1;
                } else if(coins[i] > col) {
                    dp[row][col] = dp[row][col - 1];
                } else if(coins[i] < col) {
                    dp[row][col] = dp[row][col - coins[i]] + 1;
                }
            }
        }

        return dp[coins.length][amount];
    }
}
