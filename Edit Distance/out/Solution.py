class Solution:
    def minDistance(self, word1: str, word2: str) -> int:
        if word1 is None or word2 is None:
            return 0
        len1, len2 = len(word1) + 1, len(word2) + 1
        dp = [[0] * len2 for _ in range(len1)]
        for row in range(len1):
            for col in range(len2):
                if row == 0:
                    dp[row][col] = col
                elif col == 0:
                    dp[row][col] = row
                else:
                    if word1[row - 1] == word2[col - 1]:
                        dp[row][col] = dp[row - 1][col - 1]
                    else:
                        dp[row][col] = min(dp[row - 1][col], dp[row][col - 1], dp[row - 1][col - 1]) + 1
        return dp[-1][-1]


print(Solution().minDistance("horse", "ros"))
print(Solution().minDistance("intention", "execution"))


