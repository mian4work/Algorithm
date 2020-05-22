from typing import List


class Solution:
    def countSquares(self, matrix: List[List[int]]) -> int:
        if matrix is None or len(matrix) == 0:
            return 0
        rows, cols = len(matrix), len(matrix[0])
        ans = 0
        for row in range(rows):
            for col in range(cols):
                if matrix[row][col] == 1:
                    if row == 0 or col == 0:
                        ans += 1
                    else:
                        cell_val = min(matrix[row][col - 1], matrix[row - 1][col], matrix[row - 1][col - 1]) + \
                                   matrix[row][col]
                        ans += cell_val
                        matrix[row][col] = cell_val
        return ans


print(Solution().countSquares([
    [0, 1, 1, 1],
    [1, 1, 1, 1],
    [0, 1, 1, 1]
]))
