import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
    This problem was asked by Google.

    Given a list of integers S and a target number k, write a function that returns a subset of S that adds up to k.
    If such a subset cannot be made, then return null.

    Integers can appear more than once in the list. You may assume all numbers in the list are positive.

    For example, given S = [12, 1, 61, 5, 9, 2] and k = 24, return [12, 9, 2, 1] since it sums up to 24.
 */
public class Solution {

    /**
     * Using Dynamic programming but it can only tell if there is a subset which added to k. It can't tell the exact
     * subset.
     *
     * @see <a href="https://www.youtube.com/watch?v=K20Tx8cdwYY">Detailed explaination of dynamic programming</a>
     *
     * Form a 2-D boolean array dp.
     *      1. row: the element in the array starting from 0
     *      2. column: every element from 0..k
     *
     * For each cell, to determine it is true or false is based on:
     *      1. the row value is called new value
     *      2. with this new value, we can check if it can form column value (column value is 0..k, one by one)
     *      3. without this new value (it means the result in upper row: exclue this row) if it can form column value.
     *      4.the result is:
     *      (with the new value, if we can construct column data) || (without it, if we can do so)
     *
     *      5. to simplify the althorithm, the result is:
     *          if row value > column, copy row - 1's value
     *          if row value < column, check if exact upper cell's result (true/false) dp[i - 1][j]
     *              || dp[i - 1][(colunm) - (row value)]
     *
     * The last cell in dp[S.len + 1][k + 1] is the result.
     *
     * We can actually find all result of m <= k in the dp table.
     *
     *
     * @param S
     * @param k
     * @return
     */
    public boolean subSetDynamicProgramming(int[] S, int k) {
        if(S == null || S.length == 0) {
            return false;
        }

        boolean[][] dp = new boolean[S.length + 1][k + 1];
        dp[0][0] = true;
        for(int element = 1; element < dp.length; element++) {
            for(int sum = 0; sum < dp[element].length; sum++) {
                if(S[element - 1] > sum) {
                    dp[element][sum] = dp[element - 1][sum];
                } else {
                    int index = sum - S[element - 1];
                    dp[element][sum] = dp[element - 1][sum] || dp[element - 1][index];
                }
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];
    }

    public int[] subSetBackTracking(int[] S, int k) {
        if(S == null || S.length == 0) {
            return null;
        }

        List<Integer> list = new ArrayList<>();
        List<Integer> sumList = new ArrayList<>();
        helper(S, k, list, sumList, 0);

        return list.size() == 0 ? null : convert(list);
    }

    void helper(int[] S, int k, List<Integer> list, List<Integer> sumList, int i) {
        if(i > S.length) {
            return;
        }

        list.add(S[i]);
        int sum = sumList.size() == 0 ? 0 : sumList.get(sumList.size() - 1);
        sum += S[i];
        sumList.add(sum);

        if(sum == k) {
            return;
        }

        if(sum > k) {
            list.remove(list.size() - 1);
            sumList.remove(sumList.size() - 1);
        }

        helper(S, k, list, sumList, i + 1);
    }

    /**
     * Brute force will not working.
     *
     * What we need to try is to form a tree where each element add all other elements respectively.
     *
     * @param S
     * @param k
     * @return
     */
    public int[] subSetBruteForce(int[] S, int k) {
        if(S == null || S.length == 0) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        for(int i = 0; i < S.length - 1; i++) {
            list = new ArrayList<>();
            sum = S[i];
            list.add(S[i]);

            if(sum == k) {
                return convert(list);
            } else if (sum > k) {
                continue;
            }

            for(int j = i + 1; j < S.length; j++) {
                sum += S[j];
                list.add(S[j]);
                if(sum == k) {
                    return convert(list);
                } else if(sum < k) {
                    continue;
                } else {
                    sum -= S[j];
                    list.remove(list.size() - 1);
                }
            }
        }

        return list.size() == 0 ? null : convert(list);
    }

    int[] convert(List<Integer> list) {
        int[] ans = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
