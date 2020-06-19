from typing import List

# the binary search version
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        if citations is None:
            return 0
        n = len(citations)
        start, end = 0, n - 1
        while start <= end:
            mid = int(start + (end - start) / 2)
            if citations[mid] == n - mid:
                return n - mid
            elif citations[mid] < n - mid:
                start = mid + 1
            elif citations[mid] > n - mid:
                end = mid - 1
        return n - start


print(Solution().hIndex([0, 1, 4, 5, 6]))
