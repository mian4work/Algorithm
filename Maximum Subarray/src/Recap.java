import java.util.Arrays;
import java.util.Collections;

public class Recap {
    /**
     * The best explaination of dp:
     *  https://medium.com/@rsinghal757/kadanes-algorithm-dynamic-programming-how-and-why-does-it-work-3fd8849ed73d
     *
     * The main idea is so called backtracking. Assume at i-1, we know the max dp(i-1) (calculated repeatedly from 0..n-1),
     * then the max at i is the maximum value between arr[i] and (arr[i] + dp(i-1)).
     *
     * The idea is clear so we don't even need the dp array. We only need a max to hold the max value at each steps.
     * Think about the first one arr[0], if the array has only one element, the max is arr[0].
     *
     * @param arr
     * @return
     */
    public int maxSubArray(int[] arr) {
        if(arr == null || arr.length == 0) {
            return 0;
        }

        int localMax = arr[0];
        int globalMax = -Integer.MAX_VALUE;
        for(int i = 1; i < arr.length; i++) {
            localMax = Math.max(arr[i], localMax + arr[i]);
            globalMax = Math.max(globalMax, localMax);
        }

        return globalMax;
    }

    /**
     * This is the same with above but using a dp to track the local max
     *
     * @param arr
     * @return
     */
    public int maxSubArrayDP(int[] arr) {
        if(arr == null || arr.length == 0) {
            return 0;
        }

        int[] dp = new int[arr.length];
        dp[0] = arr[0]; //image the one element array.
        for(int i = 1; i < arr.length; i++) {
            dp[i] = Math.max(arr[i], arr[i] + dp[i - 1]);
        }

        int max = -Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++) {
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
