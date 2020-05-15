from typing import List


class Solution:
    def maxSubarraySumCircular(self, A: List[int]) -> int:
        cur_max, cur_min, max_sum, min_sum, total = 0, 0, -30000, 30000, 0
        for a in A:
            cur_max = max(cur_max + a, a)
            max_sum = max(max_sum, cur_max)
            cur_min = min(cur_min + a, a)
            min_sum = min(min_sum, cur_min)
            total += a
        if max_sum > 0:
            return max(max_sum, total - min_sum)
        else:
            return max_sum


print(Solution().maxSubarraySumCircular([3, -2, 2, -3]))
print(Solution().maxSubarraySumCircular([5, -3, 5]))
