import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
    You are given coins of different denominations and a total amount of money amount.
    Write a function to compute the fewest number of coins that you need to make up that amount.
    If that amount of money cannot be made up by any combination of the coins, return -1.

    Example 1:

    Input: coins = [1, 2, 5], amount = 11
    Output: 3
    Explanation: 11 = 5 + 5 + 1

    Example 2:

    Input: coins = [2], amount = 3
    Output: -1

    Note:
    You may assume that you have an infinite number of each kind of coin.
 */

/**
 * @see <a href="https://www.youtube.com/watch?v=jgiZlGzXMBw">Dynamic Programming solution</a>
 */
public class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount == 0) {
            return 0;
        }
    }
    /**
     * Top down dynamic programming.
     *
     * Algorithm: assuming we have a function coinSelect([1,2,5], 11) to get the result.
     *      1. from amount 11, we can try 3 coins [1,2,5] one by one.
     *          when try 1: we deduct 1 from amount and try coinSelect([1,2,5], 10)
     *          when try 2: we deduct 2 from amount and try coinSelect([1,2,5], 9)
     *          when try 5: we deduct 5 from amount and try coinSelect([1,2,5], 6)
     *      2. let's try last one amount 6, try 3 coins again.
     *          when try 1: we deduct 1 from amount and try coinSelect([1,2,5], 5)
     *          when try 2: we deduct 2 from amount and try coinSelect([1,2,5], 4)
     *          when try 5: we deduct 5 from amount and try coinSelect([1,2,5], 1)
     *      3. let's try last one amount 1, try 3 coins again.
     *          when try 1: we deduct 1 from amount and stop because the result is 0
     *          when try 2: we deduct 2 from amount and stop because the result is negative
     *          when try 5: we deduct 5 from amount and stop because the result is negative
     *      4. along the call, add 1 for each step to see we can get 0.
     *      5. also along the call, memo the remain for reuse.
     *
     * A diagram shows how top down works:
     * @see <a href="https://assets.leetcode.com/static_assets/media/original_images/322_coin_change_tree.png">Coin Change Tree</a>
     * @param coins
     * @param amount
     * @return
     */
    public int coinChangeTopDown(int[] coins, int amount) {
        if(coins == null || coins.length == 0 || amount == 0) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        return coinSelect(coins, amount, map);
    }

    //rem means the remain of the money
    int coinSelect(int[] coins, int rem, Map<Integer, Integer> memo){
        if(rem == 0) {
            return 0; //it is leaf node so no more coin. return 0
        }

        if(rem < 0) {
            return -1;
        }

        if(memo.containsKey(rem)) {
            return memo.get(rem);
        }

        int minSelect = Integer.MAX_VALUE;
        for(int coin : coins) {
            int rest = coinSelect(coins, rem - coin, memo);
            minSelect = rest >= 0 ? Math.min(minSelect, rest + 1) : minSelect; //since it may return -1, we can't simply add up
        }

        //if minSelect is unchanged, we memo and return -1
        memo.put(rem, minSelect == Integer.MAX_VALUE ? -1 : minSelect);
        return memo.get(rem);
    }

    /**
     * My first try. failed a couple of times and finally exceed the time limit.
     *
     * The main idea is
     *      1. sort the coins
     *      2. use the largest coin first. add up to amount
     *      3. if the total > amount, remove the last add and move to next coin (smaller) and keep adding up
     *      4. repeat until either found the right combine or nothing
     *      5. if nothing return from the largest coin, reset and try the second largest coin
     *      6. repeat the above steps.
     *
     * This is a intuitive way to solve the problem but it can also be solved by using Kedane's algorithm
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChangeFirstTry(int[] coins, int amount) {
        if(coins == null || coins.length == 0 || amount == 0) {
            return 0;
        }

        Arrays.sort(coins);

        int len = coins.length - 1;
        while(len >= 0) {
            int[] sum = new int[1], count = new int[1];
            if(coins[len] > amount) {
                len--;
                continue;
            } else if(coins[len] == amount){
                return 1;
            } else {
                calculate(coins, amount, sum, count, len);
                if(count[0] > 0) {
                    return count[0];
                }
            }
            len--;
        }

        return -1;
    }

    //assuming the coins is sorted
    void calculate(int[] coins, int amount, int[] sum, int[] count, int index) {
        if(index < 0) {
            return;
        }

        int value = coins[index];
        while(sum[0] < amount) {
            sum[0] += value;
            count[0]++;
            if (sum[0] == amount) {
                return;
            } else if (sum[0] > amount) {
                sum[0] -= value;
                count[0]--;
                calculate(coins, amount, sum, count, index - 1);
            }
        }
    }
}
