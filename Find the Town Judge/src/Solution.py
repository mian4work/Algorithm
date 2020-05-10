from typing import List


class Solution:
    def findJudge(self, N: int, trust: List[List[int]]) -> int:
        counter = [0] * (N + 1)
        for a, b in trust:
            counter[a] -= 1
            counter[b] += 1
        for i in range(1, N + 1):
            if counter[i] == N - 1:
                return i
        return -1


print(Solution().findJudge(4, [[1, 3], [1, 4], [2, 3], [2, 4], [4, 3]]))
