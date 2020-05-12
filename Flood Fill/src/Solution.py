from typing import List


class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        color, len1, len2 = image[sr][sc], len(image), len(image[0])

        def dfs(x: int, y: int):
            if x < 0 or x >= len1 or y < 0 or y >= len2:
                return
            if image[x][y] == color:
                image[x][y] = newColor
                dfs(x - 1, y)
                dfs(x, y - 1)
                dfs(x + 1, y)
                dfs(x, y + 1)

        dfs(sr, sc)
        return image


print(Solution().floodFill([[0, 0, 0], [0, 1, 1]], 1, 1, 1))
