/*
    Given a circular array C of integers represented by A, find the maximum possible sum of a non-empty subarray of C.

    Here, a circular array means the end of the array connects to the beginning of the array.
    (Formally, C[i] = A[i] when 0 <= i < A.length, and C[i+A.length] = C[i] when i >= 0.)

    Also, a subarray may only include each element of the fixed buffer A at most once.
    (Formally, for a subarray C[i], C[i+1], ..., C[j], there does not exist i <= k1, k2 <= j with k1 % A.length = k2 % A.length.)



    Example 1:

    Input: [1,-2,3,-2]
    Output: 3
    Explanation: Subarray [3] has maximum sum 3

    Example 2:

    Input: [5,-3,5]
    Output: 10
    Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10

    Example 3:

    Input: [3,-1,2,-1]
    Output: 4
    Explanation: Subarray [2,-1,3] has maximum sum 2 + (-1) + 3 = 4

    Example 4:

    Input: [3,-2,2,-3]
    Output: 3
    Explanation: Subarray [3] and [3,-2,2] both have maximum sum 3
    Example 5:

    Input: [-2,-3,-1]
    Output: -1
    Explanation: Subarray [-1] has maximum sum -1


    Note:

    -30000 <= A[i] <= 30000
    1 <= A.length <= 30000
 */
public class Solution {
    /**
     * Failed at first try.
     *
     * The keys to solve this problem are:
     *      1. Kadane's algorithm where dp[i] = max(dp[i - 1] + A[i], A[i]) or min(dp[i - 1] + A[i], A[i])
     *      2. Two cases:
     *          The first is that the subarray take only a middle part, and we know how to find the max subarray sum.
     *          The second is that the subarray take a part of head array and a part of tail array.
     *          We can transfer this case to the first one.
     *
     *          See image: https://assets.leetcode.com/users/motorix/image_1538888300.png
     *
     *          The maximum result equals to the (total sum) - (minimum subarray sum).
     *
     * @param A
     * @return
     */
    public int maxSubarraySumCircular(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int total = 0, curMax = 0, curMin = 0;
        int max = -30000, min = 30000;
        //Kadane's algorithm for max and min
        for (int a : A) {
            curMax = Math.max(curMax + a, a);
            max = Math.max(max, curMax);
            curMin = Math.min(curMin + a, a);
            min = Math.min(min, curMin);
            total += a;
        }

        return max > 0 ? Math.max(max, total - min) : max;
    }
}
