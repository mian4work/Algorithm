import collections
from typing import List


class Solution:
    # Using recursion to do the same thing instead of dp.
    # The recursive function accept two current index a, b, in both lists
    #       if values are the same in both index, 1 + the result of next index in both list
    #       if not, get the max value between index a+1, b and a, b+1
    # Need to use dp to improve the performance
    def maxUncrossedLines(self, A: List[int], B: List[int]) -> int:
        if A is None or len(A) == 0 or B is None or len(B) == 0:
            return 0

        def line(A: List[int], B: List[int], a: int, b: int) -> int:
            if a == len(A) or b == len(B):
                return 0
            if A[a] == B[b]:
                return line(A, B, a + 1, b + 1) + 1
            return max(line(A, B, a + 1, b), line(A, B, a, b + 1))
        return line(A, B, 0, 0)

    # code copied from https://leetcode.com/problems/uncrossed-lines/discuss/282842/JavaC%2B%2BPython-DP-The-Longest-Common-Subsequence
    # need to know more about how to initialize an array
    def maxUncrossedLinesCopy(self, A: List[int], B: List[int]) -> int:
        if A is None or len(A) == 0 or B is None or len(B) == 0:
            return 0
        dp, m, n = collections.defaultdict(int), len(A), len(B)
        for i in range(m):
            for j in range(n):
                dp[i, j] = max(dp[i - 1, j - 1] + (A[i] == B[j]), dp[i - 1, j], dp[i, j - 1])
        return dp[m - 1, n - 1]


print(Solution().maxUncrossedLines([1, 4, 2], [1, 2, 4]))
print(Solution().maxUncrossedLines([2, 5, 1, 2, 5], [10, 5, 2, 1, 5, 2]))
